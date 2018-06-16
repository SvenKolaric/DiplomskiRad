package com.DiplomskiRad_SK.ZivotopisIN2.services;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.CV;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.DodatneInfo;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.EdukacijaITrening;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Institucija;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Mjesto;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Osoba;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.OsobnaVjestina;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.RadnoIskustvo;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Upit;
import com.DiplomskiRad_SK.ZivotopisIN2.models.Search;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.CVRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.EdukacijaITreningRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.InstitucijaRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.JezikRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.MjestoRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.OsobaRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.RadnoIskustvoRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.UpitRepository;

@Service("SearchService")
public class SearchService {

	@Autowired
	UpitRepository upitRepo;
	@Autowired
	EdukacijaITreningRepository eduRepo;
	@Autowired
	RadnoIskustvoRepository radRepo;
	@Autowired
	MjestoRepository mjestoRepo;
	@Autowired
	InstitucijaRepository institucijaRepo;
	@Autowired
	CVRepository cvRepo;
	@Autowired
	OsobaRepository osobaRepo;

	public Set<CV> QueryCVs(List<Search> queries) {
		Set<CV> cvSet = new HashSet<>();
		List<Upit> upitList = new ArrayList<Upit>();
		Integer counterUpiti = 1;

		for (Search query : queries) {
			switch (query.getIdentifier()) {
			case "BRGOD_RADA":
				List<Object[]> cvGodRad = radRepo.findByGodRada(Integer.parseInt(query.getQuery()));
				for (Object[] row : cvGodRad)
					cvSet.add(calculateScore(cvRepo.findById(Integer.parseInt(row[0].toString())).get(),
							query.getQueryWeight(), query.getQueryVaule()));

				break;

			case "BRGOD_EDU":
				List<Object[]> cvGodEdu = eduRepo.findByGodEdu(Integer.parseInt(query.getQuery()));
				for (Object[] row : cvGodEdu)
					cvSet.add(calculateScore(cvRepo.findById(Integer.parseInt(row[0].toString())).get(),
							query.getQueryWeight(), query.getQueryVaule()));

				break;

			case "MJESTO":
				Mjesto mjesto = mjestoRepo.findByNaziv(query.getQuery());
				List<Osoba> osobaList = mjesto.getOsobaList();
				for (Osoba osoba : osobaList) {
					List<CV> cvList = osoba.getZivotopisiList();
					for (CV cv : cvList) {
						cvSet.add(calculateScore(cv, query.getQueryWeight(), query.getQueryVaule()));
					}
				}

				break;
			case "INSTITUCIJA":
				List<Institucija> instList = institucijaRepo.findAllByNaziv(query.getQuery());
				for (Institucija inst : instList) {
					List<RadnoIskustvo> radIskList = inst.getRadnoIskustvoList();
					List<EdukacijaITrening> eduList = inst.getEdukacijaTreningList();

					for (RadnoIskustvo ri : radIskList) {
						cvSet.add(calculateScore(ri.getZivotopis(), query.getQueryWeight(), query.getQueryVaule()));
					}

					for (EdukacijaITrening edu : eduList) {
						cvSet.add(calculateScore(edu.getZivotopis(), query.getQueryWeight(), query.getQueryVaule()));
					}
				}
				break;

			case "UPIT":
				upitList.add(new Upit(counterUpiti, query.getQueryWeight(), query.getQueryVaule(), query.getQuery()));
				counterUpiti++;
				break;
			}
		}

		if (!SaveQueries(upitList)) return null;

		for (CV cv : cvSet) {
			List<Upit> results = upitRepo.findUpitsInText(prepareTextForMatchesSearch(cv));

			for (Upit rez : results)
				for (Upit u : upitList)
					if (u.equals(rez))
						cv = calculateScore(cv, u.getTezina(), u.getVrijednost());

		}

		if (!DeleteAllQueries()) return null;

		for (CV cv : cvSet)
			System.out.println(cv.getScore());
		return cvSet;
	}

	private CV calculateScore(CV cv, Integer weight, Integer value) {
		Integer score = cv.getScore();
		if (score == null)
			score = 0;
		score += weight * value;
		cv.setScore(score);

		return cv;
	}

	private String prepareTextForMatchesSearch(CV cv) {
		StringBuilder text = new StringBuilder();

		for (EdukacijaITrening edu : cv.getEdukacijaITreningList())
			text.append(edu.getKvalifikacija()).append(edu.getPredmetiSteceneVjestine());

		for (RadnoIskustvo rad : cv.getRadnoIskustvoList())
			text.append(rad.getDjelatnostSektor()).append(rad.getOpisPosla());

		for (DodatneInfo info : cv.getDodatneInfoList())
			text.append(info.getOpis());

		OsobnaVjestina osobnaVJ = cv.getOsobnaVJ();

		text.append(osobnaVJ.getKomunikacijskeVj()).append(osobnaVJ.getOrganizacijskeVj())
				.append(osobnaVJ.getOstaleVj()).append(osobnaVJ.getPoslovneVj()).append(osobnaVJ.getRacunalneVJ());

		return text.toString();
	}

	@Transactional
	public Boolean SaveQueries(List<Upit> upitList) {
		try {
			upitRepo.saveAll(upitList);
			upitRepo.RECREATE_IDX_ON_UPIT();
			return true;

		} catch (Exception e) {
			return false;
		}
	}
	
	@Transactional 
	public Boolean DeleteAllQueries() {
		try {
			upitRepo.deleteAll();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}

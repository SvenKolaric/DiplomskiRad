package com.DiplomskiRad_SK.ZivotopisIN2.services;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.attoparser.config.ParseConfiguration;
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
import com.DiplomskiRad_SK.ZivotopisIN2.models.SearchWrapper;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.CVRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.EdukacijaITreningRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.InstitucijaRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.JezikRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.MjestoRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.OsobaRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.RadnoIskustvoRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.UpitRepository;

import oracle.jdbc.proxy.WeakIdentityHashMap;

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

	public List<Search> prepareQueries(SearchWrapper searchW) {

		List<Search> searchList = new ArrayList<>();
		try {
			for (Search s : searchW.getSearchList()) {
				switch (s.getIdentifier()) {
				case "BRGOD_RADA":
					String[] partsRad = s.getQuery().split(","); // ignore other numbers
					s.setQuery(partsRad[0]);
					searchList.add(s);
					break;
				case "BRGOD_EDU":
					String[] partsEdu = s.getQuery().split(","); // ignore other numbers
					s.setQuery(partsEdu[0]);
					searchList.add(s);
					break;
				case "MJESTO":
					String[] partsMjesto = s.getQuery().split(",");
					for (String query : partsMjesto) {
						s.setQuery(query);
						searchList.add(s);
					}
					break;
				case "INSTITUCIJA":
					String[] partsInst = s.getQuery().split(",");
					for (String query : partsInst) {
						s.setQuery(query);
						searchList.add(s);
					}
					break;
				case "UPIT": // java + net (2,10),\n java (1,10), -> java+net(2,10\njava(1,10 -> java AND net ,weight=2 value=10 | java, weight=1 value=10
					s.setQuery(s.getQuery().replaceAll(" ", ""));

					String[] partsUpit = s.getQuery().split(",(?![^\\(\\[]*[\\]\\)])");
					for (String query : partsUpit) {
						query = query.trim();
						String[] queryAndValues = query.split("\\(");
						Search upit = new Search();

						if (queryAndValues[0].contains("+")) {
							queryAndValues[0] = queryAndValues[0].replace("+", " AND ");
						}
						String[] weightAndValue = queryAndValues[1].replaceAll("\\)", "").split(",");

						upit.setIdentifier("UPIT");
						upit.setQuery(queryAndValues[0]);
						upit.setQueryWeight(Integer.parseInt(weightAndValue[0]));
						upit.setQueryValue(Integer.parseInt(weightAndValue[1]));

						searchList.add(upit);
					}
					break;

				}

			}
			return searchList;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	public List<CV> QueryCVs(List<Search> queries) {
		Set<CV> cvSet = new HashSet<>();
		List<Upit> upitList = new ArrayList<Upit>();
		Integer counterUpiti = 1;

		for (Search query : queries) {
			switch (query.getIdentifier()) {
			case "BRGOD_RADA":
				List<Object[]> cvGodRad = radRepo.findByGodRada(Integer.parseInt(query.getQuery()));
				for (Object[] row : cvGodRad)
					cvSet.add(calculateScore(cvRepo.findById(Integer.parseInt(row[0].toString())).get(),
							query.getQueryWeight(), query.getQueryValue()));

				break;

			case "BRGOD_EDU":
				List<Object[]> cvGodEdu = eduRepo.findByGodEdu(Integer.parseInt(query.getQuery()));
				for (Object[] row : cvGodEdu)
					cvSet.add(calculateScore(cvRepo.findById(Integer.parseInt(row[0].toString())).get(),
							query.getQueryWeight(), query.getQueryValue()));

				break;

			case "MJESTO":
				Mjesto mjesto = mjestoRepo.findByNaziv(query.getQuery());
				List<Osoba> osobaList = mjesto.getOsobaList();
				for (Osoba osoba : osobaList) {
					List<CV> cvList = osoba.getZivotopisiList();
					for (CV cv : cvList) {
						cvSet.add(calculateScore(cv, query.getQueryWeight(), query.getQueryValue()));
					}
				}

				break;
			case "INSTITUCIJA":
				List<Institucija> instList = institucijaRepo.findAllByNaziv(query.getQuery());
				for (Institucija inst : instList) {
					List<RadnoIskustvo> radIskList = inst.getRadnoIskustvoList();
					List<EdukacijaITrening> eduList = inst.getEdukacijaTreningList();

					for (RadnoIskustvo ri : radIskList) {
						cvSet.add(calculateScore(ri.getZivotopis(), query.getQueryWeight(), query.getQueryValue()));
					}

					for (EdukacijaITrening edu : eduList) {
						cvSet.add(calculateScore(edu.getZivotopis(), query.getQueryWeight(), query.getQueryValue()));
					}
				}
				break;

			case "UPIT":
				upitList.add(new Upit(counterUpiti, query.getQueryWeight(), query.getQueryValue(), query.getQuery()));
				counterUpiti++;
				break;
			}
		}

		if (!SaveQueries(upitList))
			return null;

		for (CV cv : cvSet) {
			List<Upit> results = upitRepo.findUpitsInText(prepareTextForMatchesSearch(cv));

			for (Upit rez : results)
				for (Upit u : upitList)
					if (u.equals(rez))
						cv = calculateScore(cv, u.getTezina(), u.getVrijednost());

		}

		if (!DeleteAllQueries())
			return null;

		for (CV cv : cvSet)
			System.out.println(cv.getScore());

		List<CV> cvSortedResult = SortSetToList(cvSet);

		return cvSortedResult;
	}

	private List<CV> SortSetToList(Set<CV> cvSet) {
		List<CV> cvList = new LinkedList<CV>();
		cvList.addAll(cvSet);
		Collections.<CV>sort(cvList);
		Collections.reverse(cvList);

		return cvList;

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

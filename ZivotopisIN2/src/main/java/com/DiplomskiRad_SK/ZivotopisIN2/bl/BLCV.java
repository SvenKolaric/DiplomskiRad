package com.DiplomskiRad_SK.ZivotopisIN2.bl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.CV;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.DodatneInfo;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.EdukacijaITrening;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Kategorija;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Osoba;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.CVRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.CertifikatiDiplomaRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.DodatakRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.DodatneInfoRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.DrzavaRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.DrzavljanstvoRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.EdukacijaITreningRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.InstitucijaRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.JezikRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.KategorijaRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.KontaktniInfoRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.MjestoRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.OsobaDrzavljanstvoRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.OsobaRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.OsobnaVjestinaRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.PozicijaRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.RadnoIskustvoRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.TipKontaktaRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.VozackaDozvolaRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.VozackaOsobnaVJRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.VrstaPrijaveRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.ZaglavljeRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.ZnaRepository;
import com.google.common.collect.Lists;

@Service("BLCV")
public class BLCV {

	@Autowired
	CVRepository cvRepo;
	@Autowired
	OsobaRepository osobaRepo;
	@Autowired
	CertifikatiDiplomaRepository cerDipRepo;
	@Autowired
	DodatakRepository dodatakRepo;
	@Autowired
	DodatneInfoRepository dodInfoRepo;
	@Autowired
	DrzavaRepository drzavaRepo;
	@Autowired
	DrzavljanstvoRepository drzavljanstvoRepo;
	@Autowired
	EdukacijaITreningRepository eduTrenRepo;
	@Autowired
	InstitucijaRepository institucijaRepo;
	@Autowired
	JezikRepository jezikRepo;
	@Autowired
	KategorijaRepository kategorijaRepo;
	@Autowired
	KontaktniInfoRepository kontInfoRepo;
	@Autowired
	MjestoRepository mjestoRepo;
	@Autowired
	OsobaDrzavljanstvoRepository osobaDrzRepo;
	@Autowired
	OsobnaVjestinaRepository osobnaVJRepo;
	@Autowired
	PozicijaRepository pozicijaRepo;
	@Autowired
	RadnoIskustvoRepository radnoIRepo;
	@Autowired
	TipKontaktaRepository tipKontRepo;
	@Autowired
	VozackaDozvolaRepository vozackaDozRepo;
	@Autowired
	VozackaOsobnaVJRepository vozOsobnaVJRepo;
	@Autowired
	VrstaPrijaveRepository vrstaPrijRepo;
	@Autowired
	ZaglavljeRepository zaglavljeRepo;
	@Autowired
	ZnaRepository znaRepo;

	/*
	 * @Autowired public BLCV(@Qualifier("CV") DaoCVInterface daoCVInterface) {
	 * this.daoCV = daoCVInterface; }
	 */

	@Transactional
	public void SaveCV(CV cv) {
		cvRepo.save(cv);
		// cv.getOsobnaVjestinaList().get(1).getVozackaDozvolaList().get(1).getIdOsobnaVj()
		/*
		 * CV cv1 = new CV(); Iterable<EdukacijaITrening> a =
		 * cv1.getEdukacijaITreningList(); ArrayList<CV> b = new ArrayList<CV>();
		 * EdukacijaITrening[] c = (EdukacijaITrening[]) ((Collection<CV>)
		 * a).toArray(new EdukacijaITrening[a.size()])
		 */
	}

	@Transactional
	public void SaveCVtest() {
		Date d = new Date();
		CV cv = new CV();
		DodatneInfo di = new DodatneInfo();
		Kategorija k = new Kategorija();
		
		/* OVAKO MOŽEŠ DOHVATITI SRANJA OD DODATNIH INFO SAMO POSALJES FINDBYZIVOTOPIS A NE PO IDU KAO PRIJE!!!!!!!!!
		CV cvtest = cvRepo.findById(24).orElse(null);
		List<DodatneInfo> di2 = dodInfoRepo.findByZivotopis(cvtest);
		*/
		// cv.setZivotopisID(1);
		cv.setDatumAzuriranja(new Timestamp(d.getTime()));
		cv.setDatumStvaranja(new Timestamp(d.getTime()));
		cv.setTipDokumenta("testCVKAT2");

		k.setNaziv("testKategorija");

		di.setOpis("testDodatniInfo1");

		//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		Kategorija postojiKat = kategorijaRepo.findByNaziv("testKategorija");
		if (postojiKat != null) {
			di.setKategorija(postojiKat);
			postojiKat.getDodatneInfoList().get(0);
		} else { // da li možeš
			// samo spremiti kategoriju ili moraš ju nekako dodati u di i onda spremati
			// kategorijaRepo.save(k);
			di.setKategorija(k);
			kategorijaRepo.save(k);
		}

		// TU ILI DOBAVI ID KATEGORIJE I STAVI U DI(MAKNI ONDA ONE TO MANY???) ILI
		// PROCITAJ ONAJ TUTORIAL

		di.setZivotopis(cv);
		//di.setKategorija(k);
		// ????? samo jedan dio
		cv.getDodatneInfoList().add(di);

		//kategorijaRepo.save(k);
		cvRepo.save(cv); // moraš prvo cv

		// test
		System.out.println(k.getDodatneInfoList().size());

		// update
		k.getDodatneInfoList().remove(di);
		// kategorijaRepo.save(k);

		// test
		System.out.println(k.getDodatneInfoList().size());
	}

	@Transactional
	public List<Osoba> getAllCV() {
		return Lists.newArrayList(osobaRepo.findAll());

	}

	@Transactional
	public Optional<CV> getCVByID(Integer id) {
		return cvRepo.findById(id);

	}

	@Transactional
	public List<CV> getCVByOsobaID(Integer idOsoba) {
		return null;// cvRepo.findByIdOsoba(idOsoba);
	}

	@Transactional
	public void deleteCVByID(Integer id) {
		cvRepo.deleteById(id);
	}

}

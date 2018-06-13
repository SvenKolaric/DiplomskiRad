package com.DiplomskiRad_SK.ZivotopisIN2.bl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.CV;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.DodatneInfo;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Drzava;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Drzavljanstvo;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.EdukacijaITrening;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Institucija;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Jezik;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Kategorija;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Mjesto;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Osoba;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Pozicija;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.RadnoIskustvo;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.TipKontakta;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.VozackaDozvola;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.VrstaPrijave;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Zaglavlje;
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

import oracle.net.aso.o;

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

		// Dodatne info check
		for (int i = 0; i < cv.getDodatneInfoList().size(); i++) {
			Kategorija katDB = kategorijaRepo.findByNaziv(cv.getDodatneInfoList().get(i).getKategorija().getNaziv());
			if (katDB != null) {
				cv.getDodatneInfoList().get(i).setKategorija(katDB);
			} else {
				//kategorijaRepo.save(cv.getDodatneInfoList().get(i).getKategorija());
			}
		}

		// Vozacka dozvola
		for (int i = 0; i < cv.getOsobnaVJ().getVozackaDozvolaOsVJList().size(); i++) {
			VozackaDozvola vozDozDB = vozackaDozRepo.findByKategorija(
					cv.getOsobnaVJ().getVozackaDozvolaOsVJList().get(i).getVozackaDozvola().getKategorija());
			if (vozDozDB != null) {
				cv.getOsobnaVJ().getVozackaDozvolaOsVJList().get(i).setVozackaDozvola(vozDozDB);
			} else {
				//vozackaDozRepo.save(cv.getOsobnaVJ().getVozackaDozvolaOsVJList().get(i).getVozackaDozvola());
			}
		}

		// Jezik
		for (int i = 0; i < cv.getOsobnaVJ().getZnaList().size(); i++) {
			Jezik jezikDB = jezikRepo.findByNaziv(cv.getOsobnaVJ().getZnaList().get(i).getJezik().getNaziv());
			if (jezikDB != null) {
				cv.getOsobnaVJ().getZnaList().get(i).setJezik(jezikDB);
			} else {
				//jezikRepo.save(cv.getOsobnaVJ().getZnaList().get(i).getJezik());
			}
		}

		// Osoba
		ArrayList<Osoba> osobaDBList = (ArrayList<Osoba>) osobaRepo.findAll();
		for (Osoba osobaDB : osobaDBList) {
			if (cv.getOsoba().equals(osobaDB)) {
				cv.setOsoba(osobaDB);

				for (int i = 0; i < cv.getOsoba().getKontaktInfoList().size(); i++)
					cv.getOsoba().getKontaktInfoList().get(i).setOsoba(osobaDB);

				for (int i = 0; i < cv.getOsoba().getOsobaDrzavljanstvoList().size(); i++)
					cv.getOsoba().getOsobaDrzavljanstvoList().get(i).setOsoba(osobaDB);
			}
		}

		// Tip Konatakta
		for (int i = 0; i < cv.getOsoba().getKontaktInfoList().size(); i++) {
			TipKontakta tipKontDB = tipKontRepo
					.findByNaziv(cv.getOsoba().getKontaktInfoList().get(i).getTipKontakta().getNaziv());
			if (tipKontDB != null) {
				cv.getOsoba().getKontaktInfoList().get(i).setTipKontakta(tipKontDB);
			} else {
				//tipKontRepo.save(cv.getOsoba().getKontaktInfoList().get(i).getTipKontakta());
			}
		}

		// Drzavljanstvo
		for (int i = 0; i < cv.getOsoba().getOsobaDrzavljanstvoList().size(); i++) {
			Drzavljanstvo drzavljanstvoDB = drzavljanstvoRepo
					.findByNaziv(cv.getOsoba().getOsobaDrzavljanstvoList().get(i).getDrzavljanstvo().getNaziv());
			if (drzavljanstvoDB != null) {
				cv.getOsoba().getOsobaDrzavljanstvoList().get(i).setDrzavljanstvo(drzavljanstvoDB);
			} else {
				//drzavljanstvoRepo.save(cv.getOsoba().getOsobaDrzavljanstvoList().get(i).getDrzavljanstvo()); 
			}
		}

		// VrstaPrijave
		VrstaPrijave vrstaPDB = vrstaPrijRepo.findByNaziv(cv.getZaglavlje().getVrstaPrijave().getNaziv());
		if (vrstaPDB != null) {
			cv.getZaglavlje().setVrstaPrijave(vrstaPDB);
		} else {
			//vrstaPrijRepo.save(cv.getZaglavlje().getVrstaPrijave());
		}

		// Pozicija
		for (int i = 0; i < cv.getRadnoIskustvoList().size(); i++) {
			Pozicija pozicijaDB = pozicijaRepo.findByNaziv(cv.getRadnoIskustvoList().get(i).getPozicija().getNaziv());
			if (pozicijaDB != null) {
				cv.getRadnoIskustvoList().get(i).setPozicija(pozicijaDB);
			} else {
				//pozicijaRepo.save(cv.getRadnoIskustvoList().get(i).getPozicija());
			}
		}

		//Drzava - osoba
		Drzava drzavaDB = drzavaRepo.findByNaziv(cv.getOsoba().getMjesto().getDrzava().getNaziv());
		if (drzavaDB != null) {
			cv.getOsoba().getMjesto().setDrzava(drzavaDB);
		} else {
			drzavaDB = cv.getOsoba().getMjesto().getDrzava();
			drzavaDB.setMjesto(null);
			drzavaRepo.save(drzavaDB);
		}
		
		//Mjesto probat cu ne spremati odmah
		Mjesto mjestoDB_Osoba = mjestoRepo.findByNaziv(cv.getOsoba().getMjesto().getNaziv());
		if (mjestoDB_Osoba != null) {
			cv.getOsoba().setMjesto(mjestoDB_Osoba);
		} else {
			//mjestoRepo.save(cv.getOsoba().getMjesto());
		}
		
		//Mjesto-Drzava RI
		for (int i = 0; i < cv.getRadnoIskustvoList().size(); i++) {
			Mjesto mjestoDB_RI = mjestoRepo.findByNaziv(cv.getRadnoIskustvoList().get(i).getInstitucija().getMjesto().getNaziv());
			Drzava drzavaDB_RI = drzavaRepo.findByNaziv(cv.getRadnoIskustvoList().get(i).getInstitucija().getMjesto().getDrzava().getNaziv());
			
			if (drzavaDB_RI != null) {
				cv.getRadnoIskustvoList().get(i).getInstitucija().getMjesto().setDrzava(drzavaDB_RI);
			} else {
				drzavaDB = cv.getRadnoIskustvoList().get(i).getInstitucija().getMjesto().getDrzava();
				drzavaDB.setMjesto(null);
				drzavaRepo.save(drzavaDB);
			}
			
			if (mjestoDB_RI != null) {
				cv.getRadnoIskustvoList().get(i).getInstitucija().setMjesto(mjestoDB_RI);
			} else {
				//mjestoRepo.save(cv.getRadnoIskustvoList().get(i).getInstitucija().getMjesto());
			}
		}
		
		//Mjesto-Drzava Edu
		for (int i = 0; i < cv.getEdukacijaITreningList().size(); i++) {
			Mjesto mjestoDB_ET = mjestoRepo.findByNaziv(cv.getEdukacijaITreningList().get(i).getInstitucija().getMjesto().getNaziv());
			Drzava drzavaDB_ET = drzavaRepo.findByNaziv(cv.getEdukacijaITreningList().get(i).getInstitucija().getMjesto().getDrzava().getNaziv());
			
			if (drzavaDB_ET != null) {
				cv.getEdukacijaITreningList().get(i).getInstitucija().getMjesto().setDrzava(drzavaDB_ET);
			} else {
				drzavaDB = cv.getEdukacijaITreningList().get(i).getInstitucija().getMjesto().getDrzava();
				drzavaDB.setMjesto(null);
				drzavaRepo.save(drzavaDB);
			}
			if (mjestoDB_ET != null) {
				cv.getRadnoIskustvoList().get(i).getInstitucija().setMjesto(mjestoDB_ET);
			} else {
				//mjestoRepo.save(cv.getRadnoIskustvoList().get(i).getInstitucija().getMjesto());
			}
		}
		
		//Institucija //firme s istima nazivom?
		for (int i = 0; i < cv.getRadnoIskustvoList().size(); i++) {
			Institucija institucijaDB = institucijaRepo.findByNaziv(cv.getRadnoIskustvoList().get(i).getInstitucija().getNaziv());
			if (institucijaDB != null) {
				cv.getRadnoIskustvoList().get(i).setInstitucija(institucijaDB);
			} else {
				//institucijaRepo.save(cv.getRadnoIskustvoList().get(i).getInstitucija());
			}
		}
		for (int i = 0; i < cv.getEdukacijaITreningList().size(); i++) {
			Institucija institucijaDB = institucijaRepo.findByNaziv(cv.getEdukacijaITreningList().get(i).getInstitucija().getNaziv());
			if (institucijaDB != null) {
				cv.getEdukacijaITreningList().get(i).setInstitucija(institucijaDB);
			} else {
				//institucijaRepo.save(cv.getEdukacijaITreningList().get(i).getInstitucija());
			}
		}
		
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

		/*
		 * OVAKO MOŽEŠ DOHVATITI DODATNIH INFO SAMO POSALJES FINDBYZIVOTOPIS A NE PO IDU
		 * KAO PRIJE!!!!!!!!! CV cvtest = cvRepo.findById(24).orElse(null);
		 * List<DodatneInfo> di2 = dodInfoRepo.findByZivotopis(cvtest);
		 */
		// cv.setZivotopisID(1);
		cv.setDatumAzuriranja(new Timestamp(d.getTime()));
		cv.setDatumStvaranja(new Timestamp(d.getTime()));
		cv.setTipDokumenta("testCVKAT2");

		k.setNaziv("testKategorija");

		di.setOpis("testDodatniInfo1");

		// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
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
		// di.setKategorija(k);
		// ????? samo jedan dio
		cv.getDodatneInfoList().add(di);

		// kategorijaRepo.save(k);
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

package com.DiplomskiRad_SK.ZivotopisIN2.interfaces;

import java.util.List;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.CV;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.KontaktniInfo;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Osoba;

public interface DaoCVInterface {

	// CV
	
	void createNewCV(CV cv);

	List<CV> selectAllCV();

	CV selectCVByID(Integer id);

	void deleteCVByID(Integer id);
	
	List<CV> selectCVByOsoba(Integer osobaID);

	// Osoba

	void createNewOsoba(Osoba osoba);

	List<Osoba> selectAllOsoba();
	
	Osoba selectOsobaByID(Integer id);
	
	List<Osoba> selectOsobaByMjesto(Integer mjestoID);
	
	void deleteOsobaByID(Integer id);
	
	// Kontakt_Info
	
	void createNewKontakt_Info(KontaktniInfo kontaktniInfo);
	
	List<KontaktniInfo> selectKontakt_InfoByOsoba(Integer osobaID);
	
	// Tip_Kontakta
	
	// Osoba_Drzavljanstvo
	
	// Drzavljanstvo
	
	// Drzavljanstvo
}

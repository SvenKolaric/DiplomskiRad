package modelDB;

import java.util.Date;

public class Osoba {
	private final Integer osobaID;
	private final String ime;
	private final String prezime;
	private final Date godRodenja;
	private final Character spol;
	private final String adresa;
	private final Integer idMjesto;
	
	private final Iterable<CV> zivotopisiList;
	private final Iterable<KontaktniInfo> kontaktInfoList;
	private final Iterable<Drzavljanstvo> drzavljanstvoList;
	
	private final Mjesto mjesto;
	
	public Osoba(Integer osobaID, String ime, String prezime, Date godRodenja, Character spol, String adresa,
			Integer idMjesto, Iterable<CV> zivotopisiList, Iterable<KontaktniInfo> kontaktInfoList, 
			Iterable<Drzavljanstvo> drzavljanstvoList, Mjesto mjesto) {
		this.osobaID = osobaID;
		this.ime = ime;
		this.prezime = prezime;
		this.godRodenja = godRodenja;
		this.spol = spol;
		this.adresa = adresa;
		this.idMjesto = idMjesto;
		this.zivotopisiList = zivotopisiList;
		this.kontaktInfoList = kontaktInfoList;
		this.drzavljanstvoList = drzavljanstvoList;
		this.mjesto = mjesto;
	}

	public Mjesto getMjesto() {
		return mjesto;
	}

	public Iterable<Drzavljanstvo> getDrzavljanstvoList() {
		return drzavljanstvoList;
	}

	public Integer getOsobaID() {
		return osobaID;
	}

	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public Date getGodRodenja() {
		return godRodenja;
	}

	public Character getSpol() {
		return spol;
	}

	public String getAdresa() {
		return adresa;
	}

	public Integer getIdMjesto() {
		return idMjesto;
	}

	public Iterable<CV> getZivotopisiList() {
		return zivotopisiList;
	}
	
	public Iterable<KontaktniInfo> getKontaktInfoList() {
		return kontaktInfoList;
	}
}

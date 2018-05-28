package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import java.util.Date;
import java.util.ArrayList;

public class Osoba {
	private Integer osobaID;
	private String ime;
	private String prezime;
	private Date godRodenja;
	private Character spol;
	private String adresa;
	private Integer idMjesto;
	
	private ArrayList<CV> zivotopisiList;
	private ArrayList<KontaktniInfo> kontaktInfoList;
	private ArrayList<Drzavljanstvo> drzavljanstvoList;
	
	private Mjesto mjesto;
	
	public Osoba() {
	}

	public Osoba(Integer osobaID, String ime, String prezime, Date godRodenja, Character spol, String adresa,
			Integer idMjesto, ArrayList<CV> zivotopisiList, ArrayList<KontaktniInfo> kontaktInfoList, 
			ArrayList<Drzavljanstvo> drzavljanstvoList, Mjesto mjesto) {
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

	public ArrayList<Drzavljanstvo> getDrzavljanstvoList() {
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

	public ArrayList<CV> getZivotopisiList() {
		return zivotopisiList;
	}
	
	public ArrayList<KontaktniInfo> getKontaktInfoList() {
		return kontaktInfoList;
	}
}

package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import java.util.Date;

import javax.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "OSOBA")
public class Osoba {
	@Id
	@GeneratedValue(generator = "OSeq")
	@SequenceGenerator(name = "OSeq", sequenceName = "OSOBA_SEQ", allocationSize = 1)
	private Integer osobaID;
	@Column(name = "IME")
	private String ime;
	@Column(name = "PREZIME")
	private String prezime;
	@Column(name = "GODINARODENJA")
	private Date godRodenja;
	@Column(name = "SPOL")
	private Character spol;
	@Column(name = "ADRESA")
	private String adresa;
	@Column(name = "IDMJESTO")
	private Integer idMjesto;
	@Column(name = "WEBSITE")
	private String website;
	@Transient
	private ArrayList<CV> zivotopisiList;
	@Transient
	private ArrayList<KontaktniInfo> kontaktInfoList;
	@Transient
	private ArrayList<Drzavljanstvo> drzavljanstvoList;
	@Transient
	private Mjesto mjesto;
	
	public Osoba() {
	}

	public Osoba(Integer osobaID, String ime, String prezime, Date godRodenja, Character spol,
			String adresa, Integer idMjesto, String website, ArrayList<CV> zivotopisiList,
			ArrayList<KontaktniInfo> kontaktInfoList, ArrayList<Drzavljanstvo> drzavljanstvoList, Mjesto mjesto) {
		this.osobaID = osobaID;
		this.ime = ime;
		this.prezime = prezime;
		this.godRodenja = godRodenja;
		this.spol = spol;
		this.adresa = adresa;
		this.idMjesto = idMjesto;
		this.website = website;
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

	public void setOsobaID(Integer osobaID) {
		this.osobaID = osobaID;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public void setGodRodenja(Date godRodenja) {
		this.godRodenja = godRodenja;
	}

	public void setSpol(Character spol) {
		this.spol = spol;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public void setIdMjesto(Integer idMjesto) {
		this.idMjesto = idMjesto;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public void setZivotopisiList(ArrayList<CV> zivotopisiList) {
		this.zivotopisiList = zivotopisiList;
	}

	public void setKontaktInfoList(ArrayList<KontaktniInfo> kontaktInfoList) {
		this.kontaktInfoList = kontaktInfoList;
	}

	public void setDrzavljanstvoList(ArrayList<Drzavljanstvo> drzavljanstvoList) {
		this.drzavljanstvoList = drzavljanstvoList;
	}

	public void setMjesto(Mjesto mjesto) {
		this.mjesto = mjesto;
	}
}

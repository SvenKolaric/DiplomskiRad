package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import java.util.Date;

public class EdukacijaITrening {
	private Integer edukacijaID;
	private Integer idCV;
	private Date datumPocetka;
	private Date datumKraja;
	
	private Institucija institucija;
	
	public EdukacijaITrening() {
	}

	public EdukacijaITrening(Integer edukacijaID, Integer idCV, Date datumPocetka, Date datumKraja, Institucija institucija) {
		this.edukacijaID = edukacijaID;
		this.idCV = idCV;
		this.datumPocetka = datumPocetka;
		this.datumKraja = datumKraja;
		this.institucija = institucija;
	}

	public Institucija getInstitucija() {
		return institucija;
	}

	public Integer getEdukacijaID() {
		return edukacijaID;
	}

	public Integer getIdCV() {
		return idCV;
	}

	public Date getDatumPocetka() {
		return datumPocetka;
	}

	public Date getDatumKraja() {
		return datumKraja;
	}
	
}

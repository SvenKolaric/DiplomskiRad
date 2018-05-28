package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

public class Pozicija {
	private Integer pozicijaID;
	private String naziv;
	
	public Pozicija() {
	}

	public Pozicija(Integer pozicijaID, String naziv) {
		this.pozicijaID = pozicijaID;
		this.naziv = naziv;
	}

	public Integer getPozicijaID() {
		return pozicijaID;
	}

	public String getNaziv() {
		return naziv;
	}
	
}

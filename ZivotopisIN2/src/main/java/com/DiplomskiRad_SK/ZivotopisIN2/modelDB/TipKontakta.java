package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;


public class TipKontakta {
	private Integer kontaktID;
	private String naziv;
	
	public TipKontakta() {
	}

	public TipKontakta(Integer kontaktID, String naziv) {
		this.kontaktID = kontaktID;
		this.naziv = naziv;
	}

	public Integer getKontaktID() {
		return kontaktID;
	}

	public String getNaziv() {
		return naziv;
	}
	
}

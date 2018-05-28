package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;


public class Drzavljanstvo {
	private Integer drzavljanstvoID;
	private String naziv;
	
	public Drzavljanstvo() {
	}

	public Drzavljanstvo(Integer drzavljanstvoID, String naziv) {
		this.drzavljanstvoID = drzavljanstvoID;
		this.naziv = naziv;
	}

	public Integer getDrzavljanstvoID() {
		return drzavljanstvoID;
	}

	public String getNaziv() {
		return naziv;
	}
}

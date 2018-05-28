package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

public class VozackaOsobnaVJ {
	private Integer ID;
	private Integer idVozacka;
	private Integer idOsobnaVj;
	
	private VozackaDozvola vozackaDozvola;
	
	public VozackaOsobnaVJ() {
	}

	public VozackaOsobnaVJ(Integer iD, Integer idVozacka, Integer idOsobnaVj, VozackaDozvola vozackaDozvola) {
		ID = iD;
		this.idVozacka = idVozacka;
		this.idOsobnaVj = idOsobnaVj;
		this.vozackaDozvola = vozackaDozvola;
	}
	
	public VozackaDozvola getVozackaDozvola() {
		return vozackaDozvola;
	}

	public Integer getID() {
		return ID;
	}
	public Integer getIdVozacka() {
		return idVozacka;
	}
	public Integer getIdOsobnaVj() {
		return idOsobnaVj;
	}
	
}

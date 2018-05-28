package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

public class Zna {
	private Integer ID;
	private Integer idVjestina;
	private Integer idJezik;
	private String razumijevanje;
	private String govor;
	private String pisanje;
	
	private Jezik jezik;
	
	public Zna() {
	}

	public Zna(Integer iD, Integer idVjestina, Integer idJezik, String razumijevanje, String govor, String pisanje, Jezik jezik) {
		ID = iD;
		this.idVjestina = idVjestina;
		this.idJezik = idJezik;
		this.razumijevanje = razumijevanje;
		this.govor = govor;
		this.pisanje = pisanje;
		this.jezik = jezik;
	}

	public Jezik getJezik() {
		return jezik;
	}

	public Integer getID() {
		return ID;
	}

	public Integer getIdVjestina() {
		return idVjestina;
	}

	public Integer getIdJezik() {
		return idJezik;
	}

	public String getRazumijevanje() {
		return razumijevanje;
	}

	public String getGovor() {
		return govor;
	}

	public String getPisanje() {
		return pisanje;
	}
	
}

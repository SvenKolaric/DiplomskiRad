package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import javax.persistence.*;

@Entity
@Table(name = "VOZACKA_DOZVOLA")
public class VozackaDozvola {
	@Id
	@GeneratedValue(generator = "VDSeq")
	@SequenceGenerator(name = "VDSeq", sequenceName = "VOZACKA_DOZVOLA_SEQ", allocationSize = 1)
	private Integer vozackaID;
	@Column(name = "KATEGORIJA")
	private String kategorija;
	
	public VozackaDozvola() {
	}

	public VozackaDozvola(Integer vozackaID, String kategorija) {
		this.vozackaID = vozackaID;
		this.kategorija = kategorija;
	}

	public Integer getVozackaID() {
		return vozackaID;
	}

	public String getKategorija() {
		return kategorija;
	}

	public void setVozackaID(Integer vozackaID) {
		this.vozackaID = vozackaID;
	}

	public void setKategorija(String kategorija) {
		this.kategorija = kategorija;
	}
	
}

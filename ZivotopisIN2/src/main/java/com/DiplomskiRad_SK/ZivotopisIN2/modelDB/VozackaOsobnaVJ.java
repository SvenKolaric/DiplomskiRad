package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import javax.persistence.*;

@Entity
@Table(name = "VOZACKA_OSOBNAVJ")
public class VozackaOsobnaVJ {
	@Id
	@GeneratedValue(generator = "VOSeq")
	@SequenceGenerator(name = "VOSeq", sequenceName = "VOZACKA_OSOBNAVJ_SEQ", allocationSize = 1)
	private Integer ID;
	@Column(name = "IDVOZACKA")
	private Integer idVozacka;
	@Column(name = "IDOSOBNAVJ")
	private Integer idOsobnaVj;
	@Transient
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

	public void setID(Integer iD) {
		ID = iD;
	}

	public void setIdVozacka(Integer idVozacka) {
		this.idVozacka = idVozacka;
	}

	public void setIdOsobnaVj(Integer idOsobnaVj) {
		this.idOsobnaVj = idOsobnaVj;
	}

	public void setVozackaDozvola(VozackaDozvola vozackaDozvola) {
		this.vozackaDozvola = vozackaDozvola;
	}
	
}

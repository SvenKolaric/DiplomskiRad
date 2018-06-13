package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import javax.persistence.*;

@Entity
@Table(name = "VOZACKA_OSOBNAVJ")
public class VozackaOsobnaVJ {
	@Id
	@GeneratedValue(generator = "VOSeq")
	@SequenceGenerator(name = "VOSeq", sequenceName = "VOZACKA_OSOBNAVJ_SEQ", allocationSize = 1)
	private Integer ID;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "IDVOZACKA")
	private VozackaDozvola vozackaDozvola;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "IDOSOBNAVJ")
	private OsobnaVjestina osobnaVJ;
	
	public VozackaOsobnaVJ() {
	}

	public VozackaOsobnaVJ(Integer iD) {
		ID = iD;
	}
	
	public VozackaDozvola getVozackaDozvola() {
		return vozackaDozvola;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public void setVozackaDozvola(VozackaDozvola vozackaDozvola) {
		this.vozackaDozvola = vozackaDozvola;
	}

	public OsobnaVjestina getOsobnaVJ() {
		return osobnaVJ;
	}

	public void setOsobnaVJ(OsobnaVjestina osobnaVJ) {
		this.osobnaVJ = osobnaVJ;
	}
	
}

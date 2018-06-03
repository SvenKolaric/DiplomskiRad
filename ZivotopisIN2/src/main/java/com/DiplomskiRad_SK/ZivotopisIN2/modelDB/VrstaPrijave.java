package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import javax.persistence.*;

@Entity
@Table(name = "VRSTA_PRIJAVE")
public class VrstaPrijave {
	@Id
	@GeneratedValue(generator = "VPSeq")
	@SequenceGenerator(name = "VPSeq", sequenceName = "VRSTA_PRIJAVE_SEQ", allocationSize = 1)
	private Integer prijavaID;
	@Column(name = "NAZIV")
	private String naziv;
	
	public VrstaPrijave() {
	}

	public VrstaPrijave(Integer prijavaID, String naziv) {
		this.prijavaID = prijavaID;
		this.naziv = naziv;
	}

	public Integer getPrijavaID() {
		return prijavaID;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setPrijavaID(Integer prijavaID) {
		this.prijavaID = prijavaID;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
}

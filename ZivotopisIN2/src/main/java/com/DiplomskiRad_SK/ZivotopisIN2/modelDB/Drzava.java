package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import javax.persistence.*;

@Entity
@Table(name = "DRZAVA")
public class Drzava {
	@Id
	@GeneratedValue(generator="DrzSeq") 
    @SequenceGenerator(name="DrzSeq",sequenceName="DRZAVA_SEQ", allocationSize=1)
	private Integer drzavaID;
	@Column(name = "NAZIV")
	private String naziv;

	public Drzava() {
	}

	public Drzava(Integer drzavaID, String naziv) {
		this.drzavaID = drzavaID;
		this.naziv = naziv;
	}

	public Integer getDrzavaID() {
		return drzavaID;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setDrzavaID(Integer drzavaID) {
		this.drzavaID = drzavaID;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

}

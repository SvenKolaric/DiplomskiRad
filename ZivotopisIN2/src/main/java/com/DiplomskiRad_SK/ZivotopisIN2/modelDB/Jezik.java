package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import javax.persistence.*;

@Entity
@Table(name = "JEZIK")
public class Jezik {
	@Id
	@GeneratedValue(generator="JSeq") 
    @SequenceGenerator(name="JSeq",sequenceName="JEZIK_SEQ", allocationSize=1)
	private Integer jezikID;
	@Column(name = "NAZIV")
	private String naziv;
	
	public Jezik() {
	}

	public Jezik(Integer jezikID, String naziv) {
		this.jezikID = jezikID;
		this.naziv = naziv;
	}

	public Integer getJezikID() {
		return jezikID;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setJezikID(Integer jezikID) {
		this.jezikID = jezikID;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
}

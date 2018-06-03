package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import javax.persistence.*;

@Entity
@Table(name = "DRZAVLJANSTVO")
public class Drzavljanstvo {
	@Id
	@GeneratedValue(generator="DrzaSeq") 
    @SequenceGenerator(name="DrzaSeq",sequenceName="DRZAVLJANSTVO_SEQ", allocationSize=1)
	private Integer drzavljanstvoID;
	@Column(name = "NAZIV")
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

	public void setDrzavljanstvoID(Integer drzavljanstvoID) {
		this.drzavljanstvoID = drzavljanstvoID;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
}

package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import javax.persistence.*;

@Entity
@Table(name = "POZICIJA")
public class Pozicija {
	@Id
	@GeneratedValue(generator = "PSeq")
	@SequenceGenerator(name = "PSeq", sequenceName = "POZICIJA_SEQ", allocationSize = 1)
	private Integer pozicijaID;
	@Column(name = "NAZIV")
	private String naziv;

	public Pozicija() {
	}

	public Pozicija(Integer pozicijaID, String naziv) {
		this.pozicijaID = pozicijaID;
		this.naziv = naziv;
	}

	public Integer getPozicijaID() {
		return pozicijaID;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setPozicijaID(Integer pozicijaID) {
		this.pozicijaID = pozicijaID;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

}

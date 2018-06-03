package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import javax.persistence.*;

@Entity
@Table(name = "KATEGORIJE")
public class Kategorija {
	@Id
	@GeneratedValue(generator = "KSeq")
	@SequenceGenerator(name = "KSeq", sequenceName = "KATEGORIJE_SEQ", allocationSize = 1)
	private Integer kategorijaID;
	@Column(name = "NAZIV")
	private String naziv;

	public Kategorija() {
	}

	public Kategorija(Integer kategorijaID, String naziv) {
		this.kategorijaID = kategorijaID;
		this.naziv = naziv;
	}

	public Integer getKategorijaID() {
		return kategorijaID;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setKategorijaID(Integer kategorijaID) {
		this.kategorijaID = kategorijaID;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

}

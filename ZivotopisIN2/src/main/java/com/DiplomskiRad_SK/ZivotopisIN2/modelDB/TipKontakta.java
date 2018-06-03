package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import javax.persistence.*;

@Entity
@Table(name = "TIP_KONTAKTA")
public class TipKontakta {
	@Id
	@GeneratedValue(generator = "TPSeq")
	@SequenceGenerator(name = "TPSeq", sequenceName = "TIP_KONTAKTA_SEQ", allocationSize = 1)
	private Integer kontaktID;
	@Column(name = "NAZIV")
	private String naziv;
	
	public TipKontakta() {
	}

	public TipKontakta(Integer kontaktID, String naziv) {
		this.kontaktID = kontaktID;
		this.naziv = naziv;
	}

	public Integer getKontaktID() {
		return kontaktID;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setKontaktID(Integer kontaktID) {
		this.kontaktID = kontaktID;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
}

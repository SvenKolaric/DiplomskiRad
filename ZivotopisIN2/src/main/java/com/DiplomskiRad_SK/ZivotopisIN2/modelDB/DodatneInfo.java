package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import javax.persistence.*;

@Entity
@Table(name = "DODATNE_INFO")
public class DodatneInfo {
	@Id
	@GeneratedValue(generator = "DISeq")
	@SequenceGenerator(name = "DISeq", sequenceName = "DODATNE_INFO_SEQ", allocationSize = 1)
	private Integer infoID;
	@Column(name = "IDCV")
	private Integer idCV;
	@Column(name = "IDKATEGORIJE")
	private Integer idKategorije;
	@Column(name = "OPIS")
	private String opis;
	@Transient
	private Kategorija kategorija;

	public DodatneInfo() {
	}

	public DodatneInfo(Integer infoID, Integer idCV, Integer idKategorije, String opis, Kategorija kategorija) {
		this.infoID = infoID;
		this.idCV = idCV;
		this.idKategorije = idKategorije;
		this.opis = opis;
		this.kategorija = kategorija;
	}

	public Kategorija getKategorija() {
		return kategorija;
	}

	public Integer getInfoID() {
		return infoID;
	}

	public Integer getIdCV() {
		return idCV;
	}

	public Integer getIdKategorije() {
		return idKategorije;
	}

	public String getOpis() {
		return opis;
	}

	public void setInfoID(Integer infoID) {
		this.infoID = infoID;
	}

	public void setIdCV(Integer idCV) {
		this.idCV = idCV;
	}

	public void setIdKategorije(Integer idKategorije) {
		this.idKategorije = idKategorije;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}

}

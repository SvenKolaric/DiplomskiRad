package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
@Table(name = "MJESTO")
public class Mjesto {
	@Id
	@GeneratedValue(generator = "MSeq")
	@SequenceGenerator(name = "MSeq", sequenceName = "MJESTO_SEQ", allocationSize = 1)
	private Integer mjestoID;
	@Column(name = "IDDRZAVA")
	private Integer idDrzava;
	@Column(name = "PBR")
	private Integer PBR;
	@Column(name = "NAZIV")
	private String naziv;
	@Transient
	private ArrayList<Osoba> osobaList;
	@Transient
	private ArrayList<Institucija> institucijaList;
	@Transient
	private Drzava drzava;

	public Mjesto() {
	}

	public Mjesto(Integer mjestoID, Integer idDrzava, Integer pBR, String naziv, ArrayList<Osoba> osobaList,
			ArrayList<Institucija> institucijaList, Drzava drzava) {
		this.mjestoID = mjestoID;
		this.idDrzava = idDrzava;
		PBR = pBR;
		this.naziv = naziv;
		this.osobaList = osobaList;
		this.institucijaList = institucijaList;
		this.drzava = drzava;
	}

	public Drzava getDrzava() {
		return drzava;
	}

	public ArrayList<Institucija> getInstitucijaList() {
		return institucijaList;
	}

	public Integer getMjestoID() {
		return mjestoID;
	}

	public ArrayList<Osoba> getOsobaList() {
		return osobaList;
	}

	public Integer getIdDrzava() {
		return idDrzava;
	}

	public Integer getPBR() {
		return PBR;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setMjestoID(Integer mjestoID) {
		this.mjestoID = mjestoID;
	}

	public void setIdDrzava(Integer idDrzava) {
		this.idDrzava = idDrzava;
	}

	public void setPBR(Integer pBR) {
		PBR = pBR;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public void setOsobaList(ArrayList<Osoba> osobaList) {
		this.osobaList = osobaList;
	}

	public void setInstitucijaList(ArrayList<Institucija> institucijaList) {
		this.institucijaList = institucijaList;
	}

	public void setDrzava(Drzava drzava) {
		this.drzava = drzava;
	}

}

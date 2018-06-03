package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "EDUKACIJA_I_TRENING")
public class EdukacijaITrening {
	@Id
	@GeneratedValue(generator="ETSeq") 
    @SequenceGenerator(name="ETSeq",sequenceName="EDUKACIJA_I_TRENING_SEQ", allocationSize=1)
	private Integer edukacijaID;
	@Column(name = "IDCV")
	private Integer idCV;
	@Column(name = "DATUMPOCETKA")
	private Date datumPocetka;
	@Column(name = "DATUMKRAJA")
	private Date datumKraja;
	@Column(name = "KVALIFIKACIJA")
	private String kvalifikacija;
	@Column(name = "IDINSTITUCIJA")
	private Integer idInstitucija;
	@Column(name = "EKORAZINA")
	private String ekorazina;
	@Column(name = "PODRUCJEOBRAZOVANAJ")
	private String podrucjeObrazovanja;
	@Column(name = "PREDMETI_STECENEVJESTINE")
	private String predmetiSteceneVjestine;
	@Column(name = "BR_GOD_EDUKACIJE")
	private Integer brGodEdukacija;
	@Transient
	private Institucija institucija;
	
	public EdukacijaITrening() {
	}

	public EdukacijaITrening(Integer edukacijaID, Integer idCV, Date datumPocetka, Date datumKraja,
			String kvalifikacija, Integer idInstitucija, String ekorazina, String podrucjeObrazovanja,
			String predmetiSteceneVjestine, Integer brGodEdukacija) {
		this.edukacijaID = edukacijaID;
		this.idCV = idCV;
		this.datumPocetka = datumPocetka;
		this.datumKraja = datumKraja;
		this.kvalifikacija = kvalifikacija;
		this.idInstitucija = idInstitucija;
		this.ekorazina = ekorazina;
		this.podrucjeObrazovanja = podrucjeObrazovanja;
		this.predmetiSteceneVjestine = predmetiSteceneVjestine;
		this.brGodEdukacija = brGodEdukacija;
	}

	public Institucija getInstitucija() {
		return institucija;
	}

	public Integer getEdukacijaID() {
		return edukacijaID;
	}

	public Integer getIdCV() {
		return idCV;
	}

	public Date getDatumPocetka() {
		return datumPocetka;
	}

	public Date getDatumKraja() {
		return datumKraja;
	}

	public String getKvalifikacija() {
		return kvalifikacija;
	}

	public Integer getIdInstitucija() {
		return idInstitucija;
	}

	public String getEkorazina() {
		return ekorazina;
	}

	public String getPodrucjeObrazovanja() {
		return podrucjeObrazovanja;
	}

	public String getPredmetiSteceneVjestine() {
		return predmetiSteceneVjestine;
	}

	public Integer getBrGodEdukacija() {
		return brGodEdukacija;
	}

	public void setEdukacijaID(Integer edukacijaID) {
		this.edukacijaID = edukacijaID;
	}

	public void setIdCV(Integer idCV) {
		this.idCV = idCV;
	}

	public void setDatumPocetka(Date datumPocetka) {
		this.datumPocetka = datumPocetka;
	}

	public void setDatumKraja(Date datumKraja) {
		this.datumKraja = datumKraja;
	}

	public void setKvalifikacija(String kvalifikacija) {
		this.kvalifikacija = kvalifikacija;
	}

	public void setIdInstitucija(Integer idInstitucija) {
		this.idInstitucija = idInstitucija;
	}

	public void setEkorazina(String ekorazina) {
		this.ekorazina = ekorazina;
	}

	public void setPodrucjeObrazovanja(String podrucjeObrazovanja) {
		this.podrucjeObrazovanja = podrucjeObrazovanja;
	}

	public void setPredmetiSteceneVjestine(String predmetiSteceneVjestine) {
		this.predmetiSteceneVjestine = predmetiSteceneVjestine;
	}

	public void setBrGodEdukacija(Integer brGodEdukacija) {
		this.brGodEdukacija = brGodEdukacija;
	}

	public void setInstitucija(Institucija institucija) {
		this.institucija = institucija;
	}
	
}

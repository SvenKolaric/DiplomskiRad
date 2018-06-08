package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import java.util.Date;

import javax.persistence.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "EDUKACIJA_I_TRENING")
public class EdukacijaITrening {
	@Id
	@GeneratedValue(generator="ETSeq") 
    @SequenceGenerator(name="ETSeq",sequenceName="EDUKACIJA_I_TRENING_SEQ", allocationSize=1)
	private Integer edukacijaID;
	@Column(name = "DATUMPOCETKA")
	private Date datumPocetka;
	@Column(name = "DATUMKRAJA")
	private Date datumKraja;
	@Column(name = "KVALIFIKACIJA")
	private String kvalifikacija;
	@Column(name = "EKORAZINA")
	private String ekorazina;
	@Column(name = "PODRUCJEOBRAZOVANAJ")
	private String podrucjeObrazovanja;
	@Column(name = "PREDMETI_STECENEVJESTINE")
	private String predmetiSteceneVjestine;
	@Column(name = "BR_GOD_EDUKACIJE")
	private Integer brGodEdukacija;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDINSTITUCIJA")
	private Institucija institucija;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDCV")
	private CV zivotopis;
	
	public EdukacijaITrening() {
	}

	public EdukacijaITrening(Integer edukacijaID, Date datumPocetka, Date datumKraja,
			String kvalifikacija, String ekorazina, String podrucjeObrazovanja,
			String predmetiSteceneVjestine, Integer brGodEdukacija) {
		this.edukacijaID = edukacijaID;
		this.datumPocetka = datumPocetka;
		this.datumKraja = datumKraja;
		this.kvalifikacija = kvalifikacija;
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
	
	public Date getDatumPocetka() {
		return datumPocetka;
	}

	public Date getDatumKraja() {
		return datumKraja;
	}

	public String getKvalifikacija() {
		return kvalifikacija;
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

	public void setDatumPocetka(Date datumPocetka) {
		this.datumPocetka = datumPocetka;
	}

	public void setDatumKraja(Date datumKraja) {
		this.datumKraja = datumKraja;
	}

	public void setKvalifikacija(String kvalifikacija) {
		this.kvalifikacija = kvalifikacija;
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

	public CV getZivotopis() {
		return zivotopis;
	}

	public void setZivotopis(CV zivotopis) {
		this.zivotopis = zivotopis;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
                .append(datumKraja)
                .append(datumPocetka)
                .append(ekorazina)
                .append(kvalifikacija)
                .append(podrucjeObrazovanja)
                .append(predmetiSteceneVjestine)
                .toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EdukacijaITrening other = (EdukacijaITrening) obj;
		return new EqualsBuilder()
                .append(datumKraja, other.datumKraja)
                .append(datumPocetka, other.datumPocetka)
                .append(ekorazina, other.ekorazina)
                .append(kvalifikacija, other.kvalifikacija)
                .append(podrucjeObrazovanja, other.podrucjeObrazovanja)
                .append(predmetiSteceneVjestine, other.predmetiSteceneVjestine)
                .isEquals();
	}
	
}

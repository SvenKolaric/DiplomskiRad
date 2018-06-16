package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import java.util.Date;

import javax.persistence.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "RADNO_ISKUSTVO")
public class RadnoIskustvo {
	@Id
	@GeneratedValue(generator = "RISeq")
	@SequenceGenerator(name = "RISeq", sequenceName = "RADNO_ISKUSTVO_SEQ", allocationSize = 1)
	private Integer PosaoID;
	@Column(name = "DATUMPOCETKA")
	private Date datumPocetka;
	@Column(name = "DATUMKRAJA")
	private Date datumKraja;
	@Column(name = "DJELATNOST_SEKTOR")
	private String djelatnostSektor;
	@Column(name = "OPISPOSLA")
	private String opisPosla;
	@Column(name = "BR_GOD_RADA")
	private Double brGodRada;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "IDPOZICIJA")
	private Pozicija pozicija;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "IDINSTITUCIJA")
	private Institucija institucija;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "IDCV")
	private CV zivotopis;
	
	public RadnoIskustvo() {
	}

	public RadnoIskustvo(Integer posaoID, Date datumPocetka, Date datumKraja, String djelatnostSektor, String opisPosla,
			Double brGodRada) {
		PosaoID = posaoID;
		this.datumPocetka = datumPocetka;
		this.datumKraja = datumKraja;
		this.djelatnostSektor = djelatnostSektor;
		this.opisPosla = opisPosla;
		this.brGodRada = brGodRada;
	}

	public Pozicija getPozicija() {
		return pozicija;
	}

	public Institucija getInstitucija() {
		return institucija;
	}

	public Integer getPosaoID() {
		return PosaoID;
	}

	public Date getDatumPocetka() {
		return datumPocetka;
	}

	public Date getDatumKraja() {
		return datumKraja;
	}

	public String getDjelatnostSektor() {
		return djelatnostSektor;
	}

	public String getOpisPosla() {
		return opisPosla;
	}

	public Double getBrGodRada() {
		return brGodRada;
	}

	public void setPosaoID(Integer posaoID) {
		PosaoID = posaoID;
	}

	public void setDatumPocetka(Date datumPocetka) {
		this.datumPocetka = datumPocetka;
	}

	public void setDatumKraja(Date datumKraja) {
		this.datumKraja = datumKraja;
	}

	public void setDjelatnostSektor(String djelatnostSektor) {
		this.djelatnostSektor = djelatnostSektor;
	}

	public void setOpisPosla(String opisPosla) {
		this.opisPosla = opisPosla;
	}

	public void setBrGodRada(Double brGodRada) {
		this.brGodRada = brGodRada;
	}

	public void setPozicija(Pozicija pozicija) {
		this.pozicija = pozicija;
	}

	public void setInstitucija(Institucija institucija) {
		this.institucija = institucija;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
                .append(datumKraja)
                .append(datumPocetka)
                .append(djelatnostSektor)
                .append(opisPosla)
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
		RadnoIskustvo other = (RadnoIskustvo) obj;
		return new EqualsBuilder()
				.append(datumKraja, other.datumKraja)
                .append(datumPocetka, other.datumPocetka)
                .append(djelatnostSektor, other.djelatnostSektor)
                .append(opisPosla, other.opisPosla)
                .isEquals();
	}

	public CV getZivotopis() {
		return zivotopis;
	}

	public void setZivotopis(CV zivotopis) {
		this.zivotopis = zivotopis;
	}
	
}

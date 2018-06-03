package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "RADNO_ISKUSTVO")
public class RadnoIskustvo {
	@Id
	@GeneratedValue(generator = "RISeq")
	@SequenceGenerator(name = "RISeq", sequenceName = "RADNO_ISKUSTVO_SEQ", allocationSize = 1)
	private Integer PosaoID;
	@Column(name = "IDCV")
	private Integer idCV;
	@Column(name = "DATUMPOCETKA")
	private Date datumPocetka;
	@Column(name = "DATUMKRAJA")
	private Date datumKraja;
	@Column(name = "IDPOZICIJA")
	private Integer idPozicija;
	@Column(name = "IDINSTITUCIJA")
	private Integer idInstitucija;
	@Column(name = "DJELATNOSTSEKTOR")
	private String djelatnostSektor;
	@Column(name = "OPISPOSLA")
	private String opisPosla;
	@Column(name = "BR_GOD_RADA")
	private Integer brGodRada;
	@Transient
	private Pozicija pozicija;
	@Transient
	private Institucija institucija;
	
	public RadnoIskustvo() {
	}

	public RadnoIskustvo(Integer posaoID, Integer idCV, Date datumPocetka, Date datumKraja, Integer idPozicija,
			Integer idInstitucija, String djelatnostSektor, String opisPosla, Integer brGodRada, Pozicija pozicija, Institucija institucija) {
		PosaoID = posaoID;
		this.idCV = idCV;
		this.datumPocetka = datumPocetka;
		this.datumKraja = datumKraja;
		this.idPozicija = idPozicija;
		this.idInstitucija = idInstitucija;
		this.djelatnostSektor = djelatnostSektor;
		this.opisPosla = opisPosla;
		this.brGodRada = brGodRada;
		this.pozicija = pozicija;
		this.institucija = institucija;
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

	public Integer getIdCV() {
		return idCV;
	}

	public Date getDatumPocetka() {
		return datumPocetka;
	}

	public Date getDatumKraja() {
		return datumKraja;
	}

	public Integer getIdPozicija() {
		return idPozicija;
	}

	public Integer getIdInstitucija() {
		return idInstitucija;
	}

	public String getDjelatnostSektor() {
		return djelatnostSektor;
	}

	public String getOpisPosla() {
		return opisPosla;
	}

	public Integer getBrGodRada() {
		return brGodRada;
	}

	public void setPosaoID(Integer posaoID) {
		PosaoID = posaoID;
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

	public void setIdPozicija(Integer idPozicija) {
		this.idPozicija = idPozicija;
	}

	public void setIdInstitucija(Integer idInstitucija) {
		this.idInstitucija = idInstitucija;
	}

	public void setDjelatnostSektor(String djelatnostSektor) {
		this.djelatnostSektor = djelatnostSektor;
	}

	public void setOpisPosla(String opisPosla) {
		this.opisPosla = opisPosla;
	}

	public void setBrGodRada(Integer brGodRada) {
		this.brGodRada = brGodRada;
	}

	public void setPozicija(Pozicija pozicija) {
		this.pozicija = pozicija;
	}

	public void setInstitucija(Institucija institucija) {
		this.institucija = institucija;
	}
	
}

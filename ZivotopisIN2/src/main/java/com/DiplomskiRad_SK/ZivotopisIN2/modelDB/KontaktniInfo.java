package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import javax.persistence.*;

@Entity
@Table(name = "KONTAKTNI_INFO")
public class KontaktniInfo {
	@Id
	@GeneratedValue(generator="KISeq") 
    @SequenceGenerator(name="KISeq",sequenceName="KONTAKTNI_INFO_SEQ", allocationSize=1)
	private Integer kontaktID;
	@Column(name = "IDTIPKONTAKTA")
	private Integer idTipKontakta;
	@Column(name = "IDOSOBA")
	private Integer idOsoba;
	@Column(name = "KONTAKT")
	private String kontakt;
	@Transient
	private TipKontakta TipKontakta;

	public KontaktniInfo() {
	}

	public KontaktniInfo(Integer kontaktID, Integer idTipKontakta, Integer idOsoba, String kontakt,
			com.DiplomskiRad_SK.ZivotopisIN2.modelDB.TipKontakta tipKontakta) {
		this.kontaktID = kontaktID;
		this.idTipKontakta = idTipKontakta;
		this.idOsoba = idOsoba;
		this.kontakt = kontakt;
		TipKontakta = tipKontakta;
	}

	public Integer getKontaktID() {
		return kontaktID;
	}

	public Integer getIdTipKontakta() {
		return idTipKontakta;
	}

	public Integer getIdOsoba() {
		return idOsoba;
	}

	public String getKontakt() {
		return kontakt;
	}

	public TipKontakta getTipKontakta() {
		return TipKontakta;
	}

	public void setKontaktID(Integer kontaktID) {
		this.kontaktID = kontaktID;
	}

	public void setIdTipKontakta(Integer idTipKontakta) {
		this.idTipKontakta = idTipKontakta;
	}

	public void setIdOsoba(Integer idOsoba) {
		this.idOsoba = idOsoba;
	}

	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}

	public void setTipKontakta(TipKontakta tipKontakta) {
		TipKontakta = tipKontakta;
	}
	
}

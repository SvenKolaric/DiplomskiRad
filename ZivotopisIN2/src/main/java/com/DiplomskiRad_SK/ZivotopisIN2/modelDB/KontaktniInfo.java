package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;


public class KontaktniInfo {
	private Integer kontaktID;
	private Integer idTipKontakta;
	private Integer idOsobe;
	private String kontakt;
	
	private TipKontakta TipKontakta;

	public KontaktniInfo() {
	}

	public KontaktniInfo(Integer kontaktID, Integer idTipKontakta, Integer idOsobe, String kontakt,
			com.DiplomskiRad_SK.ZivotopisIN2.modelDB.TipKontakta tipKontakta) {
		this.kontaktID = kontaktID;
		this.idTipKontakta = idTipKontakta;
		this.idOsobe = idOsobe;
		this.kontakt = kontakt;
		TipKontakta = tipKontakta;
	}

	public Integer getKontaktID() {
		return kontaktID;
	}

	public Integer getIdTipKontakta() {
		return idTipKontakta;
	}

	public Integer getIdOsobe() {
		return idOsobe;
	}

	public String getKontakt() {
		return kontakt;
	}

	public TipKontakta getTipKontakta() {
		return TipKontakta;
	}
	
}

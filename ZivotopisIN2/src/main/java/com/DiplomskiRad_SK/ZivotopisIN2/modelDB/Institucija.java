package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

public class Institucija {
	private Integer institucijaID;
	private String adresa;
	private Integer idMjesto;
	private String webStranica;
	private String naziv;
	
	private Mjesto mjesto;
	
	public Institucija() {
	}

	public Institucija(Integer institucijaID, String adresa, Integer idMjesto, String webStranica, String naziv, Mjesto mjesto) {
		this.institucijaID = institucijaID;
		this.adresa = adresa;
		this.idMjesto = idMjesto;
		this.webStranica = webStranica;
		this.naziv = naziv;
		this.mjesto = mjesto;
	}

	public Mjesto getMjesto() {
		return mjesto;
	}

	public Integer getInstitucijaID() {
		return institucijaID;
	}

	public String getAdresa() {
		return adresa;
	}

	public Integer getIdMjesto() {
		return idMjesto;
	}

	public String getWebStranica() {
		return webStranica;
	}

	public String getNaziv() {
		return naziv;
	}
	
}

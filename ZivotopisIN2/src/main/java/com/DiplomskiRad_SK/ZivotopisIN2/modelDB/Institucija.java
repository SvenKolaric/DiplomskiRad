package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import javax.persistence.*;

@Entity
@Table(name = "INSTITUCIJA")
public class Institucija {
	@Id
	@GeneratedValue(generator = "ISeq")
	@SequenceGenerator(name = "ISeq", sequenceName = "INSTITUCIJA_SEQ", allocationSize = 1)
	private Integer institucijaID;
	@Column(name = "ADRESA")
	private String adresa;
	@Column(name = "IDMJESTO")
	private Integer idMjesto;
	@Column(name = "WEBSTRANICA")
	private String webStranica;
	@Column(name = "NAZIV")
	private String naziv;
	@Transient
	private Mjesto mjesto;

	public Institucija() {
	}

	public Institucija(Integer institucijaID, String adresa, Integer idMjesto, String webStranica, String naziv,
			Mjesto mjesto) {
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

	public void setInstitucijaID(Integer institucijaID) {
		this.institucijaID = institucijaID;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public void setIdMjesto(Integer idMjesto) {
		this.idMjesto = idMjesto;
	}

	public void setWebStranica(String webStranica) {
		this.webStranica = webStranica;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public void setMjesto(Mjesto mjesto) {
		this.mjesto = mjesto;
	}

}

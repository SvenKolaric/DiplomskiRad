package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import javax.persistence.*;

@Entity
@Table(name = "ZNA")
public class Zna {
	@Id
	@GeneratedValue(generator = "ZNASeq")
	@SequenceGenerator(name = "ZNASeq", sequenceName = "ZNA_SEQ", allocationSize = 1)	private Integer ID;
	private Integer idVjestina;
	@Column(name = "IDJEZIK")
	private Integer idJezik;
	@Column(name = "RAZUMIJEVANJE")
	private String razumijevanje;
	@Column(name = "GOVOR")
	private String govor;
	@Column(name = "PISANJE")
	private String pisanje;
	@Transient
	private Jezik jezik;

	public Zna() {
	}

	public Zna(Integer iD, Integer idVjestina, Integer idJezik, String razumijevanje, String govor, String pisanje,
			Jezik jezik) {
		ID = iD;
		this.idVjestina = idVjestina;
		this.idJezik = idJezik;
		this.razumijevanje = razumijevanje;
		this.govor = govor;
		this.pisanje = pisanje;
		this.jezik = jezik;
	}

	public Jezik getJezik() {
		return jezik;
	}

	public Integer getID() {
		return ID;
	}

	public Integer getIdVjestina() {
		return idVjestina;
	}

	public Integer getIdJezik() {
		return idJezik;
	}

	public String getRazumijevanje() {
		return razumijevanje;
	}

	public String getGovor() {
		return govor;
	}

	public String getPisanje() {
		return pisanje;
	}

}

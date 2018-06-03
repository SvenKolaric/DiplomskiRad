package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import javax.persistence.*;

@Entity
@Table(name = "OSOBA_DRZAVLJANSTVO")
public class OsobaDrzavljanstvo {
	@Id
	@GeneratedValue(generator = "ODSeq")
	@SequenceGenerator(name = "ODSeq", sequenceName = "OSOBA_DRZAVLJANSTVO_SEQ", allocationSize = 1)
	private Integer ID;
	@Column(name = "IDDRZAVLJANSTVO")
	private Integer idDrzavljanstvo;
	@Column(name = "IDOSOBA")
	private Integer idOsoba;
	@Transient
	private Drzavljanstvo drzavljanstvo;

	public OsobaDrzavljanstvo() {
	}

	public OsobaDrzavljanstvo(Integer iD, Integer idDrzavljanstvo, Integer idOsoba, Drzavljanstvo drzavljanstvo) {
		ID = iD;
		this.idDrzavljanstvo = idDrzavljanstvo;
		this.idOsoba = idOsoba;
		this.drzavljanstvo = drzavljanstvo;
	}

	public Drzavljanstvo getDrzavljanstvo() {
		return drzavljanstvo;
	}

	public Integer getID() {
		return ID;
	}

	public Integer getIdDrzavljanstvo() {
		return idDrzavljanstvo;
	}

	public Integer getIdOsoba() {
		return idOsoba;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public void setIdDrzavljanstvo(Integer idDrzavljanstvo) {
		this.idDrzavljanstvo = idDrzavljanstvo;
	}

	public void setIdOsoba(Integer idOsoba) {
		this.idOsoba = idOsoba;
	}

	public void setDrzavljanstvo(Drzavljanstvo drzavljanstvo) {
		this.drzavljanstvo = drzavljanstvo;
	}

}

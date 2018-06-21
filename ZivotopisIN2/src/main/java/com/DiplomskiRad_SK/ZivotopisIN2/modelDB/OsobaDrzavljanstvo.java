package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import javax.persistence.*;

@Entity
@Table(name = "OSOBA_DRZAVLJANSTVO")
public class OsobaDrzavljanstvo {
	@Id
	@GeneratedValue(generator = "ODSeq")
	@SequenceGenerator(name = "ODSeq", sequenceName = "OSOBA_DRZAVLJANSTVO_SEQ", allocationSize = 1)
	private Integer ID;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDDRZAVLJANSTVO")
	private Drzavljanstvo drzavljanstvo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDOSOBA")
	private Osoba osoba;

	public OsobaDrzavljanstvo() {
	}

	public OsobaDrzavljanstvo(Integer iD) {
		ID = iD;
	}

	public Drzavljanstvo getDrzavljanstvo() {
		return drzavljanstvo;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public void setDrzavljanstvo(Drzavljanstvo drzavljanstvo) {
		this.drzavljanstvo = drzavljanstvo;
	}

	public Osoba getOsoba() {
		return osoba;
	}

	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}

}

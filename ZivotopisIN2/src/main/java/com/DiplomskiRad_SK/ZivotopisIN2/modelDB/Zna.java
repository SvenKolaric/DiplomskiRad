package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import javax.persistence.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "ZNA")
public class Zna {
	@Id
	@GeneratedValue(generator = "ZNASeq")
	@SequenceGenerator(name = "ZNASeq", sequenceName = "ZNA_SEQ", allocationSize = 1)	
	private Integer ID;
	@Column(name = "RAZUMIJEVANJE")
	private String razumijevanje;
	@Column(name = "GOVOR")
	private String govor;
	@Column(name = "PISANJE")
	private String pisanje;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDJEZIK")
	private Jezik jezik;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDVJESTINA")
	private OsobnaVjestina osobnaVJ;

	public Zna() {
	}

	public Zna(Integer iD, Integer idJezik, String razumijevanje, String govor, String pisanje) {
		ID = iD;
		this.razumijevanje = razumijevanje;
		this.govor = govor;
		this.pisanje = pisanje;
	}

	public Jezik getJezik() {
		return jezik;
	}

	public Integer getID() {
		return ID;
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

	public OsobnaVjestina getOsobnaVJ() {
		return osobnaVJ;
	}

	public void setOsobnaVJ(OsobnaVjestina osobnaVJ) {
		this.osobnaVJ = osobnaVJ;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public void setRazumijevanje(String razumijevanje) {
		this.razumijevanje = razumijevanje;
	}

	public void setGovor(String govor) {
		this.govor = govor;
	}

	public void setPisanje(String pisanje) {
		this.pisanje = pisanje;
	}

	public void setJezik(Jezik jezik) {
		this.jezik = jezik;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
                .append(govor)
                .append(pisanje)
                .append(razumijevanje)
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
		Zna other = (Zna) obj;
		return new EqualsBuilder()
                .append(govor, other.govor)
                .append(pisanje, other.pisanje)
                .append(razumijevanje, other.razumijevanje)
                .isEquals();
	}

}

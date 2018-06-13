package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import javax.persistence.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "KONTAKTNI_INFO")
public class KontaktniInfo {
	@Id
	@GeneratedValue(generator="KISeq") 
    @SequenceGenerator(name="KISeq",sequenceName="KONTAKTNI_INFO_SEQ", allocationSize=1)
	private Integer kontaktID;
	@Column(name = "KONTAKT")
	private String kontakt;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "IDTIPKONTAKTA")
	private TipKontakta tipKontakta;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "IDOSOBA")
	private Osoba osoba;

	public KontaktniInfo() {
	}
	
	public KontaktniInfo(Integer kontaktID, String kontakt) {
		this.kontaktID = kontaktID;
		this.kontakt = kontakt;
	}
	
	public Integer getKontaktID() {
		return kontaktID;
	}

	public String getKontakt() {
		return kontakt;
	}

	public TipKontakta getTipKontakta() {
		return tipKontakta;
	}

	public void setKontaktID(Integer kontaktID) {
		this.kontaktID = kontaktID;
	}

	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}

	public void setTipKontakta(TipKontakta tipKontakta) {
		this.tipKontakta = tipKontakta;
	}

	public Osoba getOsoba() {
		return osoba;
	}

	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
                .append(kontakt)
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
		KontaktniInfo other = (KontaktniInfo) obj;
		return new EqualsBuilder()
                .append(kontakt, other.kontakt)
                .isEquals();
	}
	
}

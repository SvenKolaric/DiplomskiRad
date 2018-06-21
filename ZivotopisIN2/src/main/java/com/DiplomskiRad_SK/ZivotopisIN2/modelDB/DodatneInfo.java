package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import javax.persistence.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "DODATNE_INFO")
public class DodatneInfo {
	@Id
	@GeneratedValue(generator = "DISeq")
	@SequenceGenerator(name = "DISeq", sequenceName = "DODATNE_INFO_SEQ", allocationSize = 1)
	private Integer infoID;
	/*@Column(name = "IDCV")
	private Integer idCV;*/
	/*@Column(name = "IDKATEGORIJE")
	private Integer idKategorija;*/
	@Column(name = "OPIS")
	private String opis;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDKATEGORIJE")
	private Kategorija kategorija;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDCV")
	private CV zivotopis;

	public DodatneInfo() {
	}

	public DodatneInfo(Integer infoID, String opis) {
		this.infoID = infoID;
		//this.idCV = idCV;
		this.opis = opis;
	}

	public Kategorija getKategorija() {
		return kategorija;
	}

	public Integer getInfoID() {
		return infoID;
	}

	
	/*public Integer getIdKategorije() {
		return idKategorije;
	}*/

	public String getOpis() {
		return opis;
	}

	public void setInfoID(Integer infoID) {
		this.infoID = infoID;
	}



	/*public void setIdKategorije(Integer idKategorije) {
		this.idKategorije = idKategorije;
	}*/

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}

	public CV getZivotopis() {
		return zivotopis;
	}

	public void setZivotopis(CV zivotopis) {
		this.zivotopis = zivotopis;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
                .append(opis)
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
		DodatneInfo other = (DodatneInfo) obj;
		return new EqualsBuilder()
                .append(opis, other.opis)
                .isEquals();
	}

}

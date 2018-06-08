package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import javax.persistence.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "DODATAK")
public class Dodatak {
	@Id
	@GeneratedValue(generator = "DodSeq")
	@SequenceGenerator(name = "DodSeq", sequenceName = "DODATAK_SEQ", allocationSize = 1)
	private Integer ID;
	@Column(name = "METADATA")
	private String metadata;
	@Column(name = "NAZIV")
	private String naziv;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDCV")
	private CV zivotopis;
	
	//REFERENCA NA KOJI DIO

	public Dodatak() {
	}

	public Dodatak(Integer iD, String metadata, String naziv) {
		ID = iD;
		this.metadata = metadata;
		this.naziv = naziv;
	}

	public Integer getID() {
		return ID;
	}

	public String getMetadata() {
		return metadata;
	}

	public String getText() {
		return naziv;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	public void setText(String naziv) {
		this.naziv = naziv;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
                .append(naziv)
                .append(metadata)
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
		Dodatak other = (Dodatak) obj;
		return new EqualsBuilder()
                .append(naziv, other.naziv)
                .append(metadata, other.metadata)
                .isEquals();
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public CV getZivotopis() {
		return zivotopis;
	}

	public void setZivotopis(CV zivotopis) {
		this.zivotopis = zivotopis;
	}

}

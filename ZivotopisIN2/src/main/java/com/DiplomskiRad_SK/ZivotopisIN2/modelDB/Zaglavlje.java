package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import javax.persistence.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "ZAGLAVLJE")
public class Zaglavlje {
	@Id
	@GeneratedValue(generator = "ZSeq")
	@SequenceGenerator(name = "ZSeq", sequenceName = "ZAGLAVLJE_SEQ", allocationSize = 1)
	private Integer zaglavljeID;
	@Column(name = "OPIS")
	private String opis;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "IDPRIJAVE")
	private VrstaPrijave vrstaPrijave;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "IDCV", nullable = false)
	private CV zivotopis;
	
	public Zaglavlje() {
	}

	public Zaglavlje(Integer zaglavljeID, String opis) {
		this.zaglavljeID = zaglavljeID;
		this.opis = opis;
	}

	public VrstaPrijave getVrstaPrijave() {
		return vrstaPrijave;
	}

	public CV getZivotopis() {
		return zivotopis;
	}

	public void setZivotopis(CV zivotopis) {
		this.zivotopis = zivotopis;
	}

	public Integer getZaglavljeID() {
		return zaglavljeID;
	}

	public String getOpis() {
		return opis;
	}

	public void setZaglavljeID(Integer zaglavljeID) {
		this.zaglavljeID = zaglavljeID;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public void setVrstaPrijave(VrstaPrijave vrstaPrijave) {
		this.vrstaPrijave = vrstaPrijave;
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
		Zaglavlje other = (Zaglavlje) obj;
		return new EqualsBuilder()
                .append(opis, other.opis)
                .isEquals();
	}
	
}

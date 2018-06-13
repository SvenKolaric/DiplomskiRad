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
	@Column(name = "RAZUMIJEVANJE_SLUSANJE")
	private String razumijevanjeSlusanje;
	@Column(name = "RAZUMIJEVANJE_CITANJE")
	private String razumijevanjeCitanje;
	@Column(name = "GOVORNA_PRODUKCIJA")
	private String govornaProdukcija;
	@Column(name = "GOVORNA_INTERAKCIJA")
	private String govornaInterakcija;
	@Column(name = "PISANJE")
	private String pisanje;
	@Column(name = "DIPLOME")
	private String diplome;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "IDJEZIK")
	private Jezik jezik;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "IDVJESTINA")
	private OsobnaVjestina osobnaVJ;

	public Zna() {
	}

	public Zna(Integer iD, String razumijevanjeSlusanje, String razumijevanjeCitanje, String govornaProdukcija,
			String govornaInterakcija, String pisanje, String diplome) {
		ID = iD;
		this.razumijevanjeSlusanje = razumijevanjeSlusanje;
		this.razumijevanjeCitanje = razumijevanjeCitanje;
		this.govornaProdukcija = govornaProdukcija;
		this.govornaInterakcija = govornaInterakcija;
		this.pisanje = pisanje;
		this.diplome = diplome;
	}


	public Integer getID() {
		return ID;
	}


	public void setID(Integer iD) {
		ID = iD;
	}


	public String getRazumijevanjeSlusanje() {
		return razumijevanjeSlusanje;
	}


	public void setRazumijevanjeSlusanje(String razumijevanjeSlusanje) {
		this.razumijevanjeSlusanje = razumijevanjeSlusanje;
	}

	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}
	
	public String getRazumijevanjeCitanje() {
		return razumijevanjeCitanje;
	}


	public void setRazumijevanjeCitanje(String razumijevanjeCitanje) {
		this.razumijevanjeCitanje = razumijevanjeCitanje;
	}


	public String getGovornaProdukcija() {
		return govornaProdukcija;
	}


	public void setGovornaProdukcija(String govornaProdukcija) {
		this.govornaProdukcija = govornaProdukcija;
	}


	public String getGovornaInterakcija() {
		return govornaInterakcija;
	}


	public void setGovornaInterakcija(String govornaInterakcija) {
		this.govornaInterakcija = govornaInterakcija;
	}


	public String getPisanje() {
		return pisanje;
	}


	public void setPisanje(String pisanje) {
		this.pisanje = pisanje;
	}


	public Jezik getJezik() {
		return jezik;
	}


	public void setJezik(Jezik jezik) {
		this.jezik = jezik;
	}


	public OsobnaVjestina getOsobnaVJ() {
		return osobnaVJ;
	}


	public void setOsobnaVJ(OsobnaVjestina osobnaVJ) {
		this.osobnaVJ = osobnaVJ;
	}


	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
                .append(govornaInterakcija)
                .append(govornaProdukcija)
                .append(pisanje)
                .append(razumijevanjeCitanje)
                .append(razumijevanjeSlusanje)
                .append(diplome)
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
                .append(govornaInterakcija, other.govornaInterakcija)
                .append(govornaProdukcija, other.govornaProdukcija)
                .append(pisanje, other.pisanje)
                .append(razumijevanjeCitanje, other.razumijevanjeCitanje)
                .append(razumijevanjeSlusanje, other.razumijevanjeSlusanje)
                .append(diplome, other.diplome)
                .isEquals();
	}

}

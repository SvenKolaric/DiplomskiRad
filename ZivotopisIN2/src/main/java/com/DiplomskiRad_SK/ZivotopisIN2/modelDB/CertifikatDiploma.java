package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import javax.persistence.*;

import org.apache.commons.lang3.builder.HashCodeBuilder;

//OVO TI MOŽDA NECE TREBATI!!!!!!!!!!!!!!!!!!!
@Entity
@Table(name = "CERTIFIKAT_DIPLOMA")
public class CertifikatDiploma {
	@Id
	@GeneratedValue(generator = "CDSeq")
	@SequenceGenerator(name = "CDSeq", sequenceName = "CERTIFIKAT_DIPLOMA_SEQ", allocationSize = 1)
	private Integer certDiplID;
	@Column(name = "IDVJESTINA")
	private Integer idVjestina;
	@Column(name = "OPISTITULA")
	private String opisTitula;
	@Transient
	private OsobnaVjestina osobnaVjestina;
	
	public CertifikatDiploma() {
	}

	public CertifikatDiploma(Integer certDiplID, String opisTitula) {
		this.certDiplID = certDiplID;
		this.opisTitula = opisTitula;
	}

	public Integer getCertDiplID() {
		return certDiplID;
	}

	public String getOpisTitula() {
		return opisTitula;
	}

	public void setCertDiplID(Integer certDiplID) {
		this.certDiplID = certDiplID;
	}

	public void setOpisTitula(String opisTitula) {
		this.opisTitula = opisTitula;
	}

	public OsobnaVjestina getOsobnaVjestina() {
		return osobnaVjestina;
	}

	public void setOsobnaVjestina(OsobnaVjestina osobnaVjestina) {
		this.osobnaVjestina = osobnaVjestina;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
                .append(opisTitula)
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
		CertifikatDiploma other = (CertifikatDiploma) obj;
		if (opisTitula == null) {
			if (other.opisTitula != null)
				return false;
		} else if (!opisTitula.equals(other.opisTitula))
			return false;
		return true;
	}
}

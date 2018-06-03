package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import javax.persistence.*;

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

	public CertifikatDiploma() {
	}

	public CertifikatDiploma(Integer certDiplID, Integer idVjestina, String opisTitula) {
		this.certDiplID = certDiplID;
		this.idVjestina = idVjestina;
		this.opisTitula = opisTitula;
	}

	public Integer getCertDiplID() {
		return certDiplID;
	}

	public Integer getIdVjestina() {
		return idVjestina;
	}

	public String getOpisTitula() {
		return opisTitula;
	}

	public void setCertDiplID(Integer certDiplID) {
		this.certDiplID = certDiplID;
	}

	public void setIdVjestina(Integer idVjestina) {
		this.idVjestina = idVjestina;
	}

	public void setOpisTitula(String opisTitula) {
		this.opisTitula = opisTitula;
	}
}

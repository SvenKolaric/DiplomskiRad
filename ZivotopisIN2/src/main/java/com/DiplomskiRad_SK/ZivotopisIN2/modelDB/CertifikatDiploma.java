package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

public class CertifikatDiploma {
	private Integer certDiplID;
	private Integer idVjestina;
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
	
}

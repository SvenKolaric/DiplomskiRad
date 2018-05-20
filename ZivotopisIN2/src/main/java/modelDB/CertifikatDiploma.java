package modelDB;

public class CertifikatDiploma {
	private final Integer certDiplID;
	private final Integer idVjestina;
	private final String opisTitula;
	
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

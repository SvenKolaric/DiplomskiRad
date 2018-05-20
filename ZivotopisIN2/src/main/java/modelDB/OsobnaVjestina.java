package modelDB;

public class OsobnaVjestina {
	private final Integer vjestinaID;
	private final Integer idCV;
	private final String obradaInfo;
	private final String komunikacija;
	private final String stvaranjeSadrzaja;
	private final String sigurnost;
	private final String rjesavanjeProblema;
	private final String materinjiJezik;
	private final String komunikacijskeVj;
	private final String organizacijskeVj;
	private final String poslovneVj;
	private final String ostaleVj;
	
	private final Iterable<Zna> jezikList;
	private final Iterable<VozackaDozvola> vozackaDozvolaList;
	private final Iterable<CertifikatDiploma> certifikatDiplomaList;
	
	public OsobnaVjestina(Integer vjestinaID, Integer idCV, String obradaInfo, String komunikacija,
			String stvaranjeSadrzaja, String sigurnost, String rjesavanjeProblema, String materinjiJezik,
			String komunikacijskeVj, String organizacijskeVj, String poslovneVj, String ostaleVj,
			Iterable<Zna> jezikList, Iterable<VozackaDozvola> vozackaDozvolaList, Iterable<CertifikatDiploma> certifikatDiplomaList) {
		this.vjestinaID = vjestinaID;
		this.idCV = idCV;
		this.obradaInfo = obradaInfo;
		this.komunikacija = komunikacija;
		this.stvaranjeSadrzaja = stvaranjeSadrzaja;
		this.sigurnost = sigurnost;
		this.rjesavanjeProblema = rjesavanjeProblema;
		this.materinjiJezik = materinjiJezik;
		this.komunikacijskeVj = komunikacijskeVj;
		this.organizacijskeVj = organizacijskeVj;
		this.poslovneVj = poslovneVj;
		this.ostaleVj = ostaleVj;
		this.jezikList = jezikList;
		this.vozackaDozvolaList = vozackaDozvolaList;
		this.certifikatDiplomaList = certifikatDiplomaList;
	}

	public Iterable<Zna> getJezikList() {
		return jezikList;
	}

	public Iterable<VozackaDozvola> getVozackaDozvolaList() {
		return vozackaDozvolaList;
	}

	public Iterable<CertifikatDiploma> getCertifikatDiplomaList() {
		return certifikatDiplomaList;
	}

	public Integer getVjestinaID() {
		return vjestinaID;
	}

	public Integer getIdCV() {
		return idCV;
	}

	public String getObradaInfo() {
		return obradaInfo;
	}

	public String getKomunikacija() {
		return komunikacija;
	}

	public String getStvaranjeSadrzaja() {
		return stvaranjeSadrzaja;
	}

	public String getSigurnost() {
		return sigurnost;
	}

	public String getRjesavanjeProblema() {
		return rjesavanjeProblema;
	}

	public String getMaterinjiJezik() {
		return materinjiJezik;
	}

	public String getKomunikacijskeVj() {
		return komunikacijskeVj;
	}

	public String getOrganizacijskeVj() {
		return organizacijskeVj;
	}

	public String getPoslovneVj() {
		return poslovneVj;
	}

	public String getOstaleVj() {
		return ostaleVj;
	}
	
	
}

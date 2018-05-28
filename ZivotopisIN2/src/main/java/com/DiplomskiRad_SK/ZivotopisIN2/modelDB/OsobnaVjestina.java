package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import java.util.ArrayList;

public class OsobnaVjestina {
	private Integer vjestinaID;
	private Integer idCV;
	private String obradaInfo;
	private String komunikacija;
	private String stvaranjeSadrzaja;
	private String sigurnost;
	private String rjesavanjeProblema;
	private String materinjiJezik;
	private String komunikacijskeVj;
	private String organizacijskeVj;
	private String poslovneVj;
	private String ostaleVj;

	private ArrayList<Zna> jezikList;
	private ArrayList<VozackaDozvola> vozackaDozvolaList;
	private ArrayList<CertifikatDiploma> certifikatDiplomaList;

	public OsobnaVjestina() {
	}

	public OsobnaVjestina(Integer vjestinaID, Integer idCV, String obradaInfo, String komunikacija,
			String stvaranjeSadrzaja, String sigurnost, String rjesavanjeProblema, String materinjiJezik,
			String komunikacijskeVj, String organizacijskeVj, String poslovneVj, String ostaleVj,
			ArrayList<Zna> jezikList, ArrayList<VozackaDozvola> vozackaDozvolaList,
			ArrayList<CertifikatDiploma> certifikatDiplomaList) {
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

	public ArrayList<Zna> getJezikList() {
		return jezikList;
	}

	public ArrayList<VozackaDozvola> getVozackaDozvolaList() {
		return vozackaDozvolaList;
	}

	public ArrayList<CertifikatDiploma> getCertifikatDiplomaList() {
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

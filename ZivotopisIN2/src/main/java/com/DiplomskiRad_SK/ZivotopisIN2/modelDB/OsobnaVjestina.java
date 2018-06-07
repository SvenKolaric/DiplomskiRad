package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
@Table(name = "OSOBNA_VJESTINA")
public class OsobnaVjestina {
	@Id
	@GeneratedValue(generator = "OVSeq")
	@SequenceGenerator(name = "OVSeq", sequenceName = "OSOBNA_VJESTINA_SEQ", allocationSize = 1)
	private Integer vjestinaID;
	@Column(name = "IDCV")
	private Integer idCV;
	@Column(name = "OBRADAINFO")
	private String obradaInfo;
	@Column(name = "KOMUNIKACIJA")
	private String komunikacija;
	@Column(name = "STVARANJESADRZAJA")
	private String stvaranjeSadrzaja;
	@Column(name = "SIGURNOST")
	private String sigurnost;
	@Column(name = "RJESAVANJEPROBLEMA")
	private String rjesavanjeProblema;
	@Column(name = "MATERINJIJEZIK")
	private String materinjiJezik;
	@Column(name = "KOMUNIKACIJSKEVJ")
	private String komunikacijskeVj;
	@Column(name = "ORGANIZACIJSKEVJ")
	private String organizacijskeVj;
	@Column(name = "POSLOVNEVJ")
	private String poslovneVj;
	@Column(name = "OSTALEVJ")
	private String ostaleVj;
	@Transient
	private ArrayList<Zna> jezikList;
	@Transient
	private ArrayList<VozackaOsobnaVJ> vozackaDozvolaList;
	@Transient
	private ArrayList<CertifikatDiploma> certifikatDiplomaList;
	@Transient
	private CV zivotopis;
	
	public OsobnaVjestina() {
	}

	public OsobnaVjestina(Integer vjestinaID, Integer idCV, String obradaInfo, String komunikacija,
			String stvaranjeSadrzaja, String sigurnost, String rjesavanjeProblema, String materinjiJezik,
			String komunikacijskeVj, String organizacijskeVj, String poslovneVj, String ostaleVj,
			ArrayList<Zna> jezikList, ArrayList<VozackaOsobnaVJ> vozackaDozvolaList,
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

	public ArrayList<VozackaOsobnaVJ> getVozackaDozvolaList() {
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

	public void setVjestinaID(Integer vjestinaID) {
		this.vjestinaID = vjestinaID;
	}

	public void setIdCV(Integer idCV) {
		this.idCV = idCV;
	}

	public void setObradaInfo(String obradaInfo) {
		this.obradaInfo = obradaInfo;
	}

	public void setKomunikacija(String komunikacija) {
		this.komunikacija = komunikacija;
	}

	public void setStvaranjeSadrzaja(String stvaranjeSadrzaja) {
		this.stvaranjeSadrzaja = stvaranjeSadrzaja;
	}

	public void setSigurnost(String sigurnost) {
		this.sigurnost = sigurnost;
	}

	public void setRjesavanjeProblema(String rjesavanjeProblema) {
		this.rjesavanjeProblema = rjesavanjeProblema;
	}

	public void setMaterinjiJezik(String materinjiJezik) {
		this.materinjiJezik = materinjiJezik;
	}

	public void setKomunikacijskeVj(String komunikacijskeVj) {
		this.komunikacijskeVj = komunikacijskeVj;
	}

	public void setOrganizacijskeVj(String organizacijskeVj) {
		this.organizacijskeVj = organizacijskeVj;
	}

	public void setPoslovneVj(String poslovneVj) {
		this.poslovneVj = poslovneVj;
	}

	public void setOstaleVj(String ostaleVj) {
		this.ostaleVj = ostaleVj;
	}

	public void setJezikList(ArrayList<Zna> jezikList) {
		this.jezikList = jezikList;
	}

	public void setVozackaDozvolaList(ArrayList<VozackaOsobnaVJ> vozackaDozvolaList) {
		this.vozackaDozvolaList = vozackaDozvolaList;
	}

	public void setCertifikatDiplomaList(ArrayList<CertifikatDiploma> certifikatDiplomaList) {
		this.certifikatDiplomaList = certifikatDiplomaList;
	}

	public CV getZivotopis() {
		return zivotopis;
	}

	public void setZivotopis(CV zivotopis) {
		this.zivotopis = zivotopis;
	}

}

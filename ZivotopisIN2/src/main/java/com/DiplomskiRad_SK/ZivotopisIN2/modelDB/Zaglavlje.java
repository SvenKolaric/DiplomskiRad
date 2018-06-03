package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import javax.persistence.*;

@Entity
@Table(name = "ZAGLAVLJE")
public class Zaglavlje {
	@Id
	@GeneratedValue(generator = "ZSeq")
	@SequenceGenerator(name = "ZSeq", sequenceName = "ZAGLAVLJE_SEQ", allocationSize = 1)
	private Integer zaglavljeID;
	@Column(name = "IDCV")
	private Integer idCV;
	@Column(name = "OPIS")
	private String opis;
	@Column(name = "IDPRIJAVE")
	private Integer idPrijave;
	@Transient
	private VrstaPrijave vrstaPrijave;
	
	public Zaglavlje() {
	}

	public Zaglavlje(Integer zaglavljeID, Integer idCV, String opis, Integer idPrijave, VrstaPrijave vrstaPrijave) {
		this.zaglavljeID = zaglavljeID;
		this.idCV = idCV;
		this.opis = opis;
		this.idPrijave = idPrijave;
		this.vrstaPrijave = vrstaPrijave;
	}

	public VrstaPrijave getVrstaPrijave() {
		return vrstaPrijave;
	}

	public Integer getZaglavljeID() {
		return zaglavljeID;
	}

	public Integer getIdCV() {
		return idCV;
	}

	public String getOpis() {
		return opis;
	}

	public Integer getIdPrijave() {
		return idPrijave;
	}

	public void setZaglavljeID(Integer zaglavljeID) {
		this.zaglavljeID = zaglavljeID;
	}

	public void setIdCV(Integer idCV) {
		this.idCV = idCV;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public void setIdPrijave(Integer idPrijave) {
		this.idPrijave = idPrijave;
	}

	public void setVrstaPrijave(VrstaPrijave vrstaPrijave) {
		this.vrstaPrijave = vrstaPrijave;
	}
	
}

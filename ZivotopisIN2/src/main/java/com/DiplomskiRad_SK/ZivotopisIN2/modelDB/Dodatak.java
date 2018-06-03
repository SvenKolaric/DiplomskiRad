package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import javax.persistence.*;

@Entity
@Table(name = "DODATAK")
public class Dodatak {
	@Id
	@GeneratedValue(generator = "DodSeq")
	@SequenceGenerator(name = "DodSeq", sequenceName = "DODATAK_SEQ", allocationSize = 1)
	private Integer ID;
	@Column(name = "METADATA")
	private String metadata;
	@Column(name = "TEXT")
	private String text;
	@Column(name = "IDCV")
	private Integer idCV;

	public Dodatak() {
	}

	public Dodatak(Integer iD, String metadata, String text, Integer idCV) {
		ID = iD;
		this.metadata = metadata;
		this.text = text;
		this.idCV = idCV;
	}

	public Integer getID() {
		return ID;
	}

	public String getMetadata() {
		return metadata;
	}

	public String getText() {
		return text;
	}

	public Integer getIdCV() {
		return idCV;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setIdCV(Integer idCV) {
		this.idCV = idCV;
	}

}

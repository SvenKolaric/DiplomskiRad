package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "UPIT")
public class Upit {
	@Id
	@GeneratedValue(generator = "UPITSeq")
	@SequenceGenerator(name = "UPITSeq", sequenceName = "UPIT_SEQ", allocationSize = 1)
	private Integer id;
	@Column(name = "TEZINA")
	private Integer tezina;
	@Column(name = "VRIJEDNOST")
	private Integer vrijednost;
	@Column(name = "UPIT")
	private String upit;
	
	public Upit() {
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTezina() {
		return tezina;
	}
	public void setTezina(Integer tezina) {
		this.tezina = tezina;
	}
	public Integer getVrijednost() {
		return vrijednost;
	}
	public void setVrijednost(Integer vrijednost) {
		this.vrijednost = vrijednost;
	}
	public String getUpit() {
		return upit;
	}
	public void setUpit(String upit) {
		this.upit = upit;
	}

}

package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "UPIT")
public class Upit {
	@Id
	@Column(name = "ID", nullable = false)
	private Integer id;
	@Transient
	private Integer tezina;
	@Transient
	private Integer vrijednost;
	@Column(name = "UPIT")
	private String upit;
	
	public Upit() {
		
	}
	
	public Upit(Integer id, Integer tezina, Integer vrijednost, String upit) {
		this.id = id;
		this.tezina = tezina;
		this.vrijednost = vrijednost;
		this.upit = upit;
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

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
                .append(id)
                .append(upit)
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
		Upit other = (Upit) obj;
		return new EqualsBuilder()
                .append(id, other.id)
                .append(upit, other.upit)
                .isEquals();
		
	}
}

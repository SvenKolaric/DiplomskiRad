package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "VOZACKA_DOZVOLA")
public class VozackaDozvola {
	@Id
	@GeneratedValue(generator = "VDSeq")
	@SequenceGenerator(name = "VDSeq", sequenceName = "VOZACKA_DOZVOLA_SEQ", allocationSize = 1)
	private Integer vozackaID;
	@Column(name = "KATEGORIJA")
	private String kategorija;
	
	@OneToMany(mappedBy = "vozackaDozvola", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<VozackaOsobnaVJ> vozackaOsobnaVJList = new ArrayList<>();
	
	public VozackaDozvola() {
	}

	public VozackaDozvola(Integer vozackaID, String kategorija) {
		this.vozackaID = vozackaID;
		this.kategorija = kategorija;
	}

	/*synchronize both sides of the bidirectional association*/
	public void addVozackaOsobnaVJ(VozackaOsobnaVJ obj) {
		vozackaOsobnaVJList.add(obj);
        obj.setVozackaDozvola(this);
    }
	
	public void removeVozackaOsobnaVJ(VozackaOsobnaVJ obj) {
		vozackaOsobnaVJList.remove(obj);
        obj.setVozackaDozvola(this);
    }
	
	public Integer getVozackaID() {
		return vozackaID;
	}

	public String getKategorija() {
		return kategorija;
	}

	public void setVozackaID(Integer vozackaID) {
		this.vozackaID = vozackaID;
	}

	public void setKategorija(String kategorija) {
		this.kategorija = kategorija;
	}
	
}

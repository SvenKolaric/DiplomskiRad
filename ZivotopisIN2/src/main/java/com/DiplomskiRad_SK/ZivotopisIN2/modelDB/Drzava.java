package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "DRZAVA")
public class Drzava {
	@Id
	@GeneratedValue(generator="DrzSeq") 
    @SequenceGenerator(name="DrzSeq",sequenceName="DRZAVA_SEQ", allocationSize=1)
	private Integer drzavaID;
	@Column(name = "NAZIV")
	private String naziv;

	@OneToMany(mappedBy = "drzava", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Mjesto> mjestoList = new ArrayList<>();
	
	public Drzava() {
	}

	public Drzava(Integer drzavaID, String naziv) {
		this.drzavaID = drzavaID;
		this.naziv = naziv;
	}
	
	/*synchronize both sides of the bidirectional association*/
	public void addMjesto(Mjesto obj) {
		mjestoList.add(obj);
        obj.setDrzava(this);
    }
 
    public void removeMjesto(Mjesto obj) {
    	mjestoList.remove(obj);
        obj.setDrzava(null);
    }
    
	public Integer getDrzavaID() {
		return drzavaID;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setDrzavaID(Integer drzavaID) {
		this.drzavaID = drzavaID;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Mjesto> getMjesto() {
		return mjestoList;
	}

	public void setMjesto(List<Mjesto> mjesto) {
		this.mjestoList = mjesto;
	}

}

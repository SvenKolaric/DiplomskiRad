package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "KATEGORIJA")
public class Kategorija {
	@Id
	@GeneratedValue(generator = "KSeq")
	@SequenceGenerator(name = "KSeq", sequenceName = "KATEGORIJA_SEQ", allocationSize = 1)
	private Integer kategorijaID;
	@Column(name = "NAZIV")
	private String naziv;
	
	@OneToMany(mappedBy = "kategorija", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DodatneInfo> dodatneInfoList = new ArrayList<>();
	
	public Kategorija() {
	}

	public Kategorija(Integer kategorijaID, String naziv) {
		this.kategorijaID = kategorijaID;
		this.naziv = naziv;
	}

	public void addDodatneInfo(DodatneInfo obj) {
    	dodatneInfoList.add(obj);
        obj.setKategorija(this);
    }
 
    public void removeDodatneInfo(DodatneInfo obj) {
    	dodatneInfoList.remove(obj);
        obj.setKategorija(this);
    }
    
	public Integer getKategorijaID() {
		return kategorijaID;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setKategorijaID(Integer kategorijaID) {
		this.kategorijaID = kategorijaID;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<DodatneInfo> getDodatneInfoList() {
		return dodatneInfoList;
	}

	public void setDodatneInfoList(List<DodatneInfo> dodatneInfoList) {
		this.dodatneInfoList = dodatneInfoList;
	}

}

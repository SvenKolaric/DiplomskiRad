package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "TIP_KONTAKTA")
public class TipKontakta {
	@Id
	@GeneratedValue(generator = "TPSeq")
	@SequenceGenerator(name = "TPSeq", sequenceName = "TIP_KONTAKTA_SEQ", allocationSize = 1)
	private Integer kontaktID;
	@Column(name = "NAZIV")
	private String naziv;
	
	@OneToMany(mappedBy = "tipKontakta", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<KontaktniInfo> kontaktniInfoList = new ArrayList<>();
	
	public TipKontakta() {
	}

	public TipKontakta(Integer kontaktID, String naziv) {
		this.kontaktID = kontaktID;
		this.naziv = naziv;
	}

	/*synchronize both sides of the bidirectional association*/
	public void addKontaktniInfo(KontaktniInfo obj) {
		kontaktniInfoList.add(obj);
        obj.setTipKontakta(this);
    }
 
    public void removeKontaktniInfo(KontaktniInfo obj) {
    	kontaktniInfoList.remove(obj);
        obj.setTipKontakta(null);
    }
    
	public Integer getKontaktID() {
		return kontaktID;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setKontaktID(Integer kontaktID) {
		this.kontaktID = kontaktID;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	public List<KontaktniInfo> getKontaktniInfoList() {
		return kontaktniInfoList;
	}

	public void setKontaktniInfoList(List<KontaktniInfo> kontaktniInfoList) {
		this.kontaktniInfoList = kontaktniInfoList;
	}

	public void setDependenciesNull() {
		this.setKontaktniInfoList(null);
	}
}

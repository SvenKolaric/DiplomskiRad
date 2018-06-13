package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "JEZIK")
public class Jezik {
	@Id
	@GeneratedValue(generator="JSeq") 
    @SequenceGenerator(name="JSeq",sequenceName="JEZIK_SEQ", allocationSize=1)
	private Integer jezikID;
	@Column(name = "NAZIV")
	private String naziv;
	
	@OneToMany(mappedBy = "jezik", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Zna> znaList = new ArrayList<>();
	
	public Jezik() {
	}

	public Jezik(Integer jezikID, String naziv) {
		this.jezikID = jezikID;
		this.naziv = naziv;
	}

	/*synchronize both sides of the bidirectional association*/
	public void addZna(Zna obj) {
		znaList.add(obj);
        obj.setJezik(this);
    }
 
    public void removeZna(Zna obj) {
    	znaList.remove(obj);
        obj.setJezik(null);
    }
    
	public Integer getJezikID() {
		return jezikID;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setJezikID(Integer jezikID) {
		this.jezikID = jezikID;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Zna> getZnaList() {
		return znaList;
	}

	public void setZnaList(List<Zna> znaList) {
		this.znaList = znaList;
	}
	
}

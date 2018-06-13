package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "VRSTA_PRIJAVE")
public class VrstaPrijave {
	@Id
	@GeneratedValue(generator = "VPSeq")
	@SequenceGenerator(name = "VPSeq", sequenceName = "VRSTA_PRIJAVE_SEQ", allocationSize = 1)
	private Integer prijavaID;
	@Column(name = "NAZIV")
	private String naziv;
	
	@OneToMany(mappedBy = "vrstaPrijave", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Zaglavlje> zaglavljeList = new ArrayList<>();
	
	public VrstaPrijave() {
	}

	public VrstaPrijave(Integer prijavaID, String naziv) {
		this.prijavaID = prijavaID;
		this.naziv = naziv;
	}

	/*synchronize both sides of the bidirectional association*/
	public void addZaglavlje(Zaglavlje obj) {
		zaglavljeList.add(obj);
        obj.setVrstaPrijave(this);
    }
 
    public void removeZaglavlje(Zaglavlje obj) {
    	zaglavljeList.remove(obj);
        obj.setVrstaPrijave(null);
    }
    
	public Integer getPrijavaID() {
		return prijavaID;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setPrijavaID(Integer prijavaID) {
		this.prijavaID = prijavaID;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
}

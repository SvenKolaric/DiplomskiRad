package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "DRZAVLJANSTVO")
public class Drzavljanstvo {
	@Id
	@GeneratedValue(generator="DrzaSeq") 
    @SequenceGenerator(name="DrzaSeq",sequenceName="DRZAVLJANSTVO_SEQ", allocationSize=1)
	private Integer drzavljanstvoID;
	@Column(name = "NAZIV")
	private String naziv;
	
	@OneToMany(mappedBy = "drzavljanstvo", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OsobaDrzavljanstvo> osobaDrzavljanstvoList = new ArrayList<>();
	public Drzavljanstvo() {
	}

	public Drzavljanstvo(Integer drzavljanstvoID, String naziv) {
		this.drzavljanstvoID = drzavljanstvoID;
		this.naziv = naziv;
	}

	/*synchronize both sides of the bidirectional association*/
	public void addOsobaDrzavljanstvo(OsobaDrzavljanstvo obj) {
		osobaDrzavljanstvoList.add(obj);
        obj.setDrzavljanstvo(this);
    }
 
    public void removeOsobaDrzavljanstvo(OsobaDrzavljanstvo obj) {
    	osobaDrzavljanstvoList.remove(obj);
        obj.setDrzavljanstvo(null);
    }
    
	public Integer getDrzavljanstvoID() {
		return drzavljanstvoID;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setDrzavljanstvoID(Integer drzavljanstvoID) {
		this.drzavljanstvoID = drzavljanstvoID;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<OsobaDrzavljanstvo> getOsobaDrzavljanstvoList() {
		return osobaDrzavljanstvoList;
	}

	public void setOsobaDrzavljanstvoList(List<OsobaDrzavljanstvo> osobaDrzavljanstvoList) {
		this.osobaDrzavljanstvoList = osobaDrzavljanstvoList;
	}
	
	public void setDependenciesNull() {
		this.setOsobaDrzavljanstvoList(null);
	}
}

package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "POZICIJA")
public class Pozicija {
	@Id
	@GeneratedValue(generator = "PSeq")
	@SequenceGenerator(name = "PSeq", sequenceName = "POZICIJA_SEQ", allocationSize = 1)
	private Integer pozicijaID;
	@Column(name = "NAZIV")
	private String naziv;
	
	@OneToMany(mappedBy = "pozicija", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RadnoIskustvo> radnoIskustvoList = new ArrayList<>();
	
	public Pozicija() {
	}

	public Pozicija(Integer pozicijaID, String naziv) {
		this.pozicijaID = pozicijaID;
		this.naziv = naziv;
	}

	/*synchronize both sides of the bidirectional association*/
	public void addRadnoIskustvo(RadnoIskustvo obj) {
		radnoIskustvoList.add(obj);
        obj.setPozicija(this);
    }
 
    public void removeRadnoIskustvo(RadnoIskustvo obj) {
    	radnoIskustvoList.remove(obj);
        obj.setPozicija(null);
    }
    
	public Integer getPozicijaID() {
		return pozicijaID;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setPozicijaID(Integer pozicijaID) {
		this.pozicijaID = pozicijaID;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

}

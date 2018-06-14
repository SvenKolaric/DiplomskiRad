package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "KORISNICKA_ULOGA")
public class KorisnickaUloga {

	@Id
	@GeneratedValue(generator = "KORISNIKCA_ULOGASeq")
	@SequenceGenerator(name = "KORISNIKCA_ULOGASeq", sequenceName = "KORISNIKCA_ULOGA_SEQ", allocationSize = 1)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "ULOGA")
	private String uloga;
	
	@OneToMany(mappedBy = "uloga", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Korisnik> korisnikList = new ArrayList<>();
	
	public void addKorisnik(Korisnik obj) {
		korisnikList.add(obj);
        obj.setUloga(this);
    }
 
    public void removeKorisnik(Korisnik obj) {
    	korisnikList.remove(obj);
        obj.setUloga(null);
    }
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUloga() {
		return uloga;
	}
	public void setUloga(String uloga) {
		this.uloga = uloga;
	}
	
	
}

package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "MJESTO")
public class Mjesto {
	@Id
	@GeneratedValue(generator = "MSeq")
	@SequenceGenerator(name = "MSeq", sequenceName = "MJESTO_SEQ", allocationSize = 1)
	private Integer mjestoID;
	@Column(name = "PBR")
	private Integer pBR;
	@Column(name = "NAZIV")
	private String naziv;
	
	@OneToMany(mappedBy = "mjesto", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Osoba> osobaList = new ArrayList<>();
	@OneToMany(mappedBy = "mjesto", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Institucija> institucijaList = new ArrayList<>();
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDDRZAVA")
	private Drzava drzava;

	public Mjesto() {
	}

	public Mjesto(Integer mjestoID, Integer PBR, String naziv) {
		this.mjestoID = mjestoID;
		this.pBR = PBR;
		this.naziv = naziv;
	}
	
	/*synchronize both sides of the bidirectional association*/
	public void addOsoba(Osoba obj) {
    	osobaList.add(obj);
        obj.setMjesto(this);
    }
 
    public void removeOsoba(Osoba obj) {
    	osobaList.remove(obj);
        obj.setMjesto(null);
    }
    
	public void addInstitucija(Institucija obj) {
    	institucijaList.add(obj);
        obj.setMjesto(this);
    }
 
    public void removeInstitucija(Institucija obj) {
    	institucijaList.remove(obj);
        obj.setMjesto(null);
    }
    
	public Drzava getDrzava() {
		return drzava;
	}

	public List<Institucija> getInstitucijaList() {
		return institucijaList;
	}

	public Integer getMjestoID() {
		return mjestoID;
	}

	public List<Osoba> getOsobaList() {
		return osobaList;
	}

	public Integer getPBR() {
		return pBR;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setMjestoID(Integer mjestoID) {
		this.mjestoID = mjestoID;
	}

	public void setPBR(Integer PBR) {
		this.pBR = PBR;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public void setOsobaList(List<Osoba> osobaList) {
		this.osobaList = osobaList;
	}

	public void setInstitucijaList(List<Institucija> institucijaList) {
		this.institucijaList = institucijaList;
	}

	public void setDrzava(Drzava drzava) {
		this.drzava = drzava;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
                .append(pBR)
                .append(naziv)
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
		Mjesto other = (Mjesto) obj;
			return new EqualsBuilder()
	                .append(naziv, other.naziv)
	                .append(pBR, other.pBR)
	                .isEquals();
	}

	public void setDependenciesNull() {
		this.setDrzava(null);
		this.setInstitucijaList(null);
		this.setOsobaList(null);
	}

	@Override
	public String toString() {
		return pBR + " " + naziv;
	}
}

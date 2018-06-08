package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "INSTITUCIJA")
public class Institucija {
	@Id
	@GeneratedValue(generator = "ISeq")
	@SequenceGenerator(name = "ISeq", sequenceName = "INSTITUCIJA_SEQ", allocationSize = 1)
	private Integer institucijaID;
	@Column(name = "ADRESA")
	private String adresa;
	@Column(name = "WEBSTRANICA")
	private String webStranica;
	@Column(name = "NAZIV")
	private String naziv;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDMJESTO")
	private Mjesto mjesto;
	@OneToMany(mappedBy = "institucija", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RadnoIskustvo> radnoIskustvoList = new ArrayList<>();
	@OneToMany(mappedBy = "institucija", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<EdukacijaITrening> edukacijaTreningList = new ArrayList<>();
	
	public Institucija() {
	}

	public Institucija(Integer institucijaID, String adresa, String webStranica, String naziv) {
		this.institucijaID = institucijaID;
		this.adresa = adresa;
		this.webStranica = webStranica;
		this.naziv = naziv;
	}

	/*synchronize both sides of the bidirectional association*/
	public void addRadnoIskustvo(RadnoIskustvo obj) {
		radnoIskustvoList.add(obj);
        obj.setInstitucija(this);
    }
 
    public void removeRadnoIskustvo(RadnoIskustvo obj) {
    	radnoIskustvoList.remove(obj);
        obj.setInstitucija(this);
    }
    
    public void addEdukacijaITrening(EdukacijaITrening obj) {
    	edukacijaTreningList.add(obj);
        obj.setInstitucija(this);
    }
 
    public void removeEdukacijaITrening(EdukacijaITrening obj) {
    	edukacijaTreningList.remove(obj);
        obj.setInstitucija(this);
    }
    
	public Mjesto getMjesto() {
		return mjesto;
	}

	public Integer getInstitucijaID() {
		return institucijaID;
	}

	public String getAdresa() {
		return adresa;
	}

	public String getWebStranica() {
		return webStranica;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setInstitucijaID(Integer institucijaID) {
		this.institucijaID = institucijaID;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public void setWebStranica(String webStranica) {
		this.webStranica = webStranica;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public void setMjesto(Mjesto mjesto) {
		this.mjesto = mjesto;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
                .append(adresa)
                .append(naziv)
                .append(webStranica)
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
		Institucija other = (Institucija) obj;
		return new EqualsBuilder()
                .append(adresa, other.adresa)
                .append(naziv, other.naziv)
                .append(webStranica, other.webStranica)
                .isEquals();
	}

	public List<RadnoIskustvo> getRadnoIskustvoList() {
		return radnoIskustvoList;
	}

	public void setRadnoIskustvoList(List<RadnoIskustvo> radnoIskustvoList) {
		this.radnoIskustvoList = radnoIskustvoList;
	}

	public List<EdukacijaITrening> getEdukacijaTreningList() {
		return edukacijaTreningList;
	}

	public void setEdukacijaTreningList(List<EdukacijaITrening> edukacijaTreningList) {
		this.edukacijaTreningList = edukacijaTreningList;
	}

}

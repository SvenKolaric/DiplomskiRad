package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;

@Entity
@Table(name = "OSOBA")
public class Osoba {
	@Id
	@GeneratedValue(generator = "OSeq")
	@SequenceGenerator(name = "OSeq", sequenceName = "OSOBA_SEQ", allocationSize = 1)
	private Integer osobaID;
	@Column(name = "IME")
	private String ime;
	@Column(name = "PREZIME")
	private String prezime;
	@Column(name = "GODINARODENJA")
	private Date godRodenja;
	@Column(name = "SPOL")
	private String spol;
	@Column(name = "ADRESA")
	private String adresa;
	@Column(name = "WEBSITE")
	private String website;

	@OneToMany(mappedBy = "osoba", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CV> zivotopisiList = new ArrayList<>();
	@OneToMany(mappedBy = "osoba", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<KontaktniInfo> kontaktInfoList = new ArrayList<>();
	@OneToMany(mappedBy = "osoba", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OsobaDrzavljanstvo> osobaDrzavljanstvoList = new ArrayList<>();
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDMJESTO")
	private Mjesto mjesto;
	
	public Osoba() {
	}

	public Osoba(Integer osobaID, String ime, String prezime, Date godRodenja, String spol, String adresa,
			String website) {
		this.osobaID = osobaID;
		this.ime = ime;
		this.prezime = prezime;
		this.godRodenja = godRodenja;
		this.spol = spol;
		this.adresa = adresa;
		this.website = website;
	}

	/*synchronize both sides of the bidirectional association*/
	public void addCV(CV obj) {
		zivotopisiList.add(obj);
        obj.setOsoba(this);
    }
 
    public void removeCV(CV obj) {
    	zivotopisiList.remove(obj);
        obj.setOsoba(null);
    }
    
    public void addKontaktniInfo(KontaktniInfo obj) {
    	kontaktInfoList.add(obj);
        obj.setOsoba(this);
    }
 
    public void removeKontaktniInfo(KontaktniInfo obj) {
    	kontaktInfoList.remove(obj);
        obj.setOsoba(null);
    }
    
    public void addOsobaDrzavljanstvo(OsobaDrzavljanstvo obj) {
    	osobaDrzavljanstvoList.add(obj);
        obj.setOsoba(this);
    }
 
    public void removeOsobaDrzavljanstvo(OsobaDrzavljanstvo obj) {
    	osobaDrzavljanstvoList.remove(obj);
        obj.setOsoba(null);
    }
    
	public Mjesto getMjesto() {
		return mjesto;
	}

	public List<OsobaDrzavljanstvo> getOsobaDrzavljanstvoList() {
		return osobaDrzavljanstvoList;
	}

	public Integer getOsobaID() {
		return osobaID;
	}

	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public Date getGodRodenja() {
		return godRodenja;
	}

	public String getSpol() {
		return spol;
	}

	public String getAdresa() {
		return adresa;
	}

	public List<CV> getZivotopisiList() {
		return zivotopisiList;
	}
	
	public List<KontaktniInfo> getKontaktInfoList() {
		return kontaktInfoList;
	}

	public void setOsobaID(Integer osobaID) {
		this.osobaID = osobaID;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public void setGodRodenja(Date godRodenja) {
		this.godRodenja = godRodenja;
	}

	public void setSpol(String string) {
		this.spol = string;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public void setMjesto(Mjesto mjesto) {
		this.mjesto = mjesto;
	}

	public String getWebsite() {
		return website;
	}

	public void setZivotopisiList(List<CV> zivotopisiList) {
		for (int count = 0; count < zivotopisiList.size(); count++) {
			zivotopisiList.get(count).setOsoba(this);
			this.zivotopisiList.add(zivotopisiList.get(count));
		}
	}

	public void setKontaktInfoList(List<KontaktniInfo> kontaktInfoList) {
		for (int count = 0; count < kontaktInfoList.size(); count++) {
			kontaktInfoList.get(count).setOsoba(this);
			this.kontaktInfoList.add(kontaktInfoList.get(count));
		}
	}

	public void setDrzavljanstvoList(List<OsobaDrzavljanstvo> osobaDrzavljanstvoList) {
		for (int count = 0; count < osobaDrzavljanstvoList.size(); count++) {
			osobaDrzavljanstvoList.get(count).setOsoba(this);
			this.osobaDrzavljanstvoList.add(osobaDrzavljanstvoList.get(count));
		}
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
                .append(adresa)
                .append(godRodenja)
                .append(ime)
                .append(prezime)
                .append(spol)
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
		Osoba other = (Osoba) obj;
		return new EqualsBuilder()
                .append(adresa, other.adresa)
                .append(godRodenja, other.godRodenja)
                .append(ime, other.prezime)
                .append(prezime, other.prezime)
                .append(spol, this.spol)
                .isEquals();
	}
}

package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


@Entity
@Table(name = "CV")
public class CV {
	@Id
	@GeneratedValue(generator = "CVSeq")
	@SequenceGenerator(name = "CVSeq", sequenceName = "CV_SEQ", allocationSize = 1)
	private Integer zivotopisID;
	@Column(name = "TIPDOKUMENTA")
	private String tipDokumenta;
	@Column(name = "DATUMSTVARANJA")
	private Timestamp datumStvaranja;
	@Column(name = "DATUMAZURIRANJA")
	private Timestamp datumAzuriranja;

	
	@OneToMany(mappedBy = "zivotopis", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OsobnaVjestina> osobnaVjestinaList = new ArrayList<>();
	@OneToMany(mappedBy = "zivotopis", cascade = CascadeType.ALL, orphanRemoval = true) //IME ATRIBUTA U DODATNEINFO KOJI TI REFERENCIRAM
	private List<DodatneInfo> dodatneInfoList= new ArrayList<>();
	@OneToMany(mappedBy = "zivotopis", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Dodatak> dodatakList= new ArrayList<>();
	@OneToMany(mappedBy = "zivotopis", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RadnoIskustvo> radnoIskustvoList= new ArrayList<>();
	@OneToMany(mappedBy = "zivotopis", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<EdukacijaITrening> edukacijaITreningList= new ArrayList<>();
	
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "zivotopis")
	@Transient
	private Zaglavlje zaglavlje;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDOSOBA")
	private Osoba osoba;

	public CV() {}

	public CV(Integer zivotopisID, String tipDokumenta, Timestamp datumStvaranja, Timestamp datumAzuriranja) {
		this.zivotopisID = zivotopisID;
		this.tipDokumenta = tipDokumenta;
		this.datumStvaranja = datumStvaranja;
		this.datumAzuriranja = datumAzuriranja;
	}
	
	/*synchronize both sides of the bidirectional association*/
	public void addOsobnaVjestina(OsobnaVjestina obj) {
		osobnaVjestinaList.add(obj);
        obj.setZivotopis(this);
    }
 
    public void removeOsobnaVjestina(OsobnaVjestina obj) {
    	osobnaVjestinaList.remove(obj);
        obj.setZivotopis(null);
    }
    
	public void addDodatneInfo(DodatneInfo obj) {
    	dodatneInfoList.add(obj);
        obj.setZivotopis(this);
    }
 
    public void removeDodatneInfo(DodatneInfo obj) {
    	dodatneInfoList.remove(obj);
        obj.setZivotopis(this);
    }
    
    public void addDodatak(Dodatak obj) {
    	dodatakList.add(obj);
        obj.setZivotopis(this);
    }
 
    public void removeDodatak(Dodatak obj) {
    	dodatakList.remove(obj);
        obj.setZivotopis(this);
    }
    
    public void addRadnoIskustvo(RadnoIskustvo obj) {
    	radnoIskustvoList.add(obj);
        obj.setZivotopis(this);
    }
    
    public void removeRadnoIskustvo(RadnoIskustvo obj) {
    	radnoIskustvoList.remove(obj);
        obj.setZivotopis(this);
    }
    
    public void addEdukacijaITrening(EdukacijaITrening obj) {
    	edukacijaITreningList.add(obj);
        obj.setZivotopis(this);
    }
 
    public void removeEdukacijaITrening(EdukacijaITrening obj) {
    	edukacijaITreningList.remove(obj);
        obj.setZivotopis(this);
    }
    
    //Getters and Setters
	public void setZivotopisID(Integer zivotopisID) {
		this.zivotopisID = zivotopisID;
	}

	public void setTipDokumenta(String tipDokumenta) {
		this.tipDokumenta = tipDokumenta;
	}

	public void setDatumStvaranja(Timestamp datumStvaranja) {
		this.datumStvaranja = datumStvaranja;
	}

	public void setDatumAzuriranja(Timestamp datumAzuriranja) {
		this.datumAzuriranja = datumAzuriranja;
	}

	public void setOsobnaVjestinaList(ArrayList<OsobnaVjestina> osobnaVjestinaList) {
		this.osobnaVjestinaList = osobnaVjestinaList;
	}

	public void setDodatneInfoList(ArrayList<DodatneInfo> dodatneInfoList) {
		this.dodatneInfoList = dodatneInfoList;
	}

	public void setDodatakList(ArrayList<Dodatak> dodatakList) {
		this.dodatakList = dodatakList;
	}

	public void setRadnoIskustvoList(ArrayList<RadnoIskustvo> radnoIskustvoList) {
		this.radnoIskustvoList = radnoIskustvoList;
	}

	public void setEdukacijaITreningList(ArrayList<EdukacijaITrening> edukacijaITreningList) {
		this.edukacijaITreningList = edukacijaITreningList;
	}

	public void setZaglavlje(Zaglavlje zaglavlje) {
		this.zaglavlje = zaglavlje;
	}

	public Integer getZivotopisID() {
		return zivotopisID;
	}

	public String getTipDokumenta() {
		return tipDokumenta;
	}

	public Timestamp getDatumStvaranja() {
		return datumStvaranja;
	}

	public Timestamp getDatumAzuriranja() {
		return datumAzuriranja;
	}

	public List<OsobnaVjestina> getOsobnaVjestinaList() {
		return osobnaVjestinaList;
	}

	public List<DodatneInfo> getDodatneInfoList() {
		return dodatneInfoList;
	}

	public List<Dodatak> getDodatakList() {
		return dodatakList;
	}

	public List<RadnoIskustvo> getRadnoIskustvoList() {
		return radnoIskustvoList;
	}

	public List<EdukacijaITrening> getEdukacijaITreningList() {
		return edukacijaITreningList;
	}

	public Zaglavlje getZaglavlje() {
		return zaglavlje;
	}

	public Osoba getOsoba() {
		return osoba;
	}

	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}
	
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
                .append(tipDokumenta)
                .append(datumAzuriranja)
                .append(datumStvaranja)
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
		CV other = (CV) obj;
		return new EqualsBuilder()
                .append(tipDokumenta, other.tipDokumenta)
                .append(datumAzuriranja, other.datumAzuriranja)
                .append(datumStvaranja, other.datumStvaranja)
                .isEquals();
		
	}

	public void setOsobnaVjestinaList(List<OsobnaVjestina> osobnaVjestinaList) {
		this.osobnaVjestinaList = osobnaVjestinaList;
	}

	public void setDodatneInfoList(List<DodatneInfo> dodatneInfoList) {
		this.dodatneInfoList = dodatneInfoList;
	}

	public void setDodatakList(List<Dodatak> dodatakList) {
		this.dodatakList = dodatakList;
	}

	public void setRadnoIskustvoList(List<RadnoIskustvo> radnoIskustvoList) {
		this.radnoIskustvoList = radnoIskustvoList;
	}

	public void setEdukacijaITreningList(List<EdukacijaITrening> edukacijaITreningList) {
		this.edukacijaITreningList = edukacijaITreningList;
	}

}

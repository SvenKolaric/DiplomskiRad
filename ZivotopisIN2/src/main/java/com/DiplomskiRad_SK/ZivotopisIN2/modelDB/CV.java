package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	@Column(name = "IDOSOBA")
	private Integer idOsoba;
	@Transient
	private ArrayList<OsobnaVjestina> osobnaVjestinaList;
	@Transient
	private ArrayList<DodatneInfo> dodatneInfoList;
	@Transient
	private ArrayList<Dodatak> dodatakList;
	@Transient
	private ArrayList<RadnoIskustvo> radnoIskustvoList;
	@Transient
	private ArrayList<EdukacijaITrening> edukacijaITreningList;
	@Transient
	private Zaglavlje zaglavlje;
	
	public CV() {
		
	}
	
	public CV(Integer zivotopisID, String tipDokumenta, Timestamp datumStvaranja, Timestamp datumAzuriranja,
			Integer idOsoba) {
		this.zivotopisID = zivotopisID;
		this.tipDokumenta = tipDokumenta;
		this.datumStvaranja = datumStvaranja;
		this.datumAzuriranja = datumAzuriranja;
		this.idOsoba = idOsoba;
	}

	public CV(Integer zivotopisID, String tipDokumenta, Timestamp datumStvaranja, Timestamp datumAzuriranja,
			Integer idOsoba, ArrayList<OsobnaVjestina> osobnaVjestinaList, ArrayList<DodatneInfo> dodatneInfoList,
			ArrayList<Dodatak> dodatakList, ArrayList<RadnoIskustvo> radnoIskustvoList, 
			ArrayList<EdukacijaITrening> edukacijaITreningList, Zaglavlje zaglavlje) {
		this.zivotopisID = zivotopisID;
		this.tipDokumenta = tipDokumenta;
		this.datumStvaranja = datumStvaranja;
		this.datumAzuriranja = datumAzuriranja;
		this.idOsoba = idOsoba;
		this.osobnaVjestinaList = osobnaVjestinaList;
		this.dodatneInfoList = dodatneInfoList;
		this.dodatakList = dodatakList;
		this.radnoIskustvoList = radnoIskustvoList;
		this.edukacijaITreningList = edukacijaITreningList;
		this.zaglavlje = zaglavlje;
	}
	


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

	public void setIdOsoba(Integer idOsoba) {
		this.idOsoba = idOsoba;
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

	public Integer getIdOsoba() {
		return idOsoba;
	}

	public ArrayList<OsobnaVjestina> getOsobnaVjestinaList() {
		return osobnaVjestinaList;
	}

	public ArrayList<DodatneInfo> getDodatneInfoList() {
		return dodatneInfoList;
	}

	public ArrayList<Dodatak> getDodatakList() {
		return dodatakList;
	}

	public ArrayList<RadnoIskustvo> getRadnoIskustvoList() {
		return radnoIskustvoList;
	}

	public ArrayList<EdukacijaITrening> getEdukacijaITreningList() {
		return edukacijaITreningList;
	}

	public Zaglavlje getZaglavlje() {
		return zaglavlje;
	}

	/*public Entities.City ToEntity()
    {
        Entities.City entity = new Entities.City
        {
            Id = Id,
            StateId = StateId,
            Name = Name
        };
        return entity;
    }*/
	
}

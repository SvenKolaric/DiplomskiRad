package modelDB;

import java.sql.Timestamp;
import java.util.ArrayList;

public class CV {
	private Integer zivotopisID;
	private String tipDokumeenta;
	private Timestamp datumStvaranja;
	private Timestamp datumAzuriranja;
	private Integer idOsoba;
	
	private ArrayList<OsobnaVjestina> osobnaVjestinaList;
	private ArrayList<DodatneInfo> dodatneInfoList;
	private ArrayList<Dodatak> dodatakList;
	private ArrayList<RadnoIskustvo> radnoIskustvoList;
	private ArrayList<EdukacijaITrening> edukacijaITreningList;
	private Zaglavlje zaglavlje;
	
	public CV() {
		
	}
	
	public CV(Integer zivotopisID, String tipDokumeenta, Timestamp datumStvaranja, Timestamp datumAzuriranja,
			Integer idOsoba, ArrayList<OsobnaVjestina> osobnaVjestinaList, ArrayList<DodatneInfo> dodatneInfoList,
			ArrayList<Dodatak> dodatakList, ArrayList<RadnoIskustvo> radnoIskustvoList, 
			ArrayList<EdukacijaITrening> edukacijaITreningList, Zaglavlje zaglavlje) {
		this.zivotopisID = zivotopisID;
		this.tipDokumeenta = tipDokumeenta;
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
	


	public Integer getZivotopisID() {
		return zivotopisID;
	}

	public String getTipDokumeenta() {
		return tipDokumeenta;
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

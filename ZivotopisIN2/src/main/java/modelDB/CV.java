package modelDB;

import java.sql.Timestamp;

public class CV {
	private final Integer zivotopisID;
	private final String tipDokumeenta;
	private final Timestamp datumStvaranja;
	private final Timestamp datumAzuriranja;
	private final Integer idOsoba;
	
	private final Iterable<OsobnaVjestina> osobnaVjestinaList;
	private final Iterable<DodatneInfo> dodatneInfoList;
	private final Iterable<Dodatak> dodatakList;
	private final Iterable<RadnoIskustvo> radnoIskustvoList;
	private final Iterable<EdukacijaITrening> edukacijaITreningList;
	private final Zaglavlje zaglavlje;

	public CV(Integer zivotopisID, String tipDokumeenta, Timestamp datumStvaranja, Timestamp datumAzuriranja,
			Integer idOsoba, Iterable<OsobnaVjestina> osobnaVjestinaList, Iterable<DodatneInfo> dodatneInfoList,
			Iterable<Dodatak> dodatakList, Iterable<RadnoIskustvo> radnoIskustvoList, 
			Iterable<EdukacijaITrening> edukacijaITreningList, Zaglavlje zaglavlje) {
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

	public Iterable<OsobnaVjestina> getOsobnaVjestinaList() {
		return osobnaVjestinaList;
	}

	public Iterable<DodatneInfo> getDodatneInfoList() {
		return dodatneInfoList;
	}

	public Iterable<Dodatak> getDodatakList() {
		return dodatakList;
	}

	public Iterable<RadnoIskustvo> getRadnoIskustvoList() {
		return radnoIskustvoList;
	}

	public Iterable<EdukacijaITrening> getEdukacijaITreningList() {
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

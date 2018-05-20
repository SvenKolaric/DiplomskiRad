package modelDB;


public class Osoba_Drzavljanstvo {
	private final Integer ID;
	private final Integer idDrzavljanstvo;
	private final Integer idOsoba;
	
	private final Drzavljanstvo drzavljanstvo;
	
	public Osoba_Drzavljanstvo(Integer iD, Integer idDrzavljanstvo, Integer idOsoba, Drzavljanstvo drzavljanstvo) {
		ID = iD;
		this.idDrzavljanstvo = idDrzavljanstvo;
		this.idOsoba = idOsoba;
		this.drzavljanstvo = drzavljanstvo;
	}

	public Drzavljanstvo getDrzavljanstvo() {
		return drzavljanstvo;
	}

	public Integer getID() {
		return ID;
	}

	public Integer getIdDrzavljanstvo() {
		return idDrzavljanstvo;
	}

	public Integer getIdOsoba() {
		return idOsoba;
	}
	
}

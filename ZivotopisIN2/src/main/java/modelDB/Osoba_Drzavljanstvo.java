package modelDB;


public class Osoba_Drzavljanstvo {
	private Integer ID;
	private Integer idDrzavljanstvo;
	private Integer idOsoba;
	
	private Drzavljanstvo drzavljanstvo;
	
	public Osoba_Drzavljanstvo() {
	}

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

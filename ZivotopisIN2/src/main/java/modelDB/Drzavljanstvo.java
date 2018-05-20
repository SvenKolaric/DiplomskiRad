package modelDB;


public class Drzavljanstvo {
	private final Integer drzavljanstvoID;
	private final String naziv;
	
	public Drzavljanstvo(Integer drzavljanstvoID, String naziv) {
		this.drzavljanstvoID = drzavljanstvoID;
		this.naziv = naziv;
	}

	public Integer getDrzavljanstvoID() {
		return drzavljanstvoID;
	}

	public String getNaziv() {
		return naziv;
	}
}

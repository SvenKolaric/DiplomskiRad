package modelDB;

public class Drzava {
	private final Integer drzavaID;
	private final String naziv;
	
	public Drzava(Integer drzavaID, String naziv) {
		this.drzavaID = drzavaID;
		this.naziv = naziv;
	}

	public Integer getDrzavaID() {
		return drzavaID;
	}

	public String getNaziv() {
		return naziv;
	}
	
}

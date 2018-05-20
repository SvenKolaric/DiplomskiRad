package modelDB;

public class Jezik {
	private final Integer jezikID;
	private final String naziv;
	
	public Jezik(Integer jezikID, String naziv) {
		this.jezikID = jezikID;
		this.naziv = naziv;
	}

	public Integer getJezikID() {
		return jezikID;
	}

	public String getNaziv() {
		return naziv;
	}
	
}

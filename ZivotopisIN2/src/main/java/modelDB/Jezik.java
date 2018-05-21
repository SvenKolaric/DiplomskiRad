package modelDB;

public class Jezik {
	private Integer jezikID;
	private String naziv;
	
	public Jezik() {
	}

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

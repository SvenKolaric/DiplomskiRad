package modelDB;

public class VozackaDozvola {
	private final Integer vozackaID;
	private final String kategorija;
	
	public VozackaDozvola(Integer vozackaID, String kategorija) {
		this.vozackaID = vozackaID;
		this.kategorija = kategorija;
	}

	public Integer getVozackaID() {
		return vozackaID;
	}

	public String getKategorija() {
		return kategorija;
	}
	
}

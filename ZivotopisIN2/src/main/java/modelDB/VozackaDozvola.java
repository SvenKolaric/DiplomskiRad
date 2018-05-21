package modelDB;

public class VozackaDozvola {
	private Integer vozackaID;
	private String kategorija;
	
	public VozackaDozvola() {
	}

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

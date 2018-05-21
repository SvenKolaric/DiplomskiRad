package modelDB;

public class Drzava {
	private Integer drzavaID;
	private String naziv;

	public Drzava() {
	}

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

package modelDB;

public class VrstaPrijave {
	private final Integer prijavaID;
	private final String naziv;
	
	public VrstaPrijave(Integer prijavaID, String naziv) {
		this.prijavaID = prijavaID;
		this.naziv = naziv;
	}

	public Integer getPrijavaID() {
		return prijavaID;
	}

	public String getNaziv() {
		return naziv;
	}
	
}

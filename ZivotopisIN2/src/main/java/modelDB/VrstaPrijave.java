package modelDB;

public class VrstaPrijave {
	private Integer prijavaID;
	private String naziv;
	
	public VrstaPrijave() {
	}

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

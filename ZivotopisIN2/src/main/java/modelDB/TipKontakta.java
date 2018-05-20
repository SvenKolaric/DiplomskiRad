package modelDB;


public class TipKontakta {
	private final Integer kontaktID;
	private final String naziv;
	
	public TipKontakta(Integer kontaktID, String naziv) {
		this.kontaktID = kontaktID;
		this.naziv = naziv;
	}

	public Integer getKontaktID() {
		return kontaktID;
	}

	public String getNaziv() {
		return naziv;
	}
	
}

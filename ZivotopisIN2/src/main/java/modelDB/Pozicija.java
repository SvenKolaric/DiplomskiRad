package modelDB;

public class Pozicija {
	private final Integer pozicijaID;
	private final String naziv;
	
	public Pozicija(Integer pozicijaID, String naziv) {
		this.pozicijaID = pozicijaID;
		this.naziv = naziv;
	}

	public Integer getPozicijaID() {
		return pozicijaID;
	}

	public String getNaziv() {
		return naziv;
	}
	
}

package modelDB;

public class Kategorija {
	private final Integer kategorijaID;
	private final String naziv;
	public Kategorija(Integer kategorijaID, String naziv) {
		this.kategorijaID = kategorijaID;
		this.naziv = naziv;
	}
	public Integer getKategorijaID() {
		return kategorijaID;
	}
	public String getNaziv() {
		return naziv;
	}
	
}

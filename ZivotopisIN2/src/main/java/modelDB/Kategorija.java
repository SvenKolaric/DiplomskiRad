package modelDB;

public class Kategorija {
	private Integer kategorijaID;
	private String naziv;

	public Kategorija() {
	}

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

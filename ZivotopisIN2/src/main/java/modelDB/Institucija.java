package modelDB;

public class Institucija {
	private final Integer institucijaID;
	private final String adresa;
	private final Integer idMjesto;
	private final String webStranica;
	private final String naziv;
	
	private final Mjesto mjesto;
	
	public Institucija(Integer institucijaID, String adresa, Integer idMjesto, String webStranica, String naziv, Mjesto mjesto) {
		this.institucijaID = institucijaID;
		this.adresa = adresa;
		this.idMjesto = idMjesto;
		this.webStranica = webStranica;
		this.naziv = naziv;
		this.mjesto = mjesto;
	}

	public Mjesto getMjesto() {
		return mjesto;
	}

	public Integer getInstitucijaID() {
		return institucijaID;
	}

	public String getAdresa() {
		return adresa;
	}

	public Integer getIdMjesto() {
		return idMjesto;
	}

	public String getWebStranica() {
		return webStranica;
	}

	public String getNaziv() {
		return naziv;
	}
	
}

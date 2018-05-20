package modelDB;

public class DodatneInfo {
	private final Integer infoID;
	private final Integer idCV;
	private final Integer idKategorije;
	private final String opis;
	
	private final Kategorija kategorija;
	
	public DodatneInfo(Integer infoID, Integer idCV, Integer idKategorije, String opis, Kategorija kategorija) {
		this.infoID = infoID;
		this.idCV = idCV;
		this.idKategorije = idKategorije;
		this.opis = opis;
		this.kategorija = kategorija;
	}
	
	public Kategorija getKategorija() {
		return kategorija;
	}

	public Integer getInfoID() {
		return infoID;
	}
	public Integer getIdCV() {
		return idCV;
	}
	public Integer getIdKategorije() {
		return idKategorije;
	}
	public String getOpis() {
		return opis;
	}
	
}

package modelDB;

public class Zaglavlje {
	private final Integer zaglavljeID;
	private final Integer idCV;
	private final String opis;
	private final Integer idPrijave;
	
	private final VrstaPrijave vrstaPrijave;
	
	public Zaglavlje(Integer zaglavljeID, Integer idCV, String opis, Integer idPrijave, VrstaPrijave vrstaPrijave) {
		this.zaglavljeID = zaglavljeID;
		this.idCV = idCV;
		this.opis = opis;
		this.idPrijave = idPrijave;
		this.vrstaPrijave = vrstaPrijave;
	}

	public VrstaPrijave getVrstaPrijave() {
		return vrstaPrijave;
	}

	public Integer getZaglavljeID() {
		return zaglavljeID;
	}

	public Integer getIdCV() {
		return idCV;
	}

	public String getOpis() {
		return opis;
	}

	public Integer getIdPrijave() {
		return idPrijave;
	}
	
}

package modelDB;

public class Zaglavlje {
	private Integer zaglavljeID;
	private Integer idCV;
	private String opis;
	private Integer idPrijave;
	
	private VrstaPrijave vrstaPrijave;
	
	public Zaglavlje() {
	}

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

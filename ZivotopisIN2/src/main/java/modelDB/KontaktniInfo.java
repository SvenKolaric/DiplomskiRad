package modelDB;


public class KontaktniInfo {
	private final Integer kontaktID;
	private final Integer idTipKontakta;
	private final Integer idOsobe;
	private final String kontakt;
	
	private final TipKontakta TipKontakta;

	public KontaktniInfo(Integer kontaktID, Integer idTipKontakta, Integer idOsobe, String kontakt,
			modelDB.TipKontakta tipKontakta) {
		this.kontaktID = kontaktID;
		this.idTipKontakta = idTipKontakta;
		this.idOsobe = idOsobe;
		this.kontakt = kontakt;
		TipKontakta = tipKontakta;
	}

	public Integer getKontaktID() {
		return kontaktID;
	}

	public Integer getIdTipKontakta() {
		return idTipKontakta;
	}

	public Integer getIdOsobe() {
		return idOsobe;
	}

	public String getKontakt() {
		return kontakt;
	}

	public TipKontakta getTipKontakta() {
		return TipKontakta;
	}
	
}

package modelDB;

import java.util.Date;

public class EdukacijaITrening {
	private final Integer edukacijaID;
	private final Integer idCV;
	private final Date datumPocetka;
	private final Date datumKraja;
	
	private final Institucija institucija;
	
	public EdukacijaITrening(Integer edukacijaID, Integer idCV, Date datumPocetka, Date datumKraja, Institucija institucija) {
		this.edukacijaID = edukacijaID;
		this.idCV = idCV;
		this.datumPocetka = datumPocetka;
		this.datumKraja = datumKraja;
		this.institucija = institucija;
	}

	public Institucija getInstitucija() {
		return institucija;
	}

	public Integer getEdukacijaID() {
		return edukacijaID;
	}

	public Integer getIdCV() {
		return idCV;
	}

	public Date getDatumPocetka() {
		return datumPocetka;
	}

	public Date getDatumKraja() {
		return datumKraja;
	}
	
}

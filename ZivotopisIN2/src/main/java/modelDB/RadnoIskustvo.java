package modelDB;

import java.util.Date;

public class RadnoIskustvo {
	private Integer PosaoID;
	private Integer idCV;
	private Date datumPocetka;
	private Date datumKraja;
	private Integer idPozicija;
	private Integer idInstitucija;
	private String djelatnostSektor;
	private String opisPosla;
	private Integer brGodRada;
	
	private Pozicija pozicija;
	private Institucija institucija;
	
	public RadnoIskustvo() {
	}

	public RadnoIskustvo(Integer posaoID, Integer idCV, Date datumPocetka, Date datumKraja, Integer idPozicija,
			Integer idInstitucija, String djelatnostSektor, String opisPosla, Integer brGodRada, Pozicija pozicija, Institucija institucija) {
		PosaoID = posaoID;
		this.idCV = idCV;
		this.datumPocetka = datumPocetka;
		this.datumKraja = datumKraja;
		this.idPozicija = idPozicija;
		this.idInstitucija = idInstitucija;
		this.djelatnostSektor = djelatnostSektor;
		this.opisPosla = opisPosla;
		this.brGodRada = brGodRada;
		this.pozicija = pozicija;
		this.institucija = institucija;
	}

	public Pozicija getPozicija() {
		return pozicija;
	}

	public Institucija getInstitucija() {
		return institucija;
	}

	public Integer getPosaoID() {
		return PosaoID;
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

	public Integer getIdPozicija() {
		return idPozicija;
	}

	public Integer getIdInstitucija() {
		return idInstitucija;
	}

	public String getDjelatnostSektor() {
		return djelatnostSektor;
	}

	public String getOpisPosla() {
		return opisPosla;
	}

	public Integer getBrGodRada() {
		return brGodRada;
	}
	
}

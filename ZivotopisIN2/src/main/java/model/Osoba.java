package model;

import java.util.Date;
import java.util.UUID;

public class Osoba {
	private final UUID osobaID;
	private final String ime;
	private final String prezime;
	private final Date godRodenja;
	private final Character spol;
	private final String adresa;
	private final UUID idMjesto;
	
	private final Iterable<CV> zivotopisi;
	private final Iterable<KontaktniInfo> kontaktInfo;
	
	public Osoba(UUID osobaID, String ime, String prezime, Date godRodenja, Character spol, String adresa,
			UUID idMjesto, Iterable<CV> zivotopisi, Iterable<KontaktniInfo> kontaktInfo) {
		this.osobaID = osobaID;
		this.ime = ime;
		this.prezime = prezime;
		this.godRodenja = godRodenja;
		this.spol = spol;
		this.adresa = adresa;
		this.idMjesto = idMjesto;
		this.zivotopisi = zivotopisi;
		this.kontaktInfo = kontaktInfo;
	}

	public UUID getOsobaID() {
		return osobaID;
	}

	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public Date getGodRodenja() {
		return godRodenja;
	}

	public Character getSpol() {
		return spol;
	}

	public String getAdresa() {
		return adresa;
	}

	public UUID getIdMjesto() {
		return idMjesto;
	}

	public Iterable<CV> getZivotopisi() {
		return zivotopisi;
	}
	
	public Iterable<KontaktniInfo> getKontaktInfo() {
		return kontaktInfo;
	}
}

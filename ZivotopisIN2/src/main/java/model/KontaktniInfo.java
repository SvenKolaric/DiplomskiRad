package model;

import java.util.UUID;

public class KontaktniInfo {
	private final UUID kontaktID;
	private final UUID idTipKontakta;
	private final UUID idOsobe;
	private final String kontakt;
	
	private final TipKontakta TipKontakta;

	public KontaktniInfo(UUID kontaktID, UUID idTipKontakta, UUID idOsobe, String kontakt,
			model.TipKontakta tipKontakta) {
		this.kontaktID = kontaktID;
		this.idTipKontakta = idTipKontakta;
		this.idOsobe = idOsobe;
		this.kontakt = kontakt;
		TipKontakta = tipKontakta;
	}

	public UUID getKontaktID() {
		return kontaktID;
	}

	public UUID getIdTipKontakta() {
		return idTipKontakta;
	}

	public UUID getIdOsobe() {
		return idOsobe;
	}

	public String getKontakt() {
		return kontakt;
	}

	public TipKontakta getTipKontakta() {
		return TipKontakta;
	}
	
}

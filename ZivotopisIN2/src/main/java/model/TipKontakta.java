package model;

import java.util.UUID;

public class TipKontakta {
	private final UUID kontaktID;
	private final String naziv;
	
	public TipKontakta(UUID kontaktID, String naziv) {
		this.kontaktID = kontaktID;
		this.naziv = naziv;
	}

	public UUID getKontaktID() {
		return kontaktID;
	}

	public String getNaziv() {
		return naziv;
	}
	
}

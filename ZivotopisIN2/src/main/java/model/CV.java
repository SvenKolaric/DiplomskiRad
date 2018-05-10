package model;

import java.sql.Timestamp;
import java.util.UUID;

public class CV {
	private final UUID zivotopisID;
	private final String tipDokumeenta;
	private final Timestamp datumStvaranja;
	private final Timestamp datumAzuriranja;
	private final UUID idOsoba;

	public CV(UUID zivotopisID, String tipDokumeenta, Timestamp datumStvaranja, Timestamp datumAzuriranja,
			UUID idOsoba) {
		this.zivotopisID = zivotopisID;
		this.tipDokumeenta = tipDokumeenta;
		this.datumStvaranja = datumStvaranja;
		this.datumAzuriranja = datumAzuriranja;
		this.idOsoba = idOsoba;
	}

	public UUID getZivotopisID() {
		return zivotopisID;
	}

	public String getTipDokumeenta() {
		return tipDokumeenta;
	}

	public Timestamp getDatumStvaranja() {
		return datumStvaranja;
	}

	public Timestamp getDatumAzuriranja() {
		return datumAzuriranja;
	}

	public UUID getIdOsoba() {
		return idOsoba;
	}
	
	
}

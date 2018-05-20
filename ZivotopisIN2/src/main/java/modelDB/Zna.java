package modelDB;

public class Zna {
	private final Integer ID;
	private final Integer idVjestina;
	private final Integer idJezik;
	private final String razumijevanje;
	private final String govor;
	private final String pisanje;
	
	private final Jezik jezik;
	
	public Zna(Integer iD, Integer idVjestina, Integer idJezik, String razumijevanje, String govor, String pisanje, Jezik jezik) {
		ID = iD;
		this.idVjestina = idVjestina;
		this.idJezik = idJezik;
		this.razumijevanje = razumijevanje;
		this.govor = govor;
		this.pisanje = pisanje;
		this.jezik = jezik;
	}

	public Jezik getJezik() {
		return jezik;
	}

	public Integer getID() {
		return ID;
	}

	public Integer getIdVjestina() {
		return idVjestina;
	}

	public Integer getIdJezik() {
		return idJezik;
	}

	public String getRazumijevanje() {
		return razumijevanje;
	}

	public String getGovor() {
		return govor;
	}

	public String getPisanje() {
		return pisanje;
	}
	
}

package modelDB;

public class VozackaOsobnaVJ {
	private final Integer ID;
	private final Integer idVozacka;
	private final Integer idOsobnaVj;
	
	private final VozackaDozvola vozackaDozvola;
	
	public VozackaOsobnaVJ(Integer iD, Integer idVozacka, Integer idOsobnaVj, VozackaDozvola vozackaDozvola) {
		ID = iD;
		this.idVozacka = idVozacka;
		this.idOsobnaVj = idOsobnaVj;
		this.vozackaDozvola = vozackaDozvola;
	}
	
	public VozackaDozvola getVozackaDozvola() {
		return vozackaDozvola;
	}

	public Integer getID() {
		return ID;
	}
	public Integer getIdVozacka() {
		return idVozacka;
	}
	public Integer getIdOsobnaVj() {
		return idOsobnaVj;
	}
	
}

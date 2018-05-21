package modelDB;

import java.util.ArrayList;

public class Mjesto {
	private Integer mjestoID;
	private Integer idDrzava;
	private Integer PBR;
	private String naziv;

	private ArrayList<Osoba> osobaList;
	private ArrayList<Institucija> institucijaList;
	private Drzava drzava;

	public Mjesto() {
	}

	public Mjesto(Integer mjestoID, Integer idDrzava, Integer pBR, String naziv, ArrayList<Osoba> osobaList,
			ArrayList<Institucija> institucijaList, Drzava drzava) {
		this.mjestoID = mjestoID;
		this.idDrzava = idDrzava;
		PBR = pBR;
		this.naziv = naziv;
		this.osobaList = osobaList;
		this.institucijaList = institucijaList;
		this.drzava = drzava;
	}

	public Drzava getDrzava() {
		return drzava;
	}

	public ArrayList<Institucija> getInstitucijaList() {
		return institucijaList;
	}

	public Integer getMjestoID() {
		return mjestoID;
	}

	public ArrayList<Osoba> getOsobaList() {
		return osobaList;
	}

	public Integer getIdDrzava() {
		return idDrzava;
	}

	public Integer getPBR() {
		return PBR;
	}

	public String getNaziv() {
		return naziv;
	}

}

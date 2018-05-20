package modelDB;

public class Mjesto {
	private final Integer mjestoID;
	private final Integer idDrzava;
	private final Integer PBR;
	private final String naziv;
	
	private final Iterable<Osoba> osobaList;
	private final Iterable<Institucija> institucijaList;
	private final Drzava drzava;
	
	public Mjesto(Integer mjestoID, Integer idDrzava, Integer pBR, String naziv, Iterable<Osoba> osobaList,
			Iterable<Institucija> institucijaList, Drzava drzava) {
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

	public Iterable<Institucija> getInstitucijaList() {
		return institucijaList;
	}

	public Integer getMjestoID() {
		return mjestoID;
	}

	public Iterable<Osoba> getOsobaList() {
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

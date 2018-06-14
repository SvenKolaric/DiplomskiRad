package com.DiplomskiRad_SK.ZivotopisIN2.services;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Korisnik;

public interface KorisnikService {

	public Korisnik findKorisnikByEmail(String email);
	public Boolean saveKorisnik(Korisnik korisnik, String uloga);
}

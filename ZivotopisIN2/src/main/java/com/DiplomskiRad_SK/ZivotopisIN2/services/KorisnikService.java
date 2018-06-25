package com.DiplomskiRad_SK.ZivotopisIN2.services;

import java.util.List;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Korisnik;

public interface KorisnikService {

	public Korisnik findKorisnikByEmail(String email);
	public List<Korisnik> findAll();
	public Boolean saveKorisnik(Korisnik korisnik, String uloga);
	public Boolean deleteKorisnik(Integer id);
}

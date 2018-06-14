package com.DiplomskiRad_SK.ZivotopisIN2.repository;

import org.springframework.data.repository.CrudRepository;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Korisnik;


public interface KorisnikRepository extends CrudRepository<Korisnik, Integer> {
	
	Korisnik findByEmail(String email);
}

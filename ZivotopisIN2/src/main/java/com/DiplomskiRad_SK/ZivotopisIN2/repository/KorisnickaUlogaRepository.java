package com.DiplomskiRad_SK.ZivotopisIN2.repository;

import org.springframework.data.repository.CrudRepository;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.KorisnickaUloga;

public interface KorisnickaUlogaRepository extends CrudRepository<KorisnickaUloga, Integer>{
	KorisnickaUloga findByUloga(String Uloga);
}

package com.DiplomskiRad_SK.ZivotopisIN2.repository;

import org.springframework.data.repository.CrudRepository;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Pozicija;

public interface PozicijaRepository extends CrudRepository<Pozicija, Integer>{
	public Pozicija findByNaziv(String naziv);

}

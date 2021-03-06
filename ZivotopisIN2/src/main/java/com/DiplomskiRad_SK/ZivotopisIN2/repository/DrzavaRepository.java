package com.DiplomskiRad_SK.ZivotopisIN2.repository;

import org.springframework.data.repository.CrudRepository;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Drzava;

public interface DrzavaRepository extends CrudRepository<Drzava, Integer>{
	public Drzava findByNaziv(String naziv);

}

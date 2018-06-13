package com.DiplomskiRad_SK.ZivotopisIN2.repository;

import org.springframework.data.repository.CrudRepository;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Jezik;

public interface JezikRepository extends CrudRepository<Jezik, Integer>{
	public Jezik findByNaziv(String naziv);
}

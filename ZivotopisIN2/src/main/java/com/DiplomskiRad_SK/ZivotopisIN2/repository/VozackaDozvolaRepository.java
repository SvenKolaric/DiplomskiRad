package com.DiplomskiRad_SK.ZivotopisIN2.repository;

import org.springframework.data.repository.CrudRepository;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.VozackaDozvola;

public interface VozackaDozvolaRepository extends CrudRepository<VozackaDozvola, Integer>{
	public VozackaDozvola findByKategorija(String kategorija);

}

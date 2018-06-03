package com.DiplomskiRad_SK.ZivotopisIN2.repository;

import org.springframework.data.repository.CrudRepository;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Zaglavlje;

public interface ZaglavljeRepository extends CrudRepository<Zaglavlje, Integer>{
	
	Zaglavlje findByIdCV(Integer idCV);
}

package com.DiplomskiRad_SK.ZivotopisIN2.repository;


import org.springframework.data.repository.CrudRepository;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Dodatak;

public interface DodatakRepository extends CrudRepository<Dodatak, Integer>{
	//List<Dodatak> findByZivotopis(int IDCV);
}

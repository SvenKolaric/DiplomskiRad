package com.DiplomskiRad_SK.ZivotopisIN2.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.RadnoIskustvo;;

public interface RadnoIskustvoRepository extends CrudRepository<RadnoIskustvo, Integer>{

	List<RadnoIskustvo> findByIdCV(Integer idCV);
	
	List<RadnoIskustvo> findByIdInstitucija(Integer idInstitucija);

}

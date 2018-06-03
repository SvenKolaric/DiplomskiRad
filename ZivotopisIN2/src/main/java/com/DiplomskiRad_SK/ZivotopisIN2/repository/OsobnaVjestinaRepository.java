package com.DiplomskiRad_SK.ZivotopisIN2.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.OsobnaVjestina;;

public interface OsobnaVjestinaRepository extends CrudRepository<OsobnaVjestina, Integer>{
	
	List<OsobnaVjestina> findByIdCV(Integer idCV);
}

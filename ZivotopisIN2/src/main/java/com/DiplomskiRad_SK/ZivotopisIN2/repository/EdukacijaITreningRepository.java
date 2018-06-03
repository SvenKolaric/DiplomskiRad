package com.DiplomskiRad_SK.ZivotopisIN2.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.EdukacijaITrening;;

public interface EdukacijaITreningRepository extends CrudRepository<EdukacijaITrening, Integer>{

	List<EdukacijaITrening> findByIdCV(Integer idCV);
	
	List<EdukacijaITrening> findByIdInstitucija(Integer idInstitucija);
}

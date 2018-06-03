package com.DiplomskiRad_SK.ZivotopisIN2.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.VozackaOsobnaVJ;;

public interface VozackaOsobnaVJRepository extends CrudRepository<VozackaOsobnaVJ, Integer>{
	
	List<VozackaOsobnaVJ> findByIdOsobnaVj(Integer idOsobnaVj);

}

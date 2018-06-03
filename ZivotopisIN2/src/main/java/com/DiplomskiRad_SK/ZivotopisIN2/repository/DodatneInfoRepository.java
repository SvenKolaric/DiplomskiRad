package com.DiplomskiRad_SK.ZivotopisIN2.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.DodatneInfo;;

public interface DodatneInfoRepository extends CrudRepository<DodatneInfo, Integer>{
	
	List<DodatneInfo> findByIdCV(Integer idCV);
}

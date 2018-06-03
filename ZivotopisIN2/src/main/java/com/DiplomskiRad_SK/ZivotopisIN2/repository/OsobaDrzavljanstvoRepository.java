package com.DiplomskiRad_SK.ZivotopisIN2.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.OsobaDrzavljanstvo;

public interface OsobaDrzavljanstvoRepository extends CrudRepository<OsobaDrzavljanstvo, Integer>{

	List<OsobaDrzavljanstvo> findByIdOsoba(Integer idOsoba);
}

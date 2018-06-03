package com.DiplomskiRad_SK.ZivotopisIN2.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Zna;

public interface ZnaRepository extends CrudRepository<Zna, Integer>{

	List<Zna> findByIdVjestina(Integer idVjestina);
}

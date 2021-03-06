package com.DiplomskiRad_SK.ZivotopisIN2.repository;



import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Mjesto;

public interface MjestoRepository extends CrudRepository<Mjesto, Integer>{
	public Mjesto findByPBR(Integer PBR);
	public List<Mjesto> findByNaziv(String naziv);

}

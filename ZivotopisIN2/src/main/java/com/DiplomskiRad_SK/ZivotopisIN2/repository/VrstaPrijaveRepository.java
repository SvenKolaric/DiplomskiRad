package com.DiplomskiRad_SK.ZivotopisIN2.repository;

import org.springframework.data.repository.CrudRepository;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.VrstaPrijave;

public interface VrstaPrijaveRepository extends CrudRepository<VrstaPrijave, Integer>{
	public VrstaPrijave findByNaziv(String naziv);

}

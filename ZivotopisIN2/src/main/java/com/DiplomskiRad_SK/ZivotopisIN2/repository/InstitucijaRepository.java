package com.DiplomskiRad_SK.ZivotopisIN2.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Institucija;

public interface InstitucijaRepository extends CrudRepository<Institucija, Integer>{
	public Institucija findByNaziv(String naziv);
	
	public List<Institucija> findAllByNaziv(String naziv);

}

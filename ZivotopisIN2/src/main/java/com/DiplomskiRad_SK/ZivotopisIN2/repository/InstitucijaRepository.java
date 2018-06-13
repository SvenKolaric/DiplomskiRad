package com.DiplomskiRad_SK.ZivotopisIN2.repository;

import org.springframework.data.repository.CrudRepository;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Institucija;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.TipKontakta;;

public interface InstitucijaRepository extends CrudRepository<Institucija, Integer>{
	public Institucija findByNaziv(String naziv);

}

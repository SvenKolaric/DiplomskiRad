package com.DiplomskiRad_SK.ZivotopisIN2.repository;

import org.springframework.data.repository.CrudRepository;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Drzavljanstvo;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.TipKontakta;;

public interface DrzavljanstvoRepository extends CrudRepository<Drzavljanstvo, Integer>{
	public Drzavljanstvo findByNaziv(String naziv);

}

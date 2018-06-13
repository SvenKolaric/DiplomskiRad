package com.DiplomskiRad_SK.ZivotopisIN2.repository;

import org.springframework.data.repository.CrudRepository;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.TipKontakta;

public interface TipKontaktaRepository extends CrudRepository<TipKontakta, Integer>{
	public TipKontakta findByNaziv(String naziv);

}

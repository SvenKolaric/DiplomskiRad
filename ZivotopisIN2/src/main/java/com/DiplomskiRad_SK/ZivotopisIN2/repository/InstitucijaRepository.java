package com.DiplomskiRad_SK.ZivotopisIN2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Institucija;

public interface InstitucijaRepository extends CrudRepository<Institucija, Integer>{
	public Institucija findByNaziv(String naziv);
	
	public List<Institucija> findAllByNaziv(String naziv);

	@Query("SELECT U FROM Institucija U WHERE LOWER(U.naziv) LIKE LOWER(concat('%', ?1, '%'))")
	List<Institucija> findAllByNazivQuery(String naziv);
}

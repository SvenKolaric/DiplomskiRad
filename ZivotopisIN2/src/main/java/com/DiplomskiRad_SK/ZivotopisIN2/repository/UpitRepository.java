package com.DiplomskiRad_SK.ZivotopisIN2.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Upit;

public interface UpitRepository extends CrudRepository<Upit, Integer>{

	@Query("SELECT u FROM Upit u WHERE matches(u.upit, :text) > 0")
	ArrayList<Upit> findUpitsInText(@Param("text") String text);
	
	@Procedure
	void RECREATE_IDX_ON_UPIT();
	
}

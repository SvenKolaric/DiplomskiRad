package com.DiplomskiRad_SK.ZivotopisIN2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.EdukacijaITrening;;

public interface EdukacijaITreningRepository extends CrudRepository<EdukacijaITrening, Integer>{

	//@Query(select IDCV, sum(BR_GOD_EDUKACIJE) from edukacija_i_trening group by idcv having sum(BR_GOD_EDUKACIJE)>10;)
	@Procedure
	void CALCULATE_DATE_DIFF_EDU();
}

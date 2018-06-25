package com.DiplomskiRad_SK.ZivotopisIN2.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.EdukacijaITrening;;

public interface EdukacijaITreningRepository extends CrudRepository<EdukacijaITrening, Integer>{

	//@Query(select IDCV, sum(BR_GOD_EDUKACIJE) from edukacija_i_trening group by idcv having sum(BR_GOD_EDUKACIJE)>10;)
	@Query(value = "select IDCV, sum(BR_GOD_EDUKACIJE) from edukacija_i_trening group by idcv having sum(BR_GOD_EDUKACIJE) > :god", nativeQuery = true)
	ArrayList<Object[]> findByGodEdu(@Param("god") Integer godina);
	@Procedure
	void CALCULATE_DATE_DIFF_EDU();
}

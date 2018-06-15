package com.DiplomskiRad_SK.ZivotopisIN2.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.RadnoIskustvo;;

public interface RadnoIskustvoRepository extends CrudRepository<RadnoIskustvo, Integer>{

	/*@Query("select ri.*, sum(BR_GOD_RADA) from radno_iskustvo ri group by ri.idcv having sum(BR_GOD_RADA) > :god;")
	ArrayList<RadnoIskustvo> findByGodRada(@Param("god") Integer godina);*/
	
	@Procedure
	void CALCULATE_DATE_DIFF_WORK();
}

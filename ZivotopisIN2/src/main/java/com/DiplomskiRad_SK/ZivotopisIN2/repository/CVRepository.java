package com.DiplomskiRad_SK.ZivotopisIN2.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.CV;

public interface CVRepository extends CrudRepository<CV, Integer> {

	List<CV> findByOrderByDatumStvaranja();
}

package com.DiplomskiRad_SK.ZivotopisIN2.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.CertifikatDiploma;;

public interface CertifikatiDiplomaRepository extends CrudRepository<CertifikatDiploma, Integer> {

	List<CertifikatDiploma> findByIdVjestina(Integer idVjestina);
}

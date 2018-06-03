package com.DiplomskiRad_SK.ZivotopisIN2.bl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.CV;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.EdukacijaITrening;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Osoba;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.CVRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.OsobaRepository;
import com.google.common.collect.Lists;

@Service("BLCV")
public class BLCV {
	@Autowired
    CVRepository cvRepository;
	@Autowired 
	OsobaRepository osobaRepository;
	
	/*@Autowired
	public BLCV(@Qualifier("CV") DaoCVInterface daoCVInterface) {
		this.daoCV = daoCVInterface;
	}*/
	
	@Transactional
	public void SaveCV(CV cv) {
		cvRepository.save(cv);
		/*CV cv1 = new CV();
		Iterable<EdukacijaITrening> a = cv1.getEdukacijaITreningList();
		ArrayList<CV> b = new ArrayList<CV>();
		EdukacijaITrening[] c = (EdukacijaITrening[]) ((Collection<CV>) a).toArray(new EdukacijaITrening[a.size()])*/
	}
	
	@Transactional
	public List<Osoba> getAllCV() {
		return Lists.newArrayList(osobaRepository.findAll());

	}

	@Transactional
	public Optional<CV> getCVByID(Integer id) {
		return cvRepository.findById(id);

	}
	
	@Transactional
	public List<CV> getCVByOsobaID(Integer idOsoba){
		return cvRepository.findByIdOsoba(idOsoba);
	}
	
	@Transactional
	public void deleteCVByID(Integer id) {
		cvRepository.deleteById(id);
	}

}

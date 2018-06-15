package com.DiplomskiRad_SK.ZivotopisIN2.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.CV;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Upit;
import com.DiplomskiRad_SK.ZivotopisIN2.models.Search;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.UpitRepository;

@Service("SearchService")
public class SearchService {

	@Autowired
	UpitRepository upitRepository;

	public ArrayList<CV> QueryCVs(List<Search> queries) {
		Set<CV> cvSet = new HashSet<>();
		
		for (Search query : queries) {
			switch(query.getIdentifier()) {
				case "BRGOD_RADA":
				case "BRGOD_EDU":
				case "MJESTO":
				case "JEZIK":
				case "UPIT":
				
			
			}
			
		}
		return null;
	}
}

package com.DiplomskiRad_SK.ZivotopisIN2.models;

import java.util.ArrayList;
import java.util.List;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.CV;

public class ResultsCV {
	private List<CV> results = new ArrayList<>();
	private String natjecaj;
	
	public ResultsCV(List<CV> results) {
		this.results = results;
	}

	public ResultsCV() {
	}

	public List<CV> getResults() {
		return results;
	}

	public void setResults(List<CV> results) {
		this.results = results;
	}

	public String getNatjecaj() {
		return natjecaj;
	}

	public void setNatjecaj(String natjecaj) {
		this.natjecaj = natjecaj;
	}
	
	
}

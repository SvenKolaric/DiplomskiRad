package com.DiplomskiRad_SK.ZivotopisIN2.models;

import java.util.ArrayList;
import java.util.List;

public class SearchWrapper {

	private String nazivNatjecaja;
	private List<Search> searchList = new ArrayList<>();


	public SearchWrapper(String nazivNatjecaja, List<Search> searchList) {
		this.nazivNatjecaja = nazivNatjecaja;
		this.searchList = searchList;
	}

	public SearchWrapper() {
	}
	
	public void addSearch(Search s) {
		this.searchList.add(s);
	}

	public List<Search> getSearchList() {
		return searchList;
	}

	public void setSearchList(List<Search> searchList) {
		this.searchList = searchList;
	}

	public String getNazivNatjecaja() {
		return nazivNatjecaja;
	}

	public void setNazivNatjecaja(String nazivNatjecaja) {
		this.nazivNatjecaja = nazivNatjecaja;
	}
	
}

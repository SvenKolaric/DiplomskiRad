package com.DiplomskiRad_SK.ZivotopisIN2.models;

public class Search {
	private String identifier;
	private String query;
	private Integer queryWeight;
	private Integer queryValue;
	
	public Search() {
	}
	
	public Search(String identifier, String query, Integer queryWeight, Integer queryValue) {
		this.identifier = identifier;
		this.query = query;
		this.queryWeight = queryWeight;
		this.queryValue = queryValue;
	}
	
	public Search(String identifier) {
		this.identifier = identifier;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public Integer getQueryWeight() {
		return queryWeight;
	}
	public void setQueryWeight(Integer queryWeight) {
		this.queryWeight = queryWeight;
	}
	public Integer getQueryValue() {
		return queryValue;
	}
	public void setQueryValue(Integer queryVaule) {
		this.queryValue = queryVaule;
	}
	
}

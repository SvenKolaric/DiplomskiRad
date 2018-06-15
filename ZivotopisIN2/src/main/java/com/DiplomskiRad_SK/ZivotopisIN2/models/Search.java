package com.DiplomskiRad_SK.ZivotopisIN2.models;

public class Search {
	private String identifier;
	private String query;
	private Integer queryWeight;
	private Integer queryVaule;
	
	public Search() {
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
	public Integer getQueryVaule() {
		return queryVaule;
	}
	public void setQueryVaule(Integer queryVaule) {
		this.queryVaule = queryVaule;
	}
	
}

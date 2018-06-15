package com.DiplomskiRad_SK.ZivotopisIN2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.DiplomskiRad_SK.ZivotopisIN2.models.Search;

import com.DiplomskiRad_SK.ZivotopisIN2.services.SearchService;
import com.DiplomskiRad_SK.ZivotopisIN2.services.ZivotopisDBService;


public class SearchController {

	private SearchService searchService;
	private ZivotopisDBService cvService;
	
	@Autowired
	public SearchController(@Qualifier("BLCV") ZivotopisDBService zivotopisDBService, @Qualifier("SearchService") SearchService searchService) {
		this.searchService = searchService;
		this.cvService = zivotopisDBService;
	}
	
	@RequestMapping(value={"/zivotopis/all"}, method = RequestMethod.GET) //Prikazi sve cvove u simple obliku
	public ModelAndView ListAllCVs(){
		ModelAndView modelAndView = new ModelAndView();
		//
		modelAndView.setViewName("zivotopis");
		return modelAndView;
	}
	
	@RequestMapping(value={"/zivotopis/search"}, method = RequestMethod.GET) //Postavi formu za upis querya
	public ModelAndView Search(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("search");
		return modelAndView;
	}
	
	@RequestMapping(value = "/zivotopis/search", method = RequestMethod.POST)
	public String SearchGivenQueries(@RequestParam("queries") List<Search> queries) {
		
		return "redirect:/zivotopis/results";
	}

}

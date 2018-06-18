package com.DiplomskiRad_SK.ZivotopisIN2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.CV;
import com.DiplomskiRad_SK.ZivotopisIN2.models.Search;
import com.DiplomskiRad_SK.ZivotopisIN2.models.SearchWrapper;
import com.DiplomskiRad_SK.ZivotopisIN2.services.SearchService;
import com.DiplomskiRad_SK.ZivotopisIN2.services.ZivotopisDBService;

@Controller
@RequestMapping("/cv")
public class SearchController {

	private SearchService searchService;
	private ZivotopisDBService cvService;

	@Autowired
	public SearchController(@Qualifier("BLCV") ZivotopisDBService zivotopisDBService,
			@Qualifier("SearchService") SearchService searchService) {
		this.searchService = searchService;
		this.cvService = zivotopisDBService;
	}

	@RequestMapping(value = { "all" }, method = RequestMethod.GET) // Prikazi sve cvove u simple obliku možda samo
																		// admin da to može
	public ModelAndView ListAllCVs() {
		ModelAndView modelAndView = new ModelAndView();
		//
		modelAndView.setViewName("cv");
		return modelAndView;
	}

	@RequestMapping(value = "search", method = RequestMethod.GET) // izgleda da ni tu ne treba j... viticaste
	public ModelAndView Search() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("cv/search");
		SearchWrapper sWrapper = new SearchWrapper();
		String[] hiddenIdentifiers = { "BRGOD_RADA", "BRGOD_EDU", "MJESTO", "INSTITUCIJA", "UPIT" };

		for (int i = 0; i < hiddenIdentifiers.length; i++) {
			sWrapper.addSearch(new Search(hiddenIdentifiers[i]));
		}
		modelAndView.addObject("form", sWrapper);
		return modelAndView;
	}
	
	//@RequestMapping(value = "/cv/search", method = RequestMethod.GET) // Postavi formu za upis querya
	/*  public ModelAndView Search() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("cv/search");
		SearchWrapper sWrapper = new SearchWrapper();
		String[] hiddenIdentifiers = { "BRGOD_RADA", "BRGOD_EDU", "MJESTO", "INSTITUCIJA", "UPIT" };

		for (int i = 0; i < hiddenIdentifiers.length; i++) {
			
			sWrapper.addSearch(new Search(hiddenIdentifiers[i]));
		}
		modelAndView.addObject("form", sWrapper);
		return modelAndView;
	}*/

	@RequestMapping(value = "searchQueries", method = RequestMethod.POST) //mislim da viticaste zagrade ne trebaju (ali radi za search iz drugog kontrolera kada se poziva)
	//@PostMapping("searchQueries")
	public ModelAndView SearchGivenQueries(@ModelAttribute SearchWrapper form) {

		ModelAndView modelAndView = new ModelAndView();
		List<Search> queries = searchService.prepareQueries(form);
		if (queries == null) {
			//javi grešku i vrati natrag na search
		}
		List<CV> results = searchService.QueryCVs(queries);
		//modelAndView.setViewName("cv/results");
		//modelAndView.addObject(results);
		modelAndView.setViewName("result");
		modelAndView.addObject("results", results);
		modelAndView.addObject("natjecaj", form.getNazivNatjecaja());
		return modelAndView; //"redirect:/cv/results";
	}

}

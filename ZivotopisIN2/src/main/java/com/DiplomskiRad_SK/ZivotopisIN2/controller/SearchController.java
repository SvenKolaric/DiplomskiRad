package com.DiplomskiRad_SK.ZivotopisIN2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.CV;
import com.DiplomskiRad_SK.ZivotopisIN2.models.ResultsCV;
import com.DiplomskiRad_SK.ZivotopisIN2.models.Search;
import com.DiplomskiRad_SK.ZivotopisIN2.models.SearchWrapper;
import com.DiplomskiRad_SK.ZivotopisIN2.services.SearchService;
import com.DiplomskiRad_SK.ZivotopisIN2.services.ZivotopisDBService;
import com.lowagie.text.DocumentException;

@Controller
@RequestMapping("/cv")
@SessionAttributes("resultsCV")
public class SearchController {


    
	private SearchService searchService;
	private ZivotopisDBService cvService;

	private static final int[] PAGE_SIZES = { 5, 10, 20};
	
	@ModelAttribute("resultsCV")
	   public ResultsCV setUpResultCV() {
	      return new ResultsCV();
	   }
	
	@ModelAttribute("IDCV")
	   public Integer getID() {
	      return 0;
	   }
	
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

	@RequestMapping(value = "search", method = RequestMethod.GET) // izgleda da ni tu ne treba viticaste
	public ModelAndView Search() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("cv/search");
		List<Integer> weight = new ArrayList<>();
		List<Integer> value = new ArrayList<>();
		SearchWrapper sWrapper = new SearchWrapper();
		String[] hiddenIdentifiers = { "BRGOD_RADA", "BRGOD_EDU", "MJESTO", "INSTITUCIJA", "UPIT" };

		weight.add(1);
		weight.add(2);
		weight.add(3);
		
		for (int i = 1; i < 11; i++) {
			value.add(i);
		}
		for (int i = 0; i < hiddenIdentifiers.length; i++) {
			sWrapper.addSearch(new Search(hiddenIdentifiers[i]));
		}
		modelAndView.addObject("form", sWrapper);
		modelAndView.addObject("weight", weight);
		modelAndView.addObject("value", value);
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
	public ModelAndView SearchGivenQueries(@ModelAttribute SearchWrapper form, @ModelAttribute("resultsCV") ResultsCV results) throws Exception {

		ModelAndView modelAndView = new ModelAndView();
		List<Search> queries = searchService.prepareQueries(form);
		if (queries == null) {
			//javi grešku i vrati natrag na search
		}
		results.setResults(searchService.QueryCVs(queries));
		results.setNatjecaj(form.getNazivNatjecaja());
		//modelAndView.setViewName("cv/results");
		//modelAndView.addObject(results);
		modelAndView.setViewName("cv/result");
		modelAndView.addObject("results", results);
		modelAndView.addObject("pageSizes", PAGE_SIZES);
		//modelAndView.addObject("natjecaj", form.getNazivNatjecaja());
				
		return modelAndView; //"redirect:/cv/results";
	}
	
	@RequestMapping(value = "searchQueries", method = RequestMethod.GET)
	public ModelAndView DisplayResults(@ModelAttribute("resultsCV") ResultsCV results) throws FileNotFoundException, DocumentException {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("cv/result");
		modelAndView.addObject("results", results);
		//modelAndView.addObject("natjecaj", natjecaj);

		modelAndView.addObject("pageSizes", PAGE_SIZES);
		//gen.generate(new File("D:/testNovi.pdf"), "cv/resultReport", model);
		return modelAndView;
	}
	
	@RequestMapping(value = "detailedResults", method = RequestMethod.GET)
	public ModelAndView DisplayDetailedResults(@ModelAttribute("resultsCV") ResultsCV results) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("cv/detailedResults");
		modelAndView.addObject("pageSizes", PAGE_SIZES);

		modelAndView.addObject("results", results);
		//modelAndView.addObject("natjecaj", natjecaj);

		return modelAndView;
	}
	
	@RequestMapping(value="details", method = RequestMethod.POST)
    public ModelAndView showCVDetails(@RequestParam Integer zivotopisID) {
        CV cv = cvService.getCVByID(zivotopisID);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("cv/details");
		modelAndView.addObject("zivotopis", cv);
        return modelAndView;
    }

	@RequestMapping(value = "resultReport", method = RequestMethod.GET)
	public ModelAndView DisplayResultReport(@ModelAttribute("resultsCV") ResultsCV results, @RequestParam("pageSize") Optional<Integer> pageSize) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("cv/resultReport");
		modelAndView.addObject("results", results);
        

		//modelAndView.addObject("natjecaj", natjecaj);

		return modelAndView;
	}
	
	@RequestMapping(value = "detailedResultReport", method = RequestMethod.GET)
	public ModelAndView DisplayDetailedResultReport(@ModelAttribute("resultsCV") ResultsCV results, @RequestParam("pageSize") Optional<Integer> pageSize) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("cv/detailedResultReport");
		modelAndView.addObject("results", results);
        

		//modelAndView.addObject("natjecaj", natjecaj);

		return modelAndView;
	}

	@RequestMapping(value = "detailsReport", method = RequestMethod.POST)
	public ModelAndView DisplayDetailedReport(@RequestParam Integer zivotopisID) {
		CV cv = cvService.getCVByID(zivotopisID);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("cv/detailsReport");
		modelAndView.addObject("zivotopis", cv);
        

		//modelAndView.addObject("natjecaj", natjecaj);

		return modelAndView;
	}
}

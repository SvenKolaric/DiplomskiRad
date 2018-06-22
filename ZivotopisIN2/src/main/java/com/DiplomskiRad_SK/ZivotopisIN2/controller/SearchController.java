package com.DiplomskiRad_SK.ZivotopisIN2.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.DiplomskiRad_SK.ZivotopisIN2.helpers.PDFGenerator;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.CV;
import com.DiplomskiRad_SK.ZivotopisIN2.models.ResultsCV;
import com.DiplomskiRad_SK.ZivotopisIN2.models.Search;
import com.DiplomskiRad_SK.ZivotopisIN2.models.SearchWrapper;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.CVRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.services.SearchService;
import com.DiplomskiRad_SK.ZivotopisIN2.services.ZivotopisDBService;
import com.lowagie.text.DocumentException;

@Controller
@RequestMapping("/cv")
@SessionAttributes("resultsCV")
public class SearchController {


    
	private SearchService searchService;
	private ZivotopisDBService cvService;
	private List<CV> results1;
	private String natjecaj;
	
	@ModelAttribute("resultsCV")
	   public ResultsCV setUpResultCV() {
	      return new ResultsCV();
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

	@RequestMapping(value = "search", method = RequestMethod.GET) // izgleda da ni tu ne treba j... viticaste
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
		//modelAndView.addObject("natjecaj", form.getNazivNatjecaja());
				
		return modelAndView; //"redirect:/cv/results";
	}
	
	@RequestMapping(value = "searchQueries", method = RequestMethod.GET)
	public ModelAndView DisplayResults(@ModelAttribute("resultsCV") ResultsCV results) throws FileNotFoundException, DocumentException {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("cv/result");
		modelAndView.addObject("results", results);
		//modelAndView.addObject("natjecaj", natjecaj);

		PDFGenerator gen = new PDFGenerator("templates/", ".html");

		Map<String, Object> model = new HashMap<>();
		model.put("results", results);

		gen.generate(new File("D:/testNovi.pdf"), "cv/resultReport", model);
		return modelAndView;
	}
	
	@RequestMapping(value = "detailedResults", method = RequestMethod.GET)
	public ModelAndView DisplayDetailedResults(@ModelAttribute("resultsCV") ResultsCV results) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("cv/detailedResults");
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

	public void pdfGenerateGithubRainu() throws FileNotFoundException, DocumentException {
		
	}

}

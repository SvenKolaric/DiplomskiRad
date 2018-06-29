package com.DiplomskiRad_SK.ZivotopisIN2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.CV;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Korisnik;
import com.DiplomskiRad_SK.ZivotopisIN2.models.PagerModel;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.CVRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.services.KorisnikService;
import com.DiplomskiRad_SK.ZivotopisIN2.services.ZivotopisDBService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private static final int BUTTONS_TO_SHOW = 3;
	private static final int INITIAL_PAGE = 0;
	private static final int INITIAL_PAGE_SIZE = 5;
	private static final int[] PAGE_SIZES = { 5, 10, 20};
	
	private List<CV> results;
	private ZivotopisDBService cvService;

	@Autowired
	private KorisnikService korisnikService;
	
	@Autowired
	CVRepository cvRepo;
	
	@Autowired
	public AdminController(@Qualifier("BLCV") ZivotopisDBService zivotopisDBService) {
		this.cvService = zivotopisDBService;
	}
	
	@RequestMapping(value="home", method = RequestMethod.GET)
	public ModelAndView home(@RequestParam("pageSize") Optional<Integer> pageSize,
            @RequestParam("page") Optional<Integer> page){
		
		ModelAndView modelAndView = new ModelAndView();
		//
        // Evaluate page size. If requested parameter is null, return initial
        // page size
        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        // Evaluate page. If requested parameter is null or less than 0 (to
        // prevent exception), return initial size. Otherwise, return value of
        // param. decreased by 1.
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
        // print repo
        results = cvService.getCVOrderByDatumAsc();
        /*for (int i = 0; i < 5; i++) {
        	CV cv = new CV(i, "test" + i,new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
        	cv.setOsoba(new Osoba(1,"testko","testic", null, null, null, null));
        	results.add(cv);
        }*/
        
        System.out.println("here is client repo " + results);
        Page<CV> resultss = new PageImpl<>(results, PageRequest.of(evalPage, evalPageSize), results.size());
        //Page<CV> clientlist = cvRepo.findByOrderByDatumStvaranja(PageRequest.of(evalPage, evalPageSize)); //cvService.getCVOrderByDatumAsc(PageRequest.of(evalPage, evalPageSize));
        System.out.println("client list get total pages" + resultss.getTotalPages() + "client list get number " + resultss.getNumber());
        PagerModel pager = new PagerModel(resultss.getTotalPages(),resultss.getNumber(),BUTTONS_TO_SHOW);
        // add clientmodel
        //modelAndView.addObject("clientlist",clientlist);
        // evaluate page size
        modelAndView.addObject("selectedPageSize", evalPageSize);
        // add page sizes
        modelAndView.addObject("pageSizes", PAGE_SIZES);
        // add pager
        modelAndView.addObject("pager", pager);
		//results = cvService.getCVOrderByDatumAsc();
        // add model
        
        List<CV> results1 = new ArrayList<>();
        for(int i = 0; i< results.size() - 1; i++) {
        	results1.add(results.get(i));
        }
		modelAndView.addObject("results",results1);
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}
	
	@RequestMapping(value="delete", method = RequestMethod.POST)
    public ModelAndView deleteCV(@RequestParam Integer zivotopisID) {
        cvService.deleteCVByID(zivotopisID);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/admin/home");
		modelAndView.addObject("results", results);
        return modelAndView;
    }
	
	@RequestMapping(value="{registration}", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		Korisnik korisnik = new Korisnik();
		modelAndView.addObject("korisnik", korisnik);
		modelAndView.setViewName("admin/registration");
		return modelAndView;
	}
	
	@RequestMapping(value = "registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid Korisnik korisnik, BindingResult bindingResult) {
		
		ModelAndView modelAndView = new ModelAndView();
		Korisnik korisnikExists = korisnikService.findKorisnikByEmail(korisnik.getEmail());
		
		if (korisnikExists != null) {
			bindingResult
					.rejectValue("email", "error.korisnik",
							"Već postoji korisnik s danim emailom!");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("admin/registration");
			
		} else {
			if (korisnik.getIsAdmin()) {
				korisnikService.saveKorisnik(korisnik, "ADMIN");
			} else {
				korisnikService.saveKorisnik(korisnik, "KORISNIK");
			}
			modelAndView.addObject("successMessage", "Korisnik je uspješno pohranjen u bazu!");
			modelAndView.addObject("korisnik", new Korisnik());
			modelAndView.setViewName("admin/registration");
			
		}
		return modelAndView;
	}
	
	@RequestMapping(value="korisnik", method = RequestMethod.GET)
	public ModelAndView korisnik(){
		ModelAndView modelAndView = new ModelAndView();
		List<Korisnik> korisnici = korisnikService.findAll();
		modelAndView.addObject("results",korisnici);
		modelAndView.setViewName("admin/korisnik");
		return modelAndView;
	}
	
	@RequestMapping(value="deleteKorisnik", method = RequestMethod.POST)
    public ModelAndView deleteKorisnik(@RequestParam Integer korisnikID) {
        korisnikService.deleteKorisnik(korisnikID);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/admin/korisnik");
		modelAndView.addObject("results", results);
        return modelAndView;
    }
}

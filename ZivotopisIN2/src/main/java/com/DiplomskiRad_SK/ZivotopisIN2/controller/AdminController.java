package com.DiplomskiRad_SK.ZivotopisIN2.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.CV;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Korisnik;
import com.DiplomskiRad_SK.ZivotopisIN2.services.KorisnikService;
import com.DiplomskiRad_SK.ZivotopisIN2.services.ZivotopisDBService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private List<CV> results;
	private ZivotopisDBService cvService;

	@Autowired
	private KorisnikService korisnikService;
	
	@Autowired
	public AdminController(@Qualifier("BLCV") ZivotopisDBService zivotopisDBService) {
		this.cvService = zivotopisDBService;
	}
	
	@RequestMapping(value="home", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		results = cvService.getCVOrderByDatumAsc();
		modelAndView.addObject("results",results);
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

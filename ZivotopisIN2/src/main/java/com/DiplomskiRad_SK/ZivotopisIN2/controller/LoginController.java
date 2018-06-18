package com.DiplomskiRad_SK.ZivotopisIN2.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Korisnik;
import com.DiplomskiRad_SK.ZivotopisIN2.models.Search;
import com.DiplomskiRad_SK.ZivotopisIN2.models.SearchWrapper;
import com.DiplomskiRad_SK.ZivotopisIN2.services.KorisnikService;

@Controller
public class LoginController {

	@Autowired
	private KorisnikService korisnikService;

	@RequestMapping(value={"/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	 @RequestMapping("/loginSuccess")
	    public ModelAndView loginPageRedirect(HttpServletRequest request, HttpServletResponse response, Authentication authResult) throws IOException, ServletException {

	        String role =  authResult.getAuthorities().toString();

	        if(role.contains("ADMIN")){
	        	 return new ModelAndView("redirect:/admin/home"); //redirect je za ovaj controller za drugi moraš kao za korisnika
	         //response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/admin/home"));                            
	         }
	         else if(role.contains("KORISNIK")) {
	        	 return new ModelAndView("redirect:/cv/search");
	         }
	        return new ModelAndView("redirect:/");
	    }


	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		Korisnik korisnik = new Korisnik();
		modelAndView.addObject("korisnik", korisnik);
		modelAndView.setViewName("registration");
		return modelAndView;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid Korisnik korisnik, BindingResult bindingResult) {
		
		ModelAndView modelAndView = new ModelAndView();
		Korisnik korisnikExists = korisnikService.findKorisnikByEmail(korisnik.getEmail());
		
		if (korisnikExists != null) {
			bindingResult
					.rejectValue("email", "error.korisnik",
							"Već postoji korisnik s danim emailom!");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
			
		} else {
			korisnikService.saveKorisnik(korisnik, "KORISNIK");
			modelAndView.addObject("successMessage", "Korisnik je uspješno spremljen u bazu!");
			modelAndView.addObject("korisnik", new Korisnik());
			modelAndView.setViewName("registration");
			
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/admin/home", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Korisnik korisnik = korisnikService.findKorisnikByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome "  + korisnik.getEmail());
		modelAndView.addObject("adminMessage","Admin eyes only");
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}
}

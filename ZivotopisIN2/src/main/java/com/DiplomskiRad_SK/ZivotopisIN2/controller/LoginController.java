package com.DiplomskiRad_SK.ZivotopisIN2.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.CV;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Korisnik;
import com.DiplomskiRad_SK.ZivotopisIN2.models.Search;
import com.DiplomskiRad_SK.ZivotopisIN2.models.SearchWrapper;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.CVRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.services.KorisnikService;
import com.DiplomskiRad_SK.ZivotopisIN2.services.SearchService;
import com.DiplomskiRad_SK.ZivotopisIN2.services.ZivotopisDBService;

@Controller
public class LoginController {

	@Autowired
	private KorisnikService korisnikService;
	@Autowired
	private CVRepository cvrepo;
	private ZivotopisDBService cvService;

	private List<CV> results;

	
	@Autowired
	public LoginController(@Qualifier("BLCV") ZivotopisDBService zivotopisDBService) {
		this.cvService = zivotopisDBService;
	}


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


	
	

	

}

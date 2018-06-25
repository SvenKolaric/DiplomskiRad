package com.DiplomskiRad_SK.ZivotopisIN2.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {


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

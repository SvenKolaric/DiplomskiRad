package com.DiplomskiRad_SK.ZivotopisIN2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.CV;
import com.DiplomskiRad_SK.ZivotopisIN2.services.ZivotopisDBService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private List<CV> results;
	private ZivotopisDBService cvService;

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
    public ModelAndView showCVDetails(@RequestParam Integer zivotopisID) {
        cvService.deleteCVByID(zivotopisID);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/admin/home");
		modelAndView.addObject("results", results);
        return modelAndView;
    }
}

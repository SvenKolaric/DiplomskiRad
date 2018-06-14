package com.DiplomskiRad_SK.ZivotopisIN2.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.CV;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Osoba;
import com.DiplomskiRad_SK.ZivotopisIN2.services.ZivotopisDBService;

@RestController
@RequestMapping("api/test")
public class TestController {

	private final ZivotopisDBService blCV;
	
	@Autowired
	public TestController(@Qualifier("BLCV") ZivotopisDBService blCV) {
		this.blCV = blCV;
	}

	@RequestMapping(
			method = RequestMethod.GET,
			produces = org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE
	)
	public List<Osoba> getAllCVs() {
		Date d = new Date();
		CV cv = new CV();
		cv.setZivotopisID(1);
		cv.setDatumAzuriranja(new Timestamp(d.getTime()));
		cv.setDatumStvaranja(new Timestamp(d.getTime()));
		cv.setTipDokumenta("lllalala");
		//return cv;
		return blCV.getAllCV();
	}
	
	@RequestMapping(
			method = RequestMethod.POST,
			consumes = org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE
	)
	public void insertNewCV() {//@RequestBody CV cv) {
		blCV.SaveCVtest();
	}
	
	@RequestMapping(
			method = RequestMethod.DELETE,
			value = "/{id}")
	public void deleteCV(@PathVariable("id") Integer id) {
		blCV.deleteCVByID(id);
	}
}

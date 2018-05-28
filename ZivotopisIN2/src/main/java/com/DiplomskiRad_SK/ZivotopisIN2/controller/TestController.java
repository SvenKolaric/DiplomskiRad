package com.DiplomskiRad_SK.ZivotopisIN2.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.DiplomskiRad_SK.ZivotopisIN2.bl.BLCV;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.CV;

@RestController
@RequestMapping("api/test")
public class TestController {

	private final BLCV blCV;
	
	@Autowired
	public TestController(@Qualifier("BLCV") BLCV blCV) {
		this.blCV = blCV;
	}

	@RequestMapping(
			method = RequestMethod.GET,
			produces = org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE
	)
	public List<CV> getAllCVs() {
		Date d = new Date();
		CV cv = new CV();
		cv.setZivotopisID(1);
		cv.setDatumAzuriranja(new Timestamp(d.getTime()));
		cv.setDatumStvaranja(new Timestamp(d.getTime()));
		cv.setTipDokumenta("lllalala");
		cv.setIdOsoba(1);
		//return cv;
		return blCV.getAllCV();
	}
	
	@RequestMapping(
			method = RequestMethod.POST,
			consumes = org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE
	)
	public void insertNewCV(@RequestBody CV cv) {
		blCV.SaveCV(cv);
	}
}

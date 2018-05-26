package controller;

import java.awt.PageAttributes.MediaType;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bl.BLCV;
import modelDB.CV;

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
	public CV getAllCVs() {
		//return blCV.getAllCV();
		Date d = new Date();
		CV cv = new CV();
		cv.setZivotopisID(1);
		cv.setDatumAzuriranja(new Timestamp(d.getTime()));
		cv.setDatumStvaranja(new Timestamp(d.getTime()));
		cv.setTipDokumeenta("lllalala");
		cv.setIdOsoba(1);
		return cv;
	}
}

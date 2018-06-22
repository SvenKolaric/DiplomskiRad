package com.DiplomskiRad_SK.ZivotopisIN2.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.DiplomskiRad_SK.ZivotopisIN2.models.Search;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.UpitRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.services.SearchService;
import com.DiplomskiRad_SK.ZivotopisIN2.services.XMLMapParserService;

@Controller
public class UploadController {

	private final XMLMapParserService xmlParser;
	private static final Logger log = LogManager.getLogger(UploadController.class);
	
	@Autowired
	SearchService searchService;

	@Autowired
	public UploadController(@Qualifier("BLXML") XMLMapParserService xmlParser) {
		this.xmlParser = xmlParser;
	}
	
	@GetMapping("/")
	public String index() {
		return "upload";
	}
	
	@PostMapping("/upload")
	//@RequestMapping(value = "/upload", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
		log.info("Controller post method started.");
		
		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Molimo odaberite datoteku za slanje.");
			log.warn("User sent an empty post request.");
			return "redirect:uploadStatus";
		}
		
		log.debug("File sent to BLXMLparser.");
		Boolean isSaved = xmlParser.parseMapXMLFile(file);
	    log.debug("File parsed and saved status:", isSaved);
	    
		if (!isSaved) {
			redirectAttributes.addFlashAttribute("message", "Došlo je do greške u spremanju datoteke" +
												"Provjerite da li su svi podaci u životopisu upisani u odgovarajuća polja i " +
												"obavezna polja popunjena.");
			return "redirect:uploadStatus";
		}
		
		redirectAttributes.addFlashAttribute("message",	"Datoteka '" + file.getOriginalFilename() + "' je uspješno učitana i spremljena u bazu podataka.");

		return "redirect:/uploadStatus";
	}

	@GetMapping("/uploadStatus")
	public String uploadStatus() {
		return "uploadStatus";
	}

}

package com.DiplomskiRad_SK.ZivotopisIN2.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.DiplomskiRad_SK.ZivotopisIN2.bl.BLXMLParser;

@Controller
public class UploadController {

	private final BLXMLParser xmlParser;
	
	@Autowired
	public UploadController(@Qualifier("BLXML") BLXMLParser xmlParser) {
		this.xmlParser = xmlParser;
	}
	
	@GetMapping("/")
	public String index() {
		return "upload";
	}

	@PostMapping("/upload")
	//@RequestMapping(value = "/upload", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Molimo odaberite datoteku za slanje");
			return "redirect:uploadStatus";
		}
		
		//tu dojavi grešku ako se ne spremi
		xmlParser.parseMapXMLFile(file);
	        
		redirectAttributes.addFlashAttribute("message",	"Datoteka '" + file.getOriginalFilename() + "' je uspješno učitana i spremljena u bazu podataka.");

		return "redirect:/uploadStatus";
	}

	@GetMapping("/uploadStatus")
	public String uploadStatus() {
		return "uploadStatus";
	}

}

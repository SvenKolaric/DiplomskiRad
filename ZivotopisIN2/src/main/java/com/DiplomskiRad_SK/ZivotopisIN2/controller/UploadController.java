package com.DiplomskiRad_SK.ZivotopisIN2.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@Controller
public class UploadController {

	@GetMapping("/")
	public String index() {
		return "upload";
	}

	@PostMapping("/upload") // new annotation since 4.3
	//@RequestMapping(value = "/upload", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Molimo odaberite datoteku za slanje");
			return "redirect:uploadStatus";
		}

		try {

			// Get the file and save it somewhere
			//byte[] bytes = file.getBytes();
			// Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			// Files.write(path, bytes);
			InputStream is = file.getInputStream();
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();                 
	        Document doc = dBuilder.parse(is);
	        NodeList nodes = doc.getChildNodes();
			redirectAttributes.addFlashAttribute("message",
					"Uspješno ste poslali datoteku '" + file.getOriginalFilename() + "'");

		} catch (SAXException | IOException | ParserConfigurationException ex) {
	        ex.printStackTrace();
			//Logger.getLogger(JavaApplication4.class.getName()).log(Level.SEVERE, null, ex);
		}

		return "redirect:/uploadStatus";
	}

	@GetMapping("/uploadStatus")
	public String uploadStatus() {
		return "uploadStatus";
	}

}

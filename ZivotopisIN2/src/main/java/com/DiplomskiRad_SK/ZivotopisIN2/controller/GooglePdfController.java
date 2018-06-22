package com.DiplomskiRad_SK.ZivotopisIN2.controller;

import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.DiplomskiRad_SK.ZivotopisIN2.helpers.PDFGenerator;
import com.DiplomskiRad_SK.ZivotopisIN2.models.PdfFileRequest;
import com.lowagie.text.DocumentException;

import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Controller
class GooglePdfController {

	private final RestTemplate restTemplate;

	@Autowired
	GooglePdfController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	private void saveWebPage() {
		try {
			 // Create a URL object and pass url as string
			 // to download the webpage 
			 // 
			 URL url = new URL("http://localhost:8090/cv/searchQueries");
			 // Create a BufferedReader Object and pass it with
			 // InputStreamReader Object containing an InputStream
			 // Object retrieved  from openStream() method of URL
			 BufferedReader reader = new BufferedReader
			                      (new InputStreamReader(url.openStream()));
			 // Create a BufferedWriter Object and pass it with
			 // FileWriter Object containing an String
			 // representing the file name to which 
			 // the webpage is to download. 
			 BufferedWriter writer = new BufferedWriter
			                      (new FileWriter("D:/test1.html"));
			 // Create a String object to read each line 
			 // one by one from the stream
			 String line;
			 // looping till there is no line left to download
			 while ((line = reader.readLine()) != null) {
			 // Writing each line in the document hubberspot.html 
			     writer.write(line);
			     // to print each line on next line 
			     writer.newLine();
			 }
			 // Closing the BufferedReader and BufferedWriter object 
			 // to free the expensive resources
			 reader.close();
			 writer.close();
			 }// handling two exceptions below 
			 // In case URL is malformed MalformedURLException
			 // Exception is thrown and 
			 // IOException for any input/output failure
			    catch (MalformedURLException e) {

			 e.printStackTrace();
	        	System.out.println(e.getMessage());

			   } catch (IOException e) {
			  
			 e.printStackTrace();
	        	System.out.println(e.getMessage());

			  }
			 
		/*
		 * try { //Document document =
		 * Jsoup.connect("http://localhost:8090/cv/searchQueries").get(); final Response
		 * response = Jsoup.connect("http://localhost:8090/cv/searchQueries").execute();
		 * final Document doc = response.parse();
		 * 
		 * final File f = new File("D:/test.html"); FileUtils.writeStringToFile(f,
		 * doc.outerHtml(), "UTF-8");
		 * 
		 * 
		 * } catch (IOException e) { System.out.println(e.getMessage());
		 * e.printStackTrace(); }
		 */
	}
	


	@RequestMapping(value = "/pdf/google", method = RequestMethod.GET)
	void createPdfFromGoogle(HttpServletResponse response) throws IOException, DocumentException {
		saveWebPage();
		
		PdfFileRequest fileRequest = new PdfFileRequest();
		fileRequest.setFileName("google.pdf");
		fileRequest.setSourceHtmlUrl("D:/test1.html"); // http://localhost:8090/cv/searchQueries

		byte[] pdfFile = restTemplate.postForObject("http://localhost:8090/generate/pdf", fileRequest, byte[].class);
		OutputStream out = new FileOutputStream("D:/out.pdf");
		out.write(pdfFile);
		out.close();
		writePdfFileToResponse(pdfFile, "google1.pdf", response);
	}

	private void writePdfFileToResponse(byte[] pdfFile, String fileName, HttpServletResponse response) {
		try (InputStream in = new ByteArrayInputStream(pdfFile)) {
			OutputStream out = response.getOutputStream();
			IOUtils.copy(in, out);
			out.flush();

			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		} catch (IOException ex) {
			throw new RuntimeException("Error occurred when creating PDF file", ex);
		}
	}
}
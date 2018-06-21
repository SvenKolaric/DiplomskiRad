package com.DiplomskiRad_SK.ZivotopisIN2.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.DiplomskiRad_SK.ZivotopisIN2.models.PdfFileRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
 
@Controller
class GooglePdfController {
 
    private final RestTemplate restTemplate;
 
    @Autowired
    GooglePdfController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
 
    @RequestMapping(value = "/pdf/google", method = RequestMethod.GET)
    void createPdfFromGoogle(HttpServletResponse response) throws IOException {
        PdfFileRequest fileRequest = new PdfFileRequest();
        fileRequest.setFileName("google.pdf");
        fileRequest.setSourceHtmlUrl("D:/Pretraga životopisa.html"); //http://localhost:8090/cv/searchQueries
 
        byte[] pdfFile = restTemplate.postForObject("http://localhost:8090/generate/pdf", 
                fileRequest, 
                byte[].class
        );
        OutputStream out = new FileOutputStream("D:/out.pdf");
        out.write(pdfFile);
        out.close();
        writePdfFileToResponse(pdfFile, "google.pdf", response);
    }
 
    private void writePdfFileToResponse(byte[] pdfFile, 
                                        String fileName, 
                                        HttpServletResponse response) {
        try (InputStream in = new ByteArrayInputStream(pdfFile)) {
            OutputStream out = response.getOutputStream();
            IOUtils.copy(in, out);
            out.flush();
 
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        }
        catch (IOException ex) {
            throw new RuntimeException("Error occurred when creating PDF file", ex);
        }
    }
}
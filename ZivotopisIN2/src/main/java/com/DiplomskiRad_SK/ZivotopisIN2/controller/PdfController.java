package com.DiplomskiRad_SK.ZivotopisIN2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.DiplomskiRad_SK.ZivotopisIN2.models.PdfFileRequest;
import com.DiplomskiRad_SK.ZivotopisIN2.services.PdfFileCreator;

import javax.servlet.http.HttpServletResponse;
 
@RestController
public class PdfController {
 
    private final PdfFileCreator pdfFileCreator;
 
    @Autowired
    PdfController(PdfFileCreator pdfFileCreator) {
        this.pdfFileCreator = pdfFileCreator;
    }
 
    @RequestMapping(value = "/generate/pdf", method = RequestMethod.POST)
    void createPdf(@RequestBody PdfFileRequest fileRequest, HttpServletResponse response) {
        pdfFileCreator.writePdfToResponse(fileRequest, response);
    }
}
package com.DiplomskiRad_SK.ZivotopisIN2.bl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.CV;

@Service("BLXML")
public class BLXMLParser {

	public void parseMapXMLFile(MultipartFile file) {

		Document doc = convertToDOM(file);
		doc.getDocumentElement().normalize();

		NodeList nList = doc.getElementsByTagName("DocumentInfo");
		Node cvNode = nList.item(0);
		if (cvNode.getNodeType() == Node.ELEMENT_NODE) {

			Element cvElement = (Element) cvNode;
			Timestamp ts = stringToTimestamp(cvElement.getElementsByTagName("CreationDate").item(0).getTextContent());
			CV cv = new CV(null, cvElement.getElementsByTagName("DocumentType").item(0).getTextContent(),
					stringToTimestamp(cvElement.getElementsByTagName("CreationDate").item(0).getTextContent()),
					stringToTimestamp(cvElement.getElementsByTagName("LastUpdateDate").item(0).getTextContent()), null);

		}
	}

	private Document convertToDOM(MultipartFile file) {

		try {
			InputStream is = file.getInputStream();
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(is);
			return doc;

		} catch (SAXException | IOException | ParserConfigurationException ex) {
			ex.printStackTrace();
			// Logger.getLogger(JavaApplication4.class.getName()).log(Level.SEVERE, null,
			// ex);
		}

		return null;
	}

	private static Timestamp stringToTimestamp(String str_date) {
		
		str_date = str_date.replace("T", " ");
		str_date = str_date.replaceAll("Z", "");

		try {

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
			java.util.Date parsedDate = dateFormat.parse(str_date);
			Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());

			return timestamp;
		} catch (ParseException e) {
			System.out.println("Exception :" + e);
			return null;
		}
	}
}

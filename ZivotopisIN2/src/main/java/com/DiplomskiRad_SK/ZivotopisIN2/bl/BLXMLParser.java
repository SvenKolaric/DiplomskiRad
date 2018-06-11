package com.DiplomskiRad_SK.ZivotopisIN2.bl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.CV;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Drzava;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Drzavljanstvo;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Institucija;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.KontaktniInfo;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Mjesto;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Osoba;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.TipKontakta;

@Service("BLXML")
public class BLXMLParser {

	public Boolean parseMapXMLFile(MultipartFile file) throws ParseException, DOMException {

		Document doc = convertToDOM(file);
		if (doc == null) {
			return false;
		}

		Element root = doc.getDocumentElement();
		NamedNodeMap nm = root.getAttributes();
		System.out.println(nm);

		doc.getDocumentElement().normalize();

		/* Identification = Osoba - KontaktInfo - TipKontakta - Drzavljanstvo */
		Osoba osoba = new Osoba();
		ArrayList<KontaktniInfo> konInfoList = new ArrayList<>();
		ArrayList<TipKontakta> tipKonList = new ArrayList<>();
		ArrayList<Drzavljanstvo> drzavljanstvoList = new ArrayList<>();

		// Osoba
		NodeList nodeList = doc.getElementsByTagName("PersonName");
		Node node = nodeList.item(0);
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			Element element = (Element) node;
			osoba.setIme(element.getElementsByTagName("FirstName").item(0).getTextContent());
			osoba.setPrezime(element.getElementsByTagName("Surname").item(0).getTextContent());
		}
		
		//Osoba birth date
		nodeList = doc.getElementsByTagName("Demographics");
		node = nodeList.item(0).getChildNodes().item(0);
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			Element element = (Element) node;
			String date = new StringBuilder().append(element.getAttribute("day")).append(element.getAttribute("month"))
					.append(element.getAttribute("year")).toString();
			date = date.replace("-", "");
			osoba.setGodRodenja(new SimpleDateFormat("ddMMyyyy").parse(date));
		}
		
		//Osoba gender
		node = nodeList.item(0).getChildNodes().item(1);
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			Element element = (Element) node;
			osoba.setSpol(element.getElementsByTagName("Code").item(0).getTextContent());
		}

		//KontaktInfo/TipKontakta telefon
		nodeList = doc.getElementsByTagName("Telephone");
		for (int count = 0; count < nodeList.getLength(); count++) {
			node = nodeList.item(count);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				KontaktniInfo ki = new KontaktniInfo(null,
						element.getElementsByTagName("Contact").item(0).getTextContent());
				konInfoList.add(ki);
			}
			
			node = nodeList.item(count).getChildNodes().item(1);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				TipKontakta tk = new TipKontakta(null, 
						element.getElementsByTagName("Label").item(0).getTextContent());
				tipKonList.add(tk);
			}
		}

		// Email - TipKontakta/KontaktniInfo
		nodeList = doc.getElementsByTagName("Email");
		node = nodeList.item(0);
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			Element element = (Element) node;
			TipKontakta tk = new TipKontakta(null, node.getNodeName());
			KontaktniInfo ki = new KontaktniInfo(null,
					element.getElementsByTagName("Contact").item(0).getTextContent());
			tipKonList.add(tk);
			konInfoList.add(ki);
		}

		// Instant messaging - list TipKontakta/KontaktniInfo
		nodeList = doc.getElementsByTagName("InstantMessaging");
		if (nodeList.getLength() != 0) {
			for (int count = 0; count < nodeList.getLength(); count++) {
				node = nodeList.item(count);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					KontaktniInfo ki = new KontaktniInfo(null,
							element.getElementsByTagName("Contact").item(0).getTextContent());
					konInfoList.add(ki);

				}
				node = nodeList.item(count).getChildNodes().item(1);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					TipKontakta tk = new TipKontakta(null,
							element.getElementsByTagName("Label").item(0).getTextContent());
					tipKonList.add(tk);
				}
			}
		}

		// Drzavljanstvo
		nodeList = doc.getElementsByTagName("Nationality");
		for (int count = 0; count < nodeList.getLength(); count++) {
			node = nodeList.item(count);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				Drzavljanstvo drz = new Drzavljanstvo(null,
						element.getElementsByTagName("Label").item(0).getTextContent());
				drzavljanstvoList.add(drz);
			}
		}

		/* Mjesto - Država */ //samo osoba //index 0 - osoba, index workExp.length() - poslovi, index Edu.lenght() - edukacija
		ArrayList<Mjesto> mjestoList = new ArrayList<>();
		ArrayList<Drzava> drzavaList = new ArrayList<>();
		//ArrayList<Institucija> institucijaList = new ArrayList<>();
		//tu imaš komplikacije - prvo ti je za osobu, a za ostalo moraš gledati da li je normalna forma ili samo municipality
		nodeList = doc.getElementsByTagName("Address");
		node = nodeList.item(0).getChildNodes().item(0);
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			Element element = (Element) node;
			osoba.setAdresa(element.getElementsByTagName("AddressLine").item(0).getTextContent());
			
			Mjesto mjesto = new Mjesto(null, Integer.parseInt(element.getElementsByTagName("PostalCode").item(0).getTextContent()),
					element.getElementsByTagName("Municipality").item(0).getTextContent());
			
			osoba.setMjesto(mjesto); //možda bez ovog - samo spremi u listu pa tijekom spremanja znaš da mjesta/drzave na indexu 0 su ti osobe
			
			Node drzavaNode = node.getChildNodes().item(3);
			element = (Element) drzavaNode;
			
			Drzava drzava = new Drzava(null, element.getElementsByTagName("Code").item(0).getTextContent());
			System.out.println(drzava.toString());
		}
		
		/*for(int count = 0; count < nodeList.getLength(); count++) {
			Mjesto mjesto = new Mjesto();
			Institucija inst = new Institucija();
			
			node = nodeList.item(count).getChildNodes().item(0);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
			
				if(count == 0) {
					osoba.setAdresa(element.getElementsByTagName("AddressLine").item(0).getTextContent());
				} else {
					NodeList nodeL = node.getChildNodes();
					if(nodeL.getLength() == 1) {
					String[] address = element.getElementsByTagName("Municipality").item(0).getTextContent().split(",");
					inst.setAdresa(adresa);
					}
				}				
				}
				//name = ((city.getName() == null) ? "N/A" : city.getName());
			}*/
		
		/* CV */
		nodeList = doc.getElementsByTagName("DocumentInfo");
		Node cvNode = nodeList.item(0);
		if (cvNode.getNodeType() == Node.ELEMENT_NODE) {

			Element cvElement = (Element) cvNode;
			// Timestamp ts =
			// stringToTimestamp(cvElement.getElementsByTagName("CreationDate").item(0).getTextContent());
			CV cv = new CV(null, cvElement.getElementsByTagName("DocumentType").item(0).getTextContent(),
					stringToTimestamp(cvElement.getElementsByTagName("CreationDate").item(0).getTextContent()),
					stringToTimestamp(cvElement.getElementsByTagName("LastUpdateDate").item(0).getTextContent()));

		}

		return true;
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
		str_date = str_date.replace("Z", "");

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

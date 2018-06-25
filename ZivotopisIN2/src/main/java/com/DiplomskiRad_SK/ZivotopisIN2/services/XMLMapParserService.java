package com.DiplomskiRad_SK.ZivotopisIN2.services;

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

import org.apache.logging.log4j.*;

import org.aspectj.weaver.patterns.ParserException;
import org.springframework.beans.NullValueInNestedPathException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Dodatak;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.DodatneInfo;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Drzava;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Drzavljanstvo;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.EdukacijaITrening;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Institucija;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Jezik;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Kategorija;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.KontaktniInfo;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Mjesto;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Osoba;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.OsobaDrzavljanstvo;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.OsobnaVjestina;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Pozicija;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.RadnoIskustvo;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.TipKontakta;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.VozackaDozvola;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.VozackaOsobnaVJ;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.VrstaPrijave;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Zaglavlje;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Zna;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.VozackaDozvolaRepository;

@Service("BLXML")
public class XMLMapParserService {

	private final ZivotopisDBService blCV;
	private static final Logger log = LogManager.getLogger(XMLMapParserService.class);

	@Autowired
	public XMLMapParserService(@Qualifier("BLCV") ZivotopisDBService blCV) {
		this.blCV = blCV;
	}

	public Boolean parseMapXMLFile(MultipartFile file) {
		log.info("parseMapXMLFile started.");

		Document doc = convertToDOM(file);
		if (doc == null) {
			log.warn("The document did not convert to DOM, aborting.");
			return false;
		}

		doc.getDocumentElement().normalize();

		try {

			/* CV */
			CV cv = new CV();
			NodeList nodeList = doc.getElementsByTagName("DocumentInfo");
			Node node = nodeList.item(0);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				cv.setTipDokumenta(element.getElementsByTagName("DocumentType").item(0).getTextContent());
				cv.setDatumStvaranja(
						stringToTimestamp(element.getElementsByTagName("CreationDate").item(0).getTextContent()));
				cv.setDatumAzuriranja(
						stringToTimestamp(element.getElementsByTagName("LastUpdateDate").item(0).getTextContent()));
			}

			/* Identification = Osoba - KontaktInfo - TipKontakta - Drzavljanstvo */

			Osoba osoba = new Osoba();
			ArrayList<KontaktniInfo> konInfoList = new ArrayList<>();
			ArrayList<TipKontakta> tipKonList = new ArrayList<>();
			ArrayList<Drzavljanstvo> drzavljanstvoList = new ArrayList<>();

			// Osoba ime i prezime
			nodeList = doc.getElementsByTagName("PersonName");
			node = nodeList.item(0);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				osoba.setIme(element.getElementsByTagName("FirstName").item(0).getTextContent());
				osoba.setPrezime(element.getElementsByTagName("Surname").item(0).getTextContent());
			}

			// Osoba datum rodenja
			nodeList = doc.getElementsByTagName("Demographics");
			if (nodeList.getLength() != 0) {
				node = nodeList.item(0).getChildNodes().item(0);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					String date = new StringBuilder().append(element.getAttribute("day"))
							.append(element.getAttribute("month")).append(element.getAttribute("year")).toString();
					date = date.replace("-", "");
					osoba.setGodRodenja(new SimpleDateFormat("ddMMyyyy").parse(date));
				}

				// Osoba gender
				nodeList = doc.getElementsByTagName("Gender");
				if (nodeList.getLength() != 0) {
					node = nodeList.item(0);
					if (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) node;
						osoba.setSpol(element.getElementsByTagName("Code").item(0).getTextContent());
					}
				}
			}

			// KontaktInfo/TipKontakta telefon
			nodeList = doc.getElementsByTagName("Telephone");
			for (int count = 0; count < nodeList.getLength(); count++) {
				KontaktniInfo ki = new KontaktniInfo();
				TipKontakta tk = new TipKontakta();

				node = nodeList.item(count);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					ki.setKontakt(element.getElementsByTagName("Contact").item(0).getTextContent());
				}

				node = nodeList.item(count).getChildNodes().item(1);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					if (node.getChildNodes().getLength() == 2) {
						Element element = (Element) node;
						tk.setNaziv(element.getElementsByTagName("Code").item(0).getTextContent());
					} else {
						if (node.getChildNodes().item(0).getNodeName() == "Label") {
							Element element = (Element) node;
							tk.setNaziv(element.getElementsByTagName("Label").item(0).getTextContent());
						} else if (node.getChildNodes().item(0).getNodeName() == "Code") {
							Element element = (Element) node;
							tk.setNaziv(element.getElementsByTagName("Code").item(0).getTextContent());
						}
					}
				}
				tk.addKontaktniInfo(ki);
				konInfoList.add(ki);
				tipKonList.add(tk);
			}

			// Email - TipKontakta/KontaktniInfo
			nodeList = doc.getElementsByTagName("Email");
			node = nodeList.item(0);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				TipKontakta tk = new TipKontakta(null, node.getNodeName());
				KontaktniInfo ki = new KontaktniInfo(null,
						element.getElementsByTagName("Contact").item(0).getTextContent());

				tk.addKontaktniInfo(ki);
				tipKonList.add(tk);
				konInfoList.add(ki);
			}

			// Instant messaging - list TipKontakta/KontaktniInfo
			nodeList = doc.getElementsByTagName("InstantMessaging");
			if (nodeList.getLength() != 0) {
				for (int count = 0; count < nodeList.getLength(); count++) {
					KontaktniInfo ki = new KontaktniInfo();
					TipKontakta tk = new TipKontakta();

					node = nodeList.item(count);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) node;
						ki.setKontakt(element.getElementsByTagName("Contact").item(0).getTextContent());
					}
					node = nodeList.item(count).getChildNodes().item(1);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) node;
						tk.setNaziv(element.getElementsByTagName("Label").item(0).getTextContent());
					}

					tk.addKontaktniInfo(ki);
					konInfoList.add(ki);
					tipKonList.add(tk);
				}
			}

			// Drzavljanstvo
			nodeList = doc.getElementsByTagName("Nationality");
			if (nodeList.getLength() != 0) {
				for (int count = 0; count < nodeList.getLength(); count++) {
					node = nodeList.item(count);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) node;
						Drzavljanstvo drz = new Drzavljanstvo(null,
								element.getElementsByTagName("Label").item(0).getTextContent());
						drzavljanstvoList.add(drz);
					}
				}
			}

			/* Mjesto - Država */

			ArrayList<Mjesto> mjestoList = new ArrayList<>();
			ArrayList<Drzava> drzavaList = new ArrayList<>();
			// ArrayList<Institucija> institucijaList = new ArrayList<>();
			// tu imaš komplikacije - prvo ti je za osobu, a za ostalo moraš gledati da li
			// je normalna forma ili samo municipality
			nodeList = doc.getElementsByTagName("Address");
			node = nodeList.item(0).getChildNodes().item(0);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				osoba.setAdresa(element.getElementsByTagName("AddressLine").item(0).getTextContent());

				Mjesto mjesto = new Mjesto(null,
						Integer.parseInt(element.getElementsByTagName("PostalCode").item(0).getTextContent()),
						element.getElementsByTagName("Municipality").item(0).getTextContent());

				// osoba.setMjesto(mjesto); //možda bez ovog - samo spremi u listu pa tijekom
				// spremanja znaš da mjesta/drzave na indexu 0 su ti osobe

				Node drzavaNode = node.getChildNodes().item(3);
				element = (Element) drzavaNode;

				Drzava drzava = new Drzava(null, element.getElementsByTagName("Code").item(0).getTextContent());

				drzava.addMjesto(mjesto);
				mjestoList.add(mjesto);
				drzavaList.add(drzava);

			}

			/* Zaglavlje */
			Zaglavlje zaglavlje = new Zaglavlje();
			VrstaPrijave vPrijave = new VrstaPrijave();
			nodeList = doc.getElementsByTagName("Headline");
			node = nodeList.item(0).getChildNodes().item(0);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				vPrijave.setNaziv(element.getElementsByTagName("Label").item(0).getTextContent());
			}

			node = nodeList.item(0).getChildNodes().item(1);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				zaglavlje.setOpis(element.getElementsByTagName("Label").item(0).getTextContent());
			}

			vPrijave.addZaglavlje(zaglavlje);
			// zaglavlje.setVrstaPrijave(vPrijave);

			/* Posao - Institucija */
			ArrayList<RadnoIskustvo> radnoIskList = new ArrayList<>();
			ArrayList<Institucija> institucijaList = new ArrayList<>();

			nodeList = doc.getElementsByTagName("WorkExperience");
			for (int count = 0; count < nodeList.getLength(); count++) {
				Institucija inst = new Institucija();
				RadnoIskustvo radnoIsk = new RadnoIskustvo();
				Pozicija pozicija = new Pozicija();

				// RadnoIskustvo start - end datum (end može biti null)
				node = nodeList.item(count).getChildNodes().item(0);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Node tempNode = node.getChildNodes().item(0);

					Element element = (Element) tempNode;
					String date = new StringBuilder().append(element.getAttribute("day"))
							.append(element.getAttribute("month")).append(element.getAttribute("year")).toString();
					date = date.replace("-", "");
					radnoIsk.setDatumPocetka((new SimpleDateFormat("ddMMyyyy").parse(date)));

					tempNode = node.getChildNodes().item(1);

					element = (Element) tempNode;
					date = new StringBuilder().append(element.getAttribute("day")).append(element.getAttribute("month"))
							.append(element.getAttribute("year")).toString();
					date = date.replace("-", "");

					if (date.isEmpty()) {
						radnoIsk.setDatumKraja(null);
					} else {
						if (date.length() < 8) {
							throw new IllegalArgumentException("Vrijednost datuma je nepotpuna!");
						}
						radnoIsk.setDatumKraja((new SimpleDateFormat("ddMMyyyy").parse(date)));
					}
				}

				// Provjera da li je dodana dokumentacija ili ne
				node = nodeList.item(count);
				Integer position;
				if (node.getChildNodes().item(1).getNodeName() != "Documentation") {
					position = 0;
				} else {
					position = 1;
					// tu možda dodati da se referenciraš na to
				}
				// pozicija
				node = nodeList.item(count).getChildNodes().item(position + 1);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					pozicija.setNaziv(element.getElementsByTagName("Label").item(0).getTextContent());
					pozicija.addRadnoIskustvo(radnoIsk);
					// radnoIsk.setPozicija(pozicija);
				}
				// Opis radnog mjesta
				node = nodeList.item(count);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					radnoIsk.setOpisPosla(element.getElementsByTagName("Activities").item(0).getTextContent());
				}
				// ime institucija - Employer node
				node = nodeList.item(count).getChildNodes().item(position + 3);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					inst.setNaziv(element.getElementsByTagName("Name").item(0).getTextContent());
				}
				// sektor - Sector
				node = nodeList.item(count).getChildNodes().item(position + 3).getChildNodes().item(2);
				if (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					radnoIsk.setDjelatnostSektor(element.getElementsByTagName("Label").item(0).getTextContent());
				}

				// adressa institucije, mjesto i država !!!!!!!!!!!tu moraš javiti da mora se to napuniti
				node = nodeList.item(count).getChildNodes().item(position + 3).getChildNodes().item(1).getChildNodes()
						.item(0).getChildNodes().item(0);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					inst.setAdresa(element.getElementsByTagName("AddressLine").item(0).getTextContent());

					Mjesto mjesto = new Mjesto(null,
							Integer.parseInt(element.getElementsByTagName("PostalCode").item(0).getTextContent()),
							element.getElementsByTagName("Municipality").item(0).getTextContent());
					// Code drzave
					Drzava drzava = new Drzava(null,
							element.getElementsByTagName("Country").item(0).getChildNodes().item(0).getTextContent());

					drzava.addMjesto(mjesto);
					// mjesto.setDrzava(drzava);
					// inst.setMjesto(mjesto);
					mjesto.addInstitucija(inst);
					drzavaList.add(drzava);

					mjestoList.add(mjesto);
					institucijaList.add(inst);
				}

				// Webadresa institucije ako postoji
				node = nodeList.item(count).getChildNodes().item(position + 3).getChildNodes().item(1).getChildNodes()
						.item(1);
				if (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					inst.setWebStranica(element.getElementsByTagName("Contact").item(0).getTextContent());
				}

				// radnoIsk.setInstitucija(inst);
				inst.addRadnoIskustvo(radnoIsk);
				radnoIskList.add(radnoIsk);
				// name = ((city.getName() == null) ? "N/A" : city.getName());
			}

			/* Edukacija i institucija */
			ArrayList<EdukacijaITrening> eduTrenList = new ArrayList<>();

			nodeList = doc.getElementsByTagName("Education");
			for (int count = 0; count < nodeList.getLength(); count++) {
				Institucija inst = new Institucija();
				EdukacijaITrening eduTren = new EdukacijaITrening();

				// Edukacija start - end datum (end može biti null)
				node = nodeList.item(count).getChildNodes().item(0);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Node tempNode = node.getChildNodes().item(0);

					Element element = (Element) tempNode;
					String date = new StringBuilder().append(element.getAttribute("day"))
							.append(element.getAttribute("month")).append(element.getAttribute("year")).toString();
					date = date.replace("-", "");
					eduTren.setDatumPocetka((new SimpleDateFormat("ddMMyyyy").parse(date)));

					tempNode = node.getChildNodes().item(1);

					element = (Element) tempNode;
					date = new StringBuilder().append(element.getAttribute("day")).append(element.getAttribute("month"))
							.append(element.getAttribute("year")).toString();
					date = date.replace("-", "");

					if (date.isEmpty()) {
						eduTren.setDatumKraja(null);
					} else {

						if (date.length() < 8) {
							throw new IllegalArgumentException("Vrijednost datuma je nepotpuna!");
						}
						eduTren.setDatumKraja((new SimpleDateFormat("ddMMyyyy").parse(date)));
					}
				}

				// Provjera da li je dodana dokumentacija ili ne
				node = nodeList.item(count);
				Integer position;
				if (node.getChildNodes().item(1).getNodeName() != "Documentation") {
					position = 0;
				} else {
					position = 1;
					// tu možda dodati da se referenciraš na to
				}

				// titula
				node = nodeList.item(count);
				if (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					eduTren.setKvalifikacija(element.getElementsByTagName("Title").item(0).getTextContent());
				}

				// Opis stecenih vjestina
				node = nodeList.item(count);
				if (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					eduTren.setPredmetiSteceneVjestine(
							element.getElementsByTagName("Activities").item(0).getTextContent());
				}

				// ime institucija - Employer node
				node = nodeList.item(count).getChildNodes().item(position + 3);
				if (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					inst.setNaziv(element.getElementsByTagName("Name").item(0).getTextContent());
				}
				// adressa institucije, mjesto i država
				node = nodeList.item(count).getChildNodes().item(position + 3).getChildNodes().item(1).getChildNodes()
						.item(0).getChildNodes().item(0);
				if (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					inst.setAdresa(element.getElementsByTagName("AddressLine").item(0).getTextContent());

					Mjesto mjesto = new Mjesto(null,
							Integer.parseInt(element.getElementsByTagName("PostalCode").item(0).getTextContent()),
							element.getElementsByTagName("Municipality").item(0).getTextContent());
					// Code drzave
					Drzava drzava = new Drzava(null,
							element.getElementsByTagName("Country").item(0).getChildNodes().item(0).getTextContent());

					drzava.addMjesto(mjesto);
					// mjesto.setDrzava(drzava);
					// inst.setMjesto(mjesto);
					mjesto.addInstitucija(inst);
					drzavaList.add(drzava);

					mjestoList.add(mjesto);
					institucijaList.add(inst);
				}

				// Webadresa institucije ako postoji
				node = nodeList.item(count).getChildNodes().item(position + 3).getChildNodes().item(1).getChildNodes()
						.item(1);
				if (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					inst.setWebStranica(element.getElementsByTagName("Contact").item(0).getTextContent());
				}

				// Level - ekorazina
				node = nodeList.item(count).getChildNodes().item(position + 4);
				if (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					eduTren.setEkorazina(element.getElementsByTagName("Label").item(0).getTextContent());
				}

				// Područje obrazovanja
				node = nodeList.item(count).getChildNodes().item(position + 5);
				if (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					eduTren.setPodrucjeObrazovanja(element.getElementsByTagName("Label").item(0).getTextContent());
				}

				// eduTren.setInstitucija(inst);
				inst.addEdukacijaITrening(eduTren);
				eduTrenList.add(eduTren);
				// name = ((city.getName() == null) ? "N/A" : city.getName());
			}

			/* Osobne vještine - jezik - vozački */

			OsobnaVjestina osobnaVJ = new OsobnaVjestina();
			ArrayList<Zna> znaList = new ArrayList<>();
			ArrayList<VozackaOsobnaVJ> vozOsobnaVJList = new ArrayList<>();

			// Materinji jezik
			nodeList = doc.getElementsByTagName("MotherTongue");
			node = nodeList.item(0).getChildNodes().item(0);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				osobnaVJ.setMaterinjiJezik(element.getElementsByTagName("Label").item(0).getTextContent());
			}

			// Jezici
			nodeList = doc.getElementsByTagName("ForeignLanguage");
			for (int count = 0; count < nodeList.getLength(); count++) {
				Zna zna = new Zna();
				Jezik jezik = new Jezik();

				// Jezik
				node = nodeList.item(count).getChildNodes().item(0);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					jezik.setNaziv(element.getElementsByTagName("Label").item(0).getTextContent());
				}

				// ProficiencyLevel
				node = nodeList.item(count).getChildNodes().item(1);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					zna.setRazumijevanjeSlusanje(element.getElementsByTagName("Listening").item(0).getTextContent());
					zna.setRazumijevanjeCitanje(element.getElementsByTagName("Reading").item(0).getTextContent());
					zna.setGovornaInterakcija(
							element.getElementsByTagName("SpokenInteraction").item(0).getTextContent());
					zna.setGovornaProdukcija(element.getElementsByTagName("SpokenProduction").item(0).getTextContent());
					zna.setPisanje(element.getElementsByTagName("Writing").item(0).getTextContent());
				}

				// Certifikati jezika
				if (nodeList.item(count).getChildNodes().getLength() > 2) {
					node = nodeList.item(count).getChildNodes().item(2).getChildNodes().item(0);
					if (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) node;
						zna.setDiplome(element.getElementsByTagName("Title").item(0).getTextContent());
					}
				}

				// zna.setJezik(jezik);
				jezik.addZna(zna);
				znaList.add(zna);
			}

			// Komunikacijske vjestine
			nodeList = doc.getElementsByTagName("Communication");
			if (nodeList.getLength() != 0) {
				node = nodeList.item(0);
				if (node != null && node.getNodeType() == Node.ELEMENT_NODE
						&& node.getChildNodes().item(0).getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					osobnaVJ.setKomunikacijskeVj(element.getElementsByTagName("Description").item(0).getTextContent());
				}
			}
			// Organizacijske vještine
			nodeList = doc.getElementsByTagName("Organisational");
			node = nodeList.item(0);
			if (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				osobnaVJ.setOrganizacijskeVj(element.getElementsByTagName("Description").item(0).getTextContent());
			}

			// Poslovne vještine
			nodeList = doc.getElementsByTagName("JobRelated");
			node = nodeList.item(0);
			if (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				osobnaVJ.setPoslovneVj(element.getElementsByTagName("Description").item(0).getTextContent());
			}

			// Ostale vjestine
			nodeList = doc.getElementsByTagName("Other");
			node = nodeList.item(0);
			if (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				osobnaVJ.setOstaleVj(element.getElementsByTagName("Description").item(0).getTextContent());
			}

			// Računalne vještine
			nodeList = doc.getElementsByTagName("Computer");
			node = nodeList.item(0);
			if (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				osobnaVJ.setRacunalneVJ(element.getElementsByTagName("Description").item(0).getTextContent());
			}

			node = nodeList.item(0).getChildNodes().item(1);
			if (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				osobnaVJ.setObradaInfo(element.getElementsByTagName("Information").item(0).getTextContent());
				osobnaVJ.setKomunikacija(element.getElementsByTagName("Communication").item(0).getTextContent());
				osobnaVJ.setStvaranjeSadrzaja(element.getElementsByTagName("ContentCreation").item(0).getTextContent());
				osobnaVJ.setSigurnost(element.getElementsByTagName("Safety").item(0).getTextContent());
				osobnaVJ.setRjesavanjeProblema(element.getElementsByTagName("ProblemSolving").item(0).getTextContent());
			}

			// Vozacka dozvola
			nodeList = doc.getElementsByTagName("Driving");
			if (nodeList.getLength() != 0) {
				for (int count = 0; count < nodeList.getLength(); count++) {
					VozackaDozvola vd = new VozackaDozvola();
					VozackaOsobnaVJ vOsobnaVJ = new VozackaOsobnaVJ();

					node = nodeList.item(0).getChildNodes().item(count);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) node;
						vd.setKategorija(element.getElementsByTagName("Licence").item(0).getTextContent());
					}

					vd.addVozackaOsobnaVJ(vOsobnaVJ);
					// vOsobnaVJ.setVozackaDozvola(vd);
					vozOsobnaVJList.add(vOsobnaVJ);
				}
			}

			/* Dodatne Info - Kategorija */
			ArrayList<DodatneInfo> dodatneInfoList = new ArrayList<>();

			nodeList = doc.getElementsByTagName("Achievement");
			if (nodeList.getLength() != 0) {
				for (int count = 0; count < nodeList.getLength(); count++) {
					Kategorija kat = new Kategorija();
					DodatneInfo dodInfo = new DodatneInfo();

					// Kategorija
					node = nodeList.item(count).getChildNodes().item(0);
					if (node != null && node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName() == "Title") {
						Element element = (Element) node;
						kat.setNaziv(element.getElementsByTagName("Label").item(0).getTextContent());
					}

					// Dodatne Info
					node = nodeList.item(count);
					if (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) node;
						dodInfo.setOpis(element.getElementsByTagName("Description").item(0).getTextContent());
					}

					// dodInfo.setKategorija(kat);
					if (kat.getNaziv() == null) {
						kat.setNaziv("Nepoznato");
						kat.addDodatneInfo(dodInfo);
						dodatneInfoList.add(dodInfo);
					} else {
						kat.addDodatneInfo(dodInfo);
						dodatneInfoList.add(dodInfo);
					}
				}
			}

			/* Dodatak */
			ArrayList<Dodatak> dodatakList = new ArrayList<>();

			nodeList = doc.getElementsByTagName("Attachment");
			if (nodeList.getLength() != 0) {
				for (int count = 0; count < nodeList.getLength(); count++) {
					Dodatak dod = new Dodatak();

					node = nodeList.item(count);
					if (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) node;
						dod.setNaziv(element.getElementsByTagName("Name").item(0).getTextContent());
						dod.setMetadata(element.getElementsByTagName("Data").item(0).getTextContent());
					}

					dodatakList.add(dod);
				}
			}

			// Kreiraj CV i spremi ga
			// Održavanje bidirectional veze

			mjestoList.get(0).addOsoba(osoba);

			osobnaVJ.setVozackaDozvolaOsVJList(vozOsobnaVJList);
			osobnaVJ.setZnaList(znaList);
			cv.addOsobnaVjestina(osobnaVJ);

			osoba.setKontaktInfoList(konInfoList);

			ArrayList<OsobaDrzavljanstvo> osobaDrzList = new ArrayList<>();
			for (int count = 0; count < drzavljanstvoList.size(); count++) {
				OsobaDrzavljanstvo od = new OsobaDrzavljanstvo();
				drzavljanstvoList.get(count).addOsobaDrzavljanstvo(od);
				osobaDrzList.add(od);
			}

			osoba.setDrzavljanstvoList(osobaDrzList);
			osoba.addCV(cv);

			cv.setDodatakList(dodatakList);
			cv.addZaglavlje(zaglavlje);
			cv.setDodatneInfoList(dodatneInfoList);
			cv.setEdukacijaITreningList(eduTrenList);
			cv.setRadnoIskustvoList(radnoIskList);

			blCV.SaveCV(cv);
			blCV.CalculateDateRangeWorkEdu();

		} catch (ParseException e) {
			log.error("Error while parsing document: ", e);
			// e.printStackTrace();
			// System.out.println("Exception :" + e);
			return false;

		} catch (IllegalArgumentException e) {
			log.error("Error while mapping value: ", e);
			// e.printStackTrace();
			// System.out.println(e.getMessage());
			return false;
		} catch (NullPointerException | NullValueInNestedPathException e) {
			log.error("Null error ocured: ", e);
			return false;
		}

		return true;
	}

	private Document convertToDOM(MultipartFile file) {

		try {
			log.debug("convertToDom started.");
			InputStream is = file.getInputStream();
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(is);
			log.debug("convertToDom succesfull.");
			return doc;

		} catch (SAXException | IOException | ParserConfigurationException e) {
			log.error("Error while converting Multipart file to DOM: ", e);
			return null;
		}

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
			log.error("Error while converting string to date, check if date is valid format", e);
			return null;
		}
	}
}

package com.DiplomskiRad_SK.ZivotopisIN2.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DiplomskiRad_SK.ZivotopisIN2.controller.UploadController;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.CV;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.KorisnickaUloga;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Korisnik;
import com.DiplomskiRad_SK.ZivotopisIN2.modelDB.Osoba;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.KorisnickaUlogaRepository;
import com.DiplomskiRad_SK.ZivotopisIN2.repository.KorisnikRepository;

@Service("korisnikService")
public class KorisnikServiceImpl implements KorisnikService {

	private static final Logger log = LogManager.getLogger(UploadController.class);

	@Autowired
	private KorisnikRepository KorisnikRepo;
	@Autowired
	private KorisnickaUlogaRepository KorisnickaUlogaRepo;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Korisnik findKorisnikByEmail(String email) {
		try {
			return KorisnikRepo.findByEmail(email);
		} catch (Exception e) {
			log.error("Greška u dohvaćanju korisnika.", e);
			return null;
		}
	}

	@Override
	public Boolean saveKorisnik(Korisnik korisnik, String uloga) {
		try {
			log.info("Pokrenuto spremanje novog korisnika: ", korisnik.getEmail(), " s ulogom: ", uloga);
			korisnik.setPassword(bCryptPasswordEncoder.encode(korisnik.getPassword()));
			KorisnickaUloga korisnickaUloga = KorisnickaUlogaRepo.findByUloga(uloga);
			korisnik.setUloga(korisnickaUloga);
			KorisnikRepo.save(korisnik);
			log.info("Spremanje korisnika uspješno");
			return true;
		} catch (Exception e) {
			log.error("Greška kod spremanja korisnika", e);
			return false;
		}
	}
	
	@Override
	public List<Korisnik> findAll(){
		try {
			List<Korisnik> results = new ArrayList<>();
			results = (List<Korisnik>) KorisnikRepo.findAll();
			return results;
		} catch (Exception e) {
			log.error("Greška u dohvaćanju liste korisnika", e);
			return null;
		}
	}
	
	@Transactional
	public Boolean deleteKorisnik(Integer id) {
		try {
			Optional<Korisnik> korisnikOpt = KorisnikRepo.findById(id);
			if (korisnikOpt.get() == null) {
				return false;
			} else {
				Korisnik korisnik = korisnikOpt.get();
				korisnik.setUloga(null); //getUloga().removeKorisnik(korisnik);
				KorisnikRepo.delete(korisnik);

			}
			return true;
		} catch (Exception e) {
			log.error("Greška u dohvaćanju liste korisnika", e);
			return false;
		}
	}

}

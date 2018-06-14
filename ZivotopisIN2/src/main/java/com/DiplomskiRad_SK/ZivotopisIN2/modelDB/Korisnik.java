package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "KORISNIK")
public class Korisnik {
	@Id
	@GeneratedValue(generator = "KORISNIKSeq")
	@SequenceGenerator(name = "KORISNIKSeq", sequenceName = "KORISNIK_SEQ", allocationSize = 1)
	private Integer id;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "ISADMIN")
	private Integer isAdmin;
	
	public Korisnik() {
		
	}
	
	public Korisnik(Integer id, String password, String email, Integer isAdmin) {
		this.id = id;
		this.password = password;
		this.email = email;
		this.isAdmin = isAdmin;
	}
	
}

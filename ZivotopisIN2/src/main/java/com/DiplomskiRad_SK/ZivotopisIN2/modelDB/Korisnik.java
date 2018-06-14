package com.DiplomskiRad_SK.ZivotopisIN2.modelDB;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "KORISNIK")
public class Korisnik {
	@Id
	@GeneratedValue(generator = "KORISNIKSeq")
	@SequenceGenerator(name = "KORISNIKSeq", sequenceName = "KORISNIK_SEQ", allocationSize = 1)
	private Integer id;
	@Column(name = "LOZINKA")
	@Length(min = 8, message = "*Lozinka mora imati barem 8 znakova")
	@NotEmpty(message = "*Polje lozinka je prazno")
	private String password;
	@Column(name = "EMAIL")
	@Email(message = "*Molimo unesite valjanu email adresu")
	@NotEmpty(message = "*Polje email je prazno")
	private String email;
	@Column(name = "ISADMIN")
	private Integer isAdmin; //0 - false, 1 - true
	@Transient
	private String role;
	
	public Korisnik() {
		
	}
	
	public Korisnik(Integer id, String password, String email, Integer isAdmin) {
		this.id = id;
		this.password = password;
		this.email = email;
		this.isAdmin = isAdmin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}

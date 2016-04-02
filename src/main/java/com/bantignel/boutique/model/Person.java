package com.bantignel.boutique.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;



@Entity
@Table(name="Person")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Person  implements Serializable{
	protected static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;
	@NotEmpty(message="le nom est réquis")
	@Length(min=3, max=15, message="le nom prend entre 3 et 15 caractères")
	protected String nom;
	@NotEmpty(message="le prenom est réquis")
	@Length(min=3, max=15, message="le prenom prend entre 3 et 15 caractères")
	protected String prenom;
	@NotEmpty(message="Le numero de téléphone est réquis")
	@Length(min=10, max=10, message="numéro invalide. le numéro doit avoir 10 chiffres")
	@NumberFormat(style=Style.NUMBER)
	protected String telephone;
	@NotEmpty(message="l'adresse e-mail est réquise")
	@Email(message="adresse e-mail invalide")
	protected String email;
	@NotEmpty(message="l'adresse domicile est réquise")
	protected String adresse;
	protected Person() {
	}
	public Person(String nom, String prenom, String telephone, String email, String adresse){
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.email = email;
		this.adresse = adresse;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public boolean isNew(){
		return this.id == 0;
	}
	
}

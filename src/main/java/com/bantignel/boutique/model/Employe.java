package com.bantignel.boutique.model;


import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="EMPLOYES")
@PrimaryKeyJoinColumn(name="id")
public class Employe extends Person  {
	
	private static final long serialVersionUID = 1L;
	private String dateEmbauche;
	private double salaire;
	private String login;
	private String password;
	@OneToMany(mappedBy="employe")
	private Set<Commande> commandes = new TreeSet<Commande>();
	public Employe() {
		super();
		
	}
	public Employe(String nom, String prenom, String telephone, String email, String adresse,
			String dateEmbauche,double salaire, String login, String password) {
		super(nom, prenom, telephone, email, adresse);
		this.dateEmbauche = dateEmbauche;
		this.salaire = salaire;
		this.login = login;
		this.password = password;
	}
	public String getDateEmbauche() {
		return dateEmbauche;
	}
	public void setDateEmbauche(String dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}
	
}
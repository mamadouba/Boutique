package com.bantignel.boutique.model;


import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="CLIENTS")
@PrimaryKeyJoinColumn(name="id")
public class Client extends Person{
	private static final long serialVersionUID = 1L;
	private String categorie;
	@OneToMany(mappedBy="client")
	private Set<Commande> commandes = new TreeSet<Commande>();
	
	public Client(String nom, String prenom, String telephone, String email, String adresse, String categorie) {
		super(nom, prenom, telephone, email, adresse);
		 this.categorie = categorie;
	}
	public Client(){}
	public String getCategorie() {
		return categorie;
	}
	
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public Set<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}
}
	
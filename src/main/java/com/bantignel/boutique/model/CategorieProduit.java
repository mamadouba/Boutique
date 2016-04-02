package com.bantignel.boutique.model;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORIE_PRODUITS")
public class CategorieProduit {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCategorie;
	private String nom;
	private String description;
	@OneToMany(mappedBy="categorie")
	private Set<Produit> produits = new TreeSet<Produit>();
	
	public CategorieProduit(String nom, String description) {
		super();
		this.nom = nom;
		this.description = description;
	}
	public CategorieProduit() {
		super();
	}
	public int getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<Produit> getProduits() {
		return produits;
	}
	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}
	
}

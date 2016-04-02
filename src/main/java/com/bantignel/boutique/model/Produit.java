package com.bantignel.boutique.model;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PRODUITS")
public class Produit {
	@Id
	@GeneratedValue
	private int idProduit;
	private String nom;
	@ManyToOne
	private Fournisseur fournisseur;
	@ManyToOne
	private CategorieProduit categorie;
	@OneToMany(mappedBy="produit")
	private Set<DetailCommande> detailCommande = new TreeSet<DetailCommande>();
	private int quantiteEnStock;
	private double prixUnitaire;
	public Produit(String nom, Fournisseur fournisseur, CategorieProduit categorie, int quantiteEnStock,
			double prixUnitaire) {
		super();
		this.nom = nom;
		this.fournisseur = fournisseur;
		this.categorie = categorie;
		this.quantiteEnStock = quantiteEnStock;
		this.prixUnitaire = prixUnitaire;
	}
	
	public Produit() {
		super();
	}

	public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	public CategorieProduit getCategorie() {
		return categorie;
	}
	public void setCategorie(CategorieProduit categorie) {
		this.categorie = categorie;
	}
	public Set<DetailCommande> getDetailCommande() {
		return detailCommande;
	}
	public void setDetailCommande(Set<DetailCommande> detailCommande) {
		this.detailCommande = detailCommande;
	}
	public int getQuantiteEnStock() {
		return quantiteEnStock;
	}
	public void setQuantiteEnStock(int quantiteEnStock) {
		this.quantiteEnStock = quantiteEnStock;
	}
	public double getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	
}

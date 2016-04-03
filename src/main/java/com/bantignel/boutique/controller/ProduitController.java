package com.bantignel.boutique.controller;

import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bantignel.boutique.model.Produit;
import com.bantignel.boutique.service.ProduitService;


@Controller
//@RequestMapping("/produit")
public class ProduitController {
	@Autowired
	private ProduitService service;
	
	@RequestMapping(value="/produit/new",method=RequestMethod.GET)
	public ModelAndView add(){
		ModelAndView model = new ModelAndView("addProduit");
		model.addObject("produit", new Produit());
		loadDefault(model);
		return model;
	}
	
	@RequestMapping(value="/produit/add", method=RequestMethod.POST)
	public ModelAndView add(@Valid @ModelAttribute("produit") final Produit produit, BindingResult result){
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("addProduit");
			model.addObject("msg","Produit invalide");
			model.addObject("produit",produit);
			loadDefault(model);
			return model;
	   }
		service.add(produit);
		ModelAndView model = new ModelAndView("produit");
		model.addObject("css","success");
		model.addObject("action","add");
		model.addObject("msg","Produit ajout� avec succ�s");
		return  model;
	}
	
	@RequestMapping(value="/produit/{id}/edit", method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id")final int id){
		Produit produit = service.get(id);
		ModelAndView model = new ModelAndView("editProduit");
		loadDefault(model);
		model.addObject("produit",produit);
		return model;
	}
	
	@RequestMapping(value="/produit/edit", method=RequestMethod.POST)
	public ModelAndView edit(@Valid @ModelAttribute("produit") final Produit produit, BindingResult result){
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("editProduit");
			model.addObject("msg","Produit invalide");
			model.addObject("produit",produit);
			loadDefault(model);
			return model;
	   }
		service.edit(produit);
		ModelAndView model = new ModelAndView("produit");
		model.addObject("css","success");
		model.addObject("action","update");
		model.addObject("msg","Produit modifi� avec succ�s");
		return  model;
	}
	
	@RequestMapping(value="/produit/list", method=RequestMethod.GET)
	public ModelAndView list(){
		final List<Produit> listProduit = service.list();
		ModelAndView model = new ModelAndView("listProduit");
		model.addObject("listProduit", listProduit);
		return model;
	}
	
	@RequestMapping(value="/produit/{id}/delete", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id")final int id){
		service.delete(id);
		return new ModelAndView("redirect:/produit/list");
	}
	
	@RequestMapping(value="/produit/{id}", method=RequestMethod.GET)
	public ModelAndView get(@PathVariable("id")final int id){
		ModelAndView model = new ModelAndView("produit");
		Produit produit = service.get(id);
		if(produit == null){
			model.addObject("produit",produit);
			model.addObject("css","danger");
			model.addObject("action","update");
			model.addObject("msg","Produit introuvable");
			return  model;
		}
		model.addObject("produit",produit);
		model.addObject("css","success");
		model.addObject("action","update");
		model.addObject("msg","Produit trouv� avec succ�s");
		return  model;
	}
	
	public void loadDefault(ModelAndView model){
		
	}
}

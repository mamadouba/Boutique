package com.bantignel.boutique.controller;

import java.util.ArrayList;
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
		return new ModelAndView("redirect:/produit/list");
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
		return new ModelAndView("redirect:/produit/list");
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
			model.addObject("msg","Produit introuvable");
			model.addObject("css","danger");
			return model;
		}
		model.addObject("produit",produit);
		return model;
	}
	
	public void loadDefault(ModelAndView model){
		List<String> categories = new ArrayList<String>();
		categories.add("Gold");
		categories.add("Premium");
		categories.add("Silver");
		model.addObject("categories",categories);
	}
}

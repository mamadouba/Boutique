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

import com.bantignel.boutique.model.Commande;
import com.bantignel.boutique.service.CommandeService;


@Controller
//@RequestMapping("/commande")
public class CommandeController {
	@Autowired
	private CommandeService service;
	
	@RequestMapping(value="/commande/new",method=RequestMethod.GET)
	public ModelAndView add(){
		ModelAndView model = new ModelAndView("addCommande");
		model.addObject("commande", new Commande());
		loadDefault(model);
		return model;
	}
	
	@RequestMapping(value="/commande/add", method=RequestMethod.POST)
	public ModelAndView add(@Valid @ModelAttribute("commande") final Commande commande, BindingResult result){
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("addCommande");
			model.addObject("msg","Commande invalide");
			model.addObject("commande",commande);
			loadDefault(model);
			return model;
	   }
		service.add(commande);
		ModelAndView model = new ModelAndView("commande");
		model.addObject("css","success");
		model.addObject("action","add");
		model.addObject("msg","Commande ajout� avec succ�s");
		return  model;
	}
	
	@RequestMapping(value="/commande/{id}/edit", method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id")final int id){
		Commande commande = service.get(id);
		ModelAndView model = new ModelAndView("editCommande");
		loadDefault(model);
		model.addObject("commande",commande);
		return model;
	}
	
	@RequestMapping(value="/commande/edit", method=RequestMethod.POST)
	public ModelAndView edit(@Valid @ModelAttribute("commande") final Commande commande, BindingResult result){
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("editCommande");
			model.addObject("msg","Commande invalide");
			model.addObject("commande",commande);
			loadDefault(model);
			return model;
	   }
		service.edit(commande);
		ModelAndView model = new ModelAndView("commande");
		model.addObject("css","success");
		model.addObject("action","update");
		model.addObject("msg","Commande modifi� avec succ�s");
		return  model;
	}
	
	@RequestMapping(value="/commande/list", method=RequestMethod.GET)
	public ModelAndView list(){
		final List<Commande> listCommande = service.list();
		ModelAndView model = new ModelAndView("listCommande");
		model.addObject("listCommande", listCommande);
		return model;
	}
	
	@RequestMapping(value="/commande/{id}/delete", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id")final int id){
		service.delete(id);
		return new ModelAndView("redirect:/commande/list");
	}
	
	@RequestMapping(value="/commande/{id}", method=RequestMethod.GET)
	public ModelAndView get(@PathVariable("id")final int id){
		ModelAndView model = new ModelAndView("commande");
		Commande commande = service.get(id);
		if(commande == null){
			model.addObject("commande",commande);
			model.addObject("css","danger");
			model.addObject("action","update");
			model.addObject("msg","Commande introuvable");
			return  model;
		}
		model.addObject("commande",commande);
		model.addObject("css","success");
		model.addObject("action","update");
		model.addObject("msg","Commande trouv� avec succ�s");
		return  model;
	}
	
	public void loadDefault(ModelAndView model){
		
	}
}

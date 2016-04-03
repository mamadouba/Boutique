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

import com.bantignel.boutique.model.CategorieProduit;
import com.bantignel.boutique.service.CategorieProduitService;


@Controller
//@RequestMapping("/categorieProduit")
public class CategorieProduitController {
	@Autowired
	private CategorieProduitService service;
	
	@RequestMapping(value="/categorieProduit/new",method=RequestMethod.GET)
	public ModelAndView add(){
		ModelAndView model = new ModelAndView("addCategorieProduit");
		model.addObject("categorieProduit", new CategorieProduit());
		loadDefault(model);
		return model;
	}
	
	@RequestMapping(value="/categorieProduit/add", method=RequestMethod.POST)
	public ModelAndView add(@Valid @ModelAttribute("categorieProduit") final CategorieProduit categorieProduit, BindingResult result){
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("addCategorieProduit");
			model.addObject("msg","CategorieProduit invalide");
			model.addObject("categorieProduit",categorieProduit);
			loadDefault(model);
			return model;
	   }
		service.add(categorieProduit);
		ModelAndView model = new ModelAndView("categorieProduit");
		model.addObject("css","success");
		model.addObject("action","add");
		model.addObject("msg","CategorieProduit ajouté avec succès");
		return  model;
	}
	
	@RequestMapping(value="/categorieProduit/{id}/edit", method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id")final int id){
		CategorieProduit categorieProduit = service.get(id);
		ModelAndView model = new ModelAndView("editCategorieProduit");
		loadDefault(model);
		model.addObject("categorieProduit",categorieProduit);
		return model;
	}
	
	@RequestMapping(value="/categorieProduit/edit", method=RequestMethod.POST)
	public ModelAndView edit(@Valid @ModelAttribute("categorieProduit") final CategorieProduit categorieProduit, BindingResult result){
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("editCategorieProduit");
			model.addObject("msg","CategorieProduit invalide");
			model.addObject("categorieProduit",categorieProduit);
			loadDefault(model);
			return model;
	   }
		service.edit(categorieProduit);
		ModelAndView model = new ModelAndView("categorieProduit");
		model.addObject("css","success");
		model.addObject("action","update");
		model.addObject("msg","CategorieProduit modifié avec succès");
		return  model;
	}
	
	@RequestMapping(value="/categorieProduit/list", method=RequestMethod.GET)
	public ModelAndView list(){
		final List<CategorieProduit> listCategorieProduit = service.list();
		ModelAndView model = new ModelAndView("listCategorieProduit");
		model.addObject("listCategorieProduit", listCategorieProduit);
		return model;
	}
	
	@RequestMapping(value="/categorieProduit/{id}/delete", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id")final int id){
		service.delete(id);
		return new ModelAndView("redirect:/categorieProduit/list");
	}
	
	@RequestMapping(value="/categorieProduit/{id}", method=RequestMethod.GET)
	public ModelAndView get(@PathVariable("id")final int id){
		ModelAndView model = new ModelAndView("categorieProduit");
		CategorieProduit categorieProduit = service.get(id);
		if(categorieProduit == null){
			model.addObject("categorieProduit",categorieProduit);
			model.addObject("css","danger");
			model.addObject("action","update");
			model.addObject("msg","CategorieProduit introuvable");
			return  model;
		}
		model.addObject("categorieProduit",categorieProduit);
		model.addObject("css","success");
		model.addObject("action","update");
		model.addObject("msg","CategorieProduit trouvé avec succès");
		return  model;
	}
	
	public void loadDefault(ModelAndView model){
		
	}
}

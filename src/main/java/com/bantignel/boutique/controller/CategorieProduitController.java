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

import com.bantignel.boutique.model.CategorieProduit;
import com.bantignel.boutique.service.CategorieProduitService;


@Controller
//@RequestMapping("/categorieproduit")
public class CategorieProduitController {
	@Autowired
	private CategorieProduitService service;
	
	@RequestMapping(value="/categorieproduit/new",method=RequestMethod.GET)
	public ModelAndView add(){
		ModelAndView model = new ModelAndView("addCategorieProduit");
		model.addObject("categorieproduit", new CategorieProduit());
		loadDefault(model);
		return model;
	}
	
	@RequestMapping(value="/categorieproduit/add", method=RequestMethod.POST)
	public ModelAndView add(@Valid @ModelAttribute("categorieproduit") final CategorieProduit categorieproduit, BindingResult result){
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("addCategorieProduit");
			model.addObject("msg","CategorieProduit invalide");
			model.addObject("categorieproduit",categorieproduit);
			loadDefault(model);
			return model;
	   }
		service.add(categorieproduit);
		return new ModelAndView("redirect:/categorieproduit/list");
	}
	
	@RequestMapping(value="/categorieproduit/{id}/edit", method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id")final int id){
		CategorieProduit categorieproduit = service.get(id);
		ModelAndView model = new ModelAndView("editCategorieProduit");
		loadDefault(model);
		model.addObject("categorieproduit",categorieproduit);
		return model;
	}
	
	@RequestMapping(value="/categorieproduit/edit", method=RequestMethod.POST)
	public ModelAndView edit(@Valid @ModelAttribute("categorieproduit") final CategorieProduit categorieproduit, BindingResult result){
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("editCategorieProduit");
			model.addObject("msg","CategorieProduit invalide");
			model.addObject("categorieproduit",categorieproduit);
			loadDefault(model);
			return model;
	   }
		service.edit(categorieproduit);
		return new ModelAndView("redirect:/categorieproduit/list");
	}
	
	@RequestMapping(value="/categorieproduit/list", method=RequestMethod.GET)
	public ModelAndView list(){
		final List<CategorieProduit> listCategorieProduit = service.list();
		ModelAndView model = new ModelAndView("listCategorieProduit");
		model.addObject("listCategorieProduit", listCategorieProduit);
		return model;
	}
	
	@RequestMapping(value="/categorieproduit/{id}/delete", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id")final int id){
		service.delete(id);
		return new ModelAndView("redirect:/categorieproduit/list");
	}
	
	@RequestMapping(value="/categorieproduit/{id}", method=RequestMethod.GET)
	public ModelAndView get(@PathVariable("id")final int id){
		ModelAndView model = new ModelAndView("categorieproduit");
		CategorieProduit categorieproduit = service.get(id);
		if(categorieproduit == null){
			model.addObject("msg","CategorieProduit introuvable");
			model.addObject("css","danger");
			return model;
		}
		model.addObject("categorieproduit",categorieproduit);
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

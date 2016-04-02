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

import com.bantignel.boutique.model.DetailCommande;
import com.bantignel.boutique.service.DetailCommandeService;


@Controller
//@RequestMapping("/detailcommande")
public class DetailCommandeController {
	@Autowired
	private DetailCommandeService service;
	
	@RequestMapping(value="/detailcommande/new",method=RequestMethod.GET)
	public ModelAndView add(){
		ModelAndView model = new ModelAndView("addDetailCommande");
		model.addObject("detailcommande", new DetailCommande());
		loadDefault(model);
		return model;
	}
	
	@RequestMapping(value="/detailcommande/add", method=RequestMethod.POST)
	public ModelAndView add(@Valid @ModelAttribute("detailcommande") final DetailCommande detailcommande, BindingResult result){
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("addDetailCommande");
			model.addObject("msg","DetailCommande invalide");
			model.addObject("detailcommande",detailcommande);
			loadDefault(model);
			return model;
	   }
		service.add(detailcommande);
		return new ModelAndView("redirect:/detailcommande/list");
	}
	
	@RequestMapping(value="/detailcommande/{id}/edit", method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id")final int id){
		DetailCommande detailcommande = service.get(id);
		ModelAndView model = new ModelAndView("editDetailCommande");
		loadDefault(model);
		model.addObject("detailcommande",detailcommande);
		return model;
	}
	
	@RequestMapping(value="/detailcommande/edit", method=RequestMethod.POST)
	public ModelAndView edit(@Valid @ModelAttribute("detailcommande") final DetailCommande detailcommande, BindingResult result){
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("editDetailCommande");
			model.addObject("msg","DetailCommande invalide");
			model.addObject("detailcommande",detailcommande);
			loadDefault(model);
			return model;
	   }
		service.edit(detailcommande);
		return new ModelAndView("redirect:/detailcommande/list");
	}
	
	@RequestMapping(value="/detailcommande/list", method=RequestMethod.GET)
	public ModelAndView list(){
		final List<DetailCommande> listDetailCommande = service.list();
		ModelAndView model = new ModelAndView("listDetailCommande");
		model.addObject("listDetailCommande", listDetailCommande);
		return model;
	}
	
	@RequestMapping(value="/detailcommande/{id}/delete", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id")final int id){
		service.delete(id);
		return new ModelAndView("redirect:/detailcommande/list");
	}
	
	@RequestMapping(value="/detailcommande/{id}", method=RequestMethod.GET)
	public ModelAndView get(@PathVariable("id")final int id){
		ModelAndView model = new ModelAndView("detailcommande");
		DetailCommande detailcommande = service.get(id);
		if(detailcommande == null){
			model.addObject("msg","DetailCommande introuvable");
			model.addObject("css","danger");
			return model;
		}
		model.addObject("detailcommande",detailcommande);
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

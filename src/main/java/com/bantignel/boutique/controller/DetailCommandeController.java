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

import com.bantignel.boutique.model.DetailCommande;
import com.bantignel.boutique.service.DetailCommandeService;


@Controller
//@RequestMapping("/detailCommande")
public class DetailCommandeController {
	@Autowired
	private DetailCommandeService service;
	
	@RequestMapping(value="/detailCommande/new",method=RequestMethod.GET)
	public ModelAndView add(){
		ModelAndView model = new ModelAndView("addDetailCommande");
		model.addObject("detailCommande", new DetailCommande());
		loadDefault(model);
		return model;
	}
	
	@RequestMapping(value="/detailCommande/add", method=RequestMethod.POST)
	public ModelAndView add(@Valid @ModelAttribute("detailCommande") final DetailCommande detailCommande, BindingResult result){
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("addDetailCommande");
			model.addObject("msg","DetailCommande invalide");
			model.addObject("detailCommande",detailCommande);
			loadDefault(model);
			return model;
	   }
		service.add(detailCommande);
		ModelAndView model = new ModelAndView("detailCommande");
		model.addObject("css","success");
		model.addObject("action","add");
		model.addObject("msg","DetailCommande ajouté avec succès");
		return  model;
	}
	
	@RequestMapping(value="/detailCommande/{id}/edit", method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id")final int id){
		DetailCommande detailCommande = service.get(id);
		ModelAndView model = new ModelAndView("editDetailCommande");
		loadDefault(model);
		model.addObject("detailCommande",detailCommande);
		return model;
	}
	
	@RequestMapping(value="/detailCommande/edit", method=RequestMethod.POST)
	public ModelAndView edit(@Valid @ModelAttribute("detailCommande") final DetailCommande detailCommande, BindingResult result){
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("editDetailCommande");
			model.addObject("msg","DetailCommande invalide");
			model.addObject("detailCommande",detailCommande);
			loadDefault(model);
			return model;
	   }
		service.edit(detailCommande);
		ModelAndView model = new ModelAndView("detailCommande");
		model.addObject("css","success");
		model.addObject("action","update");
		model.addObject("msg","DetailCommande modifié avec succès");
		return  model;
	}
	
	@RequestMapping(value="/detailCommande/list", method=RequestMethod.GET)
	public ModelAndView list(){
		final List<DetailCommande> listDetailCommande = service.list();
		ModelAndView model = new ModelAndView("listDetailCommande");
		model.addObject("listDetailCommande", listDetailCommande);
		return model;
	}
	
	@RequestMapping(value="/detailCommande/{id}/delete", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id")final int id){
		service.delete(id);
		return new ModelAndView("redirect:/detailCommande/list");
	}
	
	@RequestMapping(value="/detailCommande/{id}", method=RequestMethod.GET)
	public ModelAndView get(@PathVariable("id")final int id){
		ModelAndView model = new ModelAndView("detailCommande");
		DetailCommande detailCommande = service.get(id);
		if(detailCommande == null){
			model.addObject("detailCommande",detailCommande);
			model.addObject("css","danger");
			model.addObject("action","update");
			model.addObject("msg","DetailCommande introuvable");
			return  model;
		}
		model.addObject("detailCommande",detailCommande);
		model.addObject("css","success");
		model.addObject("action","update");
		model.addObject("msg","DetailCommande trouvé avec succès");
		return  model;
	}
	
	public void loadDefault(ModelAndView model){
		
	}
}

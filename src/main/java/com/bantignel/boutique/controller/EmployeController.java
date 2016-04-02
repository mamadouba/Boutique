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

import com.bantignel.boutique.model.Employe;
import com.bantignel.boutique.service.EmployeService;


@Controller
//@RequestMapping("/employe")
public class EmployeController {
	@Autowired
	private EmployeService service;
	
	@RequestMapping(value="/employe/new",method=RequestMethod.GET)
	public ModelAndView add(){
		ModelAndView model = new ModelAndView("addEmploye");
		model.addObject("employe", new Employe());
		loadDefault(model);
		return model;
	}
	
	@RequestMapping(value="/employe/add", method=RequestMethod.POST)
	public ModelAndView add(@Valid @ModelAttribute("employe") final Employe employe, BindingResult result){
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("addEmploye");
			model.addObject("msg","Employe invalide");
			model.addObject("employe",employe);
			loadDefault(model);
			return model;
	   }
		service.add(employe);
		return new ModelAndView("redirect:/employe/list");
	}
	
	@RequestMapping(value="/employe/{id}/edit", method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id")final int id){
		Employe employe = service.get(id);
		ModelAndView model = new ModelAndView("editEmploye");
		loadDefault(model);
		model.addObject("employe",employe);
		return model;
	}
	
	@RequestMapping(value="/employe/edit", method=RequestMethod.POST)
	public ModelAndView edit(@Valid @ModelAttribute("employe") final Employe employe, BindingResult result){
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("editEmploye");
			model.addObject("msg","Employe invalide");
			model.addObject("employe",employe);
			loadDefault(model);
			return model;
	   }
		service.edit(employe);
		return new ModelAndView("redirect:/employe/list");
	}
	
	@RequestMapping(value="/employe/list", method=RequestMethod.GET)
	public ModelAndView list(){
		final List<Employe> listEmploye = service.list();
		ModelAndView model = new ModelAndView("listEmploye");
		model.addObject("listEmploye", listEmploye);
		return model;
	}
	
	@RequestMapping(value="/employe/{id}/delete", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id")final int id){
		service.delete(id);
		return new ModelAndView("redirect:/employe/list");
	}
	
	@RequestMapping(value="/employe/{id}", method=RequestMethod.GET)
	public ModelAndView get(@PathVariable("id")final int id){
		ModelAndView model = new ModelAndView("employe");
		Employe employe = service.get(id);
		if(employe == null){
			model.addObject("msg","Employe introuvable");
			model.addObject("css","danger");
			return model;
		}
		model.addObject("employe",employe);
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

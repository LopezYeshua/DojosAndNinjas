package com.yeshua.dojos.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yeshua.dojos.models.Dojo;
import com.yeshua.dojos.services.DojoServices;
import com.yeshua.dojos.services.NinjaServices;

@Controller
@RequestMapping("/dojos")
public class DojoController {
	@Autowired
	DojoServices dojoService;
	
	@Autowired
	NinjaServices ninjaService;
	
	@GetMapping("")
	public String index(@ModelAttribute("dojo") Dojo dojo, @ModelAttribute("dojos") ArrayList<Dojo> dojos) {
		dojos.addAll((ArrayList<Dojo>) dojoService.allDojos());
		return "index.jsp";
	}
	
	@PostMapping("")
	public String create(@Valid @ModelAttribute("dojo") Dojo dojo, @ModelAttribute("dojos") ArrayList<Dojo> dojos, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/dojos";
		}
	}
	
	@GetMapping("/show/{id}")
	public String show(Model model, @PathVariable(value="id") Long id) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
		System.out.println(dojo.getNinjas());
		return "show.jsp";
	}
}

package com.yeshua.dojos.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yeshua.dojos.models.Dojo;
import com.yeshua.dojos.models.Ninja;
import com.yeshua.dojos.services.DojoServices;
import com.yeshua.dojos.services.NinjaServices;

@Controller
@RequestMapping("/ninjas")
public class NInjaController {
	@Autowired
	DojoServices dojoService;
	
	@Autowired
	NinjaServices ninjaService;
	
	@GetMapping("")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, @ModelAttribute("dojos") ArrayList<Dojo> dojos) {
		dojos.addAll((ArrayList<Dojo>) dojoService.allDojos());
		return "newNinja.jsp";
	}
	
	@PostMapping("")
	public String create(@Valid @ModelAttribute("ninja") Ninja ninja, @ModelAttribute("ninjas") ArrayList<Ninja> ninjas, BindingResult result) {
		if (result.hasErrors()) {
			return "newNinja.jsp";
		} else {
			ninjaService.createNinja(ninja);
			return "redirect:/dojos";
		}
	}
}

package com.yeshua.dojos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yeshua.dojos.models.Dojo;
import com.yeshua.dojos.repositories.DojoRepository;

@Service
public class DojoServices {
	@Autowired
	DojoRepository dojoRepository;
	
	public DojoServices(DojoRepository dojoRespository) {
		this.dojoRepository = dojoRespository;
	}
	
	public List<Dojo> allDojos() {
		return dojoRepository.findAll();
	}
	
	public Dojo createDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	
//	Find dojo by id
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
}

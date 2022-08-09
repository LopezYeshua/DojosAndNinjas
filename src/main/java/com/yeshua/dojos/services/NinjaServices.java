package com.yeshua.dojos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yeshua.dojos.models.Ninja;
import com.yeshua.dojos.repositories.NinjaRepository;

@Service
public class NinjaServices {
	@Autowired
	NinjaRepository ninjaRepository;
	
	public NinjaServices(NinjaRepository ninjaRespository) {
		this.ninjaRepository = ninjaRespository;
	}
	
	public List<Ninja> allNinjas() {
		return ninjaRepository.findAll();
	}
	
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
	
//	Find ninja by id
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		if (optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
}

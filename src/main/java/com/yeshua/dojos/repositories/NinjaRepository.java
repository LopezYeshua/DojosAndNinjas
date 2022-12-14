package com.yeshua.dojos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.yeshua.dojos.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long>{
	List <Ninja> findAll();
	List<Ninja> findByFirstNameContaining(String search);
}

package com.yujiyamamoto64.peoplecrud.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yujiyamamoto64.peoplecrud.models.Person;
import com.yujiyamamoto64.peoplecrud.services.PersonService;

@RestController
@RequestMapping(value = "/people")
public class PersonResource {

	@Autowired
	private PersonService service;
	
	@GetMapping
	public ResponseEntity<List<Person>> findAll() {
		List<Person> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Person> insert(@RequestBody Person obj) {
		obj = service.insert(obj);
		return ResponseEntity.ok().body(obj);
	}

	
}

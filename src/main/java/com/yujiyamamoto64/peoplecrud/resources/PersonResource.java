package com.yujiyamamoto64.peoplecrud.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PostMapping
	public ResponseEntity<Person> insert(@RequestBody Person obj) {
		obj = service.insert(obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Person>> findAll() {
		List<Person> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Person obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Person obj,
			@PathVariable Integer id) {
		obj.setId(id);
		service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{id}/maddress")
	public String mainAddressById(@PathVariable Integer id) {
		return service.maindAddressById(id);
	}
}

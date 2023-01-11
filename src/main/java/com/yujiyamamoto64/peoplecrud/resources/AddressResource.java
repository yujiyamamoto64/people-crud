package com.yujiyamamoto64.peoplecrud.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.yujiyamamoto64.peoplecrud.models.Address;
import com.yujiyamamoto64.peoplecrud.services.AddressService;

@RestController
@RequestMapping(value = "/address")
public class AddressResource {

	@Autowired
	private AddressService service;
	
	@GetMapping
	public ResponseEntity<List<Address>> findAll() {
		List<Address> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	
	@PostMapping
	public ResponseEntity<Address> insert(@RequestBody Address address) {
		address = service.insert(address);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(address.getId())
				.toUri();
		return ResponseEntity.ok().body(address);
	}

	
}

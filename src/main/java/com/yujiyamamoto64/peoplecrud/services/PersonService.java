package com.yujiyamamoto64.peoplecrud.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yujiyamamoto64.peoplecrud.models.Address;
import com.yujiyamamoto64.peoplecrud.models.Person;
import com.yujiyamamoto64.peoplecrud.repositories.AddressRepository;
import com.yujiyamamoto64.peoplecrud.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repo;

	@Autowired
	private AddressRepository addressRepo;

	public Optional<Person> findById(Integer id) {
		Optional<Person> obj = repo.findById(id);
		return obj;
	}

	public Person insert(Person obj) {
		obj = repo.save(obj);
		for(Address address : obj.getAddressList()) {
			address.setPerson(obj);
		}
		addressRepo.saveAll(obj.getAddressList());
		return obj;
	}
	
	public List<Person> findAll() {
		return repo.findAll();
	}
	
}
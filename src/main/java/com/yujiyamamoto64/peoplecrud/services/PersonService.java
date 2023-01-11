package com.yujiyamamoto64.peoplecrud.services;

import java.util.List;

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
	
	public Person findById(Integer id) {
		Person obj = repo.findById(id).get();
		return obj;
	}
	
	public Person update(Person newObj) {
		Person oldObj = findById(newObj.getId());
		updateData(oldObj, newObj);
		return repo.save(oldObj);
	}
	
	private void updateData(Person oldObj, Person newObj) {
		oldObj.setName(newObj.getName());
		oldObj.setBirthDate(newObj.getBirthDate());
		
		for (Address address : oldObj.getAddressList()) {
			address.setPerson(null);
		}
		for (Address address : newObj.getAddressList()) {
			address.setPerson(oldObj);
		}
		oldObj.setAddressList(newObj.getAddressList());
	}
	
	public String maindAddressById(Integer id) {
		Person obj = repo.findById(id).get();
		Address address = obj.getAddressList().get(0);
		return "O principal endereço dessa pessoa é: " + address.toString();
	}
}
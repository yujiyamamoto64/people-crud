package com.yujiyamamoto64.peoplecrud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yujiyamamoto64.peoplecrud.models.Address;
import com.yujiyamamoto64.peoplecrud.repositories.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepo;

	public Address insert(Address address) {
		address = addressRepo.save(address);
		return address;
	}
	
	public List<Address> findAll() {
		return addressRepo.findAll();
	}
	
}
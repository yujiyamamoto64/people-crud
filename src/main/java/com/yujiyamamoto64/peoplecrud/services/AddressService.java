package com.yujiyamamoto64.peoplecrud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yujiyamamoto64.peoplecrud.models.Address;
import com.yujiyamamoto64.peoplecrud.repositories.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository repo;
	
	public List<Address> findAll() {
		return repo.findAll();
	}
	
	
	
}
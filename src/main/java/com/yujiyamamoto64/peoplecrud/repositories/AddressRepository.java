package com.yujiyamamoto64.peoplecrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yujiyamamoto64.peoplecrud.models.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}

package com.yujiyamamoto64.peoplecrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yujiyamamoto64.peoplecrud.models.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

}

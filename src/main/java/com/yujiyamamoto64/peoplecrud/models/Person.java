package com.yujiyamamoto64.peoplecrud.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Person implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	private List<Address> addressList = new ArrayList<>();
	
	public Person() {
	}
	
	public Person(Integer id, String name, List<Address> addressList) {
		super();
		this.id = id;
		this.name = name;
		this.addressList = addressList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", addressList=" + addressList + "]";
	}
	
	
}

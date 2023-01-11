package com.yujiyamamoto64.peoplecrud.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.yujiyamamoto64.peoplecrud.models.Address;

public class PersonNewDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Date birthDate;
	private List<Address> addressList;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public List<Address> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}
}

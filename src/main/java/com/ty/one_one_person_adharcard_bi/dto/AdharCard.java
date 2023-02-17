package com.ty.one_one_person_adharcard_bi.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AdharCard {
	
	@Id
	private int id;
	private String name;
	private String address;
	
	@OneToOne(mappedBy = "adharCard")
	private Person person;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "AdharCard [id=" + id + ", name=" + name + ", address=" + address +  "]";
	}
	
	

}

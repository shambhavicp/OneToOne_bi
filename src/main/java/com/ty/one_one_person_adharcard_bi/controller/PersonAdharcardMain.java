package com.ty.one_one_person_adharcard_bi.controller;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.one_one_person_adharcard_bi.dao.PersonCRUD;
import com.ty.one_one_person_adharcard_bi.dto.AdharCard;
import com.ty.one_one_person_adharcard_bi.dto.Person;

public class PersonAdharcardMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Person person=new Person();
		person.setId(2);
		person.setName("tom");
		person.setAddress("BLR");
		person.setPhone(23495678);
		
		
		AdharCard adharCard=new AdharCard();
		
		adharCard.setId(1001);
		adharCard.setName("Tom");
		adharCard.setAddress("India");
		
		adharCard.setPerson(person);
		person.setAdharCard(adharCard);
		
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		PersonCRUD crud=new PersonCRUD();
		crud.savePerson(person);
//		entityTransaction.begin();
		
	//	entityManager.persist(person);
		
//		entityManager.persist(adharCard);
//		Person person=entityManager.find(Person.class, 1);
//		System.out.println(person);
//		
		
//		entityTransaction.commit();
	}

}

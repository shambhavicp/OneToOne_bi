package com.ty.one_one_person_adharcard_bi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.one_one_person_adharcard_bi.dto.AdharCard;
import com.ty.one_one_person_adharcard_bi.dto.Person;

public class PersonCRUD {
	
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
		
	}
	
	public void savePerson(Person person) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		AdharCard adharCard = person.getAdharCard();
		entityTransaction.begin();
		
		entityManager.persist(person);
		
		entityTransaction.commit();
	}
	
	public void updatePerson(int id, Person person) {
		
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Person person2=entityManager.find(Person.class, id);
		if(person2!=null) {
			person.setId(id);
			person.setName(person.getName());
			
			entityTransaction.begin();
			entityManager.merge(person);
			entityTransaction.commit();
			
		}
		
		else {
			System.out.println("id not present");
		}
	}
	
	public void deletePerson(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Person person=entityManager.find(Person.class, id);
		
		if(person!=null) {
		entityTransaction.begin();
		AdharCard adharCard=person.getAdharCard();
		
		entityManager.remove(adharCard);
		entityManager.remove(person);
		
		entityTransaction.commit();
		System.out.println("deleted Successfully");
		}
		else {
			 System.out.println("the id is not present");
		}
		
		
	}
	
	
	public Person getPersonById(int id) {
		EntityManager entityManager=getEntityManager();
		Person person=entityManager.find(Person.class, id);
		return person;
		
	}
	
	public List<Person> getAllPerson(){
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select p from Person p");
		List<Person> list=query.getResultList();
		return list;
	}


}

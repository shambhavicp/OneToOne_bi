package com.ty.one_one_person_adharcard_bi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.one_one_person_adharcard_bi.dto.AdharCard;
import com.ty.one_one_person_adharcard_bi.dto.Person;

public class AdharCardCRUD {
	
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
		
	}
	
	public void saveAdharCard(AdharCard adharCard) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Person person = adharCard.getPerson();
		entityTransaction.begin();
		
		entityManager.persist(adharCard);
		
		
		entityTransaction.commit();
	}
	
	public void updateAdharCard(int id, AdharCard adharCard) {
		
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		AdharCard adharCard1=entityManager.find(AdharCard.class, id);
		if(adharCard1!=null) {
			adharCard.setId(id);
			adharCard.setName(adharCard.getName());
			
			entityTransaction.begin();
			entityManager.merge(adharCard);
			
			entityTransaction.commit();
			
		}
		
		else {
			System.out.println("id not present");
		}
	}
	
	public void deleteAdharCard(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		AdharCard adharCard=entityManager.find(AdharCard.class, id);
		
		if(adharCard!=null) {
		entityTransaction.begin();
		
		entityManager.remove(adharCard);
		
		entityTransaction.commit();
		System.out.println("deleted Successfully");
		}
		else {
			 System.out.println("the id is not present");
		}
		
		
	}
	
	
	public AdharCard getAdharCardById(int id) {
		EntityManager entityManager=getEntityManager();
		AdharCard adharCard=entityManager.find(AdharCard.class, id);
		return adharCard;
		
	}
	
	public List<AdharCard> getAllAdharCard(){
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select a from AdharCard a");
		List<AdharCard> list=query.getResultList();
		return list;
	}


}

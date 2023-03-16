package com.jsp.hibernate_crud_dto_dao_service_controller.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.hibernate_crud_dto_dao_service_controller.dto.College;

public class CollegeDao {

	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("ansari");
	
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	
	public void saveCollege(College college) {
		
		
		entityTransaction.begin();
		entityManager.persist(college);
		entityTransaction.commit();
		
	}
	
	public College getByCollegeId(int collegeId) {
		
		College college=entityManager.find(College.class, collegeId);
		
		return college;
	}
	
	/*
	 * Delete Method
	 */
	public void deleteCollegeById(int collegeId) {
		
		College college=entityManager.find(College.class, collegeId);
		
		entityTransaction.begin();
		entityManager.remove(college);
		entityTransaction.commit();
	}
	
	/*
	 * updateMethod
	 */
	
	public void updateCollegeById(int collegeId,String collegeName,String collegeAddress) {
		
		College college=getByCollegeId(collegeId);
		
		if(college!=null) {
			
			college.setCollegeName(collegeName);
			college.setCollegeAddress(collegeAddress);
			
			entityTransaction.begin();
			entityManager.merge(college);
			entityTransaction.commit();
		}
	}
	
	/*
	 * displayMethod
	 * 
	 */
	public List<College> displayAllCollege() {
		
		String displayCollegeQuery = "SELECT c FROM College c";
		
		Query query=entityManager.createQuery(displayCollegeQuery);
		
		//List<College> colleges= query.getResultList();
		
		//return colleges;
		
		return query.getResultList();
		
		//return entityManager.createQuery(displayCollegeQuery).getResultList();
	}
}

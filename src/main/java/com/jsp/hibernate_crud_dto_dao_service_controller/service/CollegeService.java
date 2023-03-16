package com.jsp.hibernate_crud_dto_dao_service_controller.service;

import java.util.List;

import com.jsp.hibernate_crud_dto_dao_service_controller.dao.CollegeDao;
import com.jsp.hibernate_crud_dto_dao_service_controller.dto.College;

public class CollegeService {

	CollegeDao collegeDao = new CollegeDao();

	public void saveCollege(College college) {

		collegeDao.saveCollege(college);
	}

	public College getByCollegeId(int collegeId) {

		College college=collegeDao.getByCollegeId(collegeId);
		
		if(college!=null) {
			return collegeDao.getByCollegeId(collegeId);
		}else {
			System.out.println("Id is not present");
			return null;
		}
	}
	
	public void deleteCollegeById(int collegeId) {
		
		//College college = collegeDao.getByCollegeId(collegeId);
		
		if(collegeDao.getByCollegeId(collegeId).getCollegeId()==collegeId) {
			collegeDao.deleteCollegeById(collegeId);
			System.out.println("Data-Deleted");
		}else {
			System.out.println("Id is not present");
		}
	}
	
	public void updateCollegeById(int collegeId,String collegeName,String collegeAddress) {
		
		
		collegeDao.updateCollegeById(collegeId, collegeName, collegeAddress);
	}
	
	public List<College> displayAllCollege() {
		
		return collegeDao.displayAllCollege();
	}
}

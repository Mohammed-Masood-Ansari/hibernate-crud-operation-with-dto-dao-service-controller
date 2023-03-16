package com.jsp.hibernate_crud_dto_dao_service_controller.controller;

import java.util.List;
import java.util.Scanner;

import com.jsp.hibernate_crud_dto_dao_service_controller.dto.College;
import com.jsp.hibernate_crud_dto_dao_service_controller.service.CollegeService;

public class CollegeController {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		CollegeService collegeService = new CollegeService();

		College college = new College();

		while (true) {

			System.out.println("1.Insert\n2.getCollegeById\n3.DeleteCollegeById\n4.updateCollegeById\n5.displayAllCollege");
			System.out.println("Enter Your choice");
			int ch = scanner.nextInt();

			switch (ch) {
			case 1: {

				System.out.println("Enter the collegeId");

				college.setCollegeId(scanner.nextInt());

				System.out.println("Enter the collegeName");

				college.setCollegeName(scanner.next());

				System.out.println("Enter the collegeAddress");

				college.setCollegeAddress(scanner.next());

				System.out.println("Enter the collegeType");

				college.setCollegeType(scanner.next());

				collegeService.saveCollege(college);
			}
				break;

			case 2: {
				System.out.println("Enter the collegeId");

				College college1=collegeService.getByCollegeId(scanner.nextInt());
				
				if(college1!=null) {
					System.out.println("collegeId = "+college1.getCollegeId());
					System.out.println("collegeAddress = "+college1.getCollegeAddress());
					System.out.println("collegeName = "+college1.getCollegeName());
					System.out.println("collegeType = "+college1.getCollegeType());
				}
				
			}
				break;
				
			case 3:{
				
				System.out.println("Enter the collegeId to delete Data");
				
				collegeService.deleteCollegeById(scanner.nextInt());
				
			}break;
			
			case 4:{
				
				System.out.println("Enter the collegeId");

				int id = scanner.nextInt();
				
				System.out.println("Enter the collegeName");

				String name = scanner.nextLine();
				
				name+=scanner.next();

				System.out.println("Enter the collegeAddress");
				
				String address = scanner.next();
				
				collegeService.updateCollegeById(id, name, address);

				
			}break;
			
			case 5:{
				
					//List<College> colleges=collegeService.displayAllCollege();
					
					System.out.println("...............College-Details...............");
					for (College college2 : collegeService.displayAllCollege()) {
						
						System.out.println("collegeId = "+college2.getCollegeId());
						System.out.println("collegeName = "+college2.getCollegeName());
						System.out.println("collegeAddress = "+college2.getCollegeAddress());
						System.out.println("collegeType = "+college2.getCollegeType());
						
						System.out.println("....................................................");
					}
					
			}break;
			default:
				throw new IllegalArgumentException("Unexpected value: ");
			}
		}
	}
}

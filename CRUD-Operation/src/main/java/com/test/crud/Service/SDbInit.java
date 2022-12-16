package com.test.crud.Service;

import org.springframework.context.annotation.Configuration;

import com.test.crud.model.Student;
import com.test.crud.repository.StudentRepo;

import jakarta.annotation.PostConstruct;

@Configuration //when i use java base configuration its indicate that class can be use by IOC Container. 
public class SDbInit {
	
	//ConstructionBase auto wired
	private final StudentRepo studentRepo;
	public SDbInit(StudentRepo studentRepo) {
		this.studentRepo = studentRepo;
	}
	
	//PostConstruct for run at runtime
//	@PostConstruct
	public void init() {
		Student student = new Student();
		student.setStuName("Marup");
		student.setDeptName("CSE");
		student = studentRepo.save(student);
		System.out.println("S ID = "+student.getStuid());
	}
	
	
	
	

}

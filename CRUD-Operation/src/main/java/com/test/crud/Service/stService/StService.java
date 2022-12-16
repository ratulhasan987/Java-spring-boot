package com.test.crud.Service.stService;

import java.util.List;

import com.test.crud.model.Student;

public interface StService {
	//Abstract Method: it's a method that has just the method definition but does not contain implementation.
	//return type will same with className 
	Student save(Student student);//for instance save
	Student update(Student student);//for update
	void delete(Long id);//for delete 
	Student get(Long id);//for get
	List<Student>getAll();//for get all
	
}

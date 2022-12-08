package com.test.crud.Service;

import java.util.List;

import org.springframework.stereotype.Service;

//import com.example.demo.modell.Employee;
import com.test.crud.Service.stService.StService;
import com.test.crud.model.Student;
import com.test.crud.repository.StudentRepo;
@Service
public class StudentServiceImplemantion implements StService {
	
	//Constructor Base Auto wired
	private final StudentRepo studentRepo;
	public StudentServiceImplemantion(StudentRepo studentRepo) {
		this.studentRepo = studentRepo;// not clear
	}

	@Override
	public Student save(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public Student update(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public void delete(Long id) {
		// Instance              for optional return to get()
	Student student = studentRepo.findById(id).get();
		if(student==null) {
			return;
		}
		studentRepo.delete(student);
		
	}

	@Override
	public Student get(Long id) {
		Student student = studentRepo.findById(id).get();
		return student;
	}

	@Override
	public List<Student> getAll() {
		List<Student> studentList = studentRepo.findAll();
		return studentList;
	}

}

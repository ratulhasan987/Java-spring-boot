package com.test.crud.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.example.demo.modell.Employee;
import com.test.crud.Service.stService.StService;
import com.test.crud.annotations.ApiController;
import com.test.crud.model.Student;

@ApiController
@RequestMapping("/student")
public class StuController {
	//Auto wired
	private final StService stService;
	public StuController(StService stService) {
		this.stService = stService;
	}
	
	@PostMapping("/create")
	public Student save( @RequestBody Student student) {
		return stService.save(student);
	}
	@PutMapping("/update")
	public Student update(@RequestBody Student student) {
		return stService.update(student);
	}
	

	@DeleteMapping("/{id}")//for delete
	public void delete(@PathVariable("id") Long id) {
		stService.delete(id);
	}
	
	@GetMapping("/{id}")//for get
	public Student save(@PathVariable("id") Long id) {
		return stService.get(id);
	}
	
	@GetMapping("/all")//for getAll
	public   List<Student> getAll() {
		return stService.getAll();
	}
	

}

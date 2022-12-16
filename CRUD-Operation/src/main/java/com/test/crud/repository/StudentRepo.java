package com.test.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.crud.model.Student;
@Repository                                      //class   DataType
public interface StudentRepo extends JpaRepository<Student, Long> {

}

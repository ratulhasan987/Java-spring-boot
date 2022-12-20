package com.etodb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etodb.model.ExcelModel;
@Repository
public interface ExcelRepo extends JpaRepository<ExcelModel, Integer> {

}

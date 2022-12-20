 package com.etodb.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.etodb.model.ExcelModel;
import com.etodb.service.StService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("excel")
public class ExcelController {
	@Autowired
	private StService stService;
	@PostMapping("/save&upload")
	public ResponseEntity<?> uploaEntity(@RequestParam("file")MultipartFile file) throws IllegalStateException, IOException{
		this.stService.saveFileEtoDB(file);
		this.stService.upload(file);
		return ResponseEntity.ok(Map.of("Massage", "All Data Saved and Uploaded Successfully")); 
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<ExcelModel>> getEntity(){
		return new ResponseEntity<>(stService.getExcelModels(),HttpStatus.FOUND);
	}
	
	
	
//	@PostMapping("/upload")
//	public String upload(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
//	stService.upload(file);
//	return "File uploaded and Insert Done";}


}

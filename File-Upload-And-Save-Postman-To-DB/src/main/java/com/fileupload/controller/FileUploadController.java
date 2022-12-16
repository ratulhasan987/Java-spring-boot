package com.fileupload.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fileupload.service.FileUploadService;

@RestController
public class FileUploadController {
	
	
	@Autowired
	private FileUploadService fileservice;
	
	@PostMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
	fileservice.upload(file);
	
	
	return "File uploaded and Insert Done";

	}


}

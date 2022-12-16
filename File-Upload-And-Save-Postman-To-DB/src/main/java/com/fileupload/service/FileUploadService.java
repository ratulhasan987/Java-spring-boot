package com.fileupload.service;

import java.io.File;
import java.io.IOException;
import java.security.PublicKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fileupload.model.FileModel;
import com.fileupload.repository.FileRepo;

@Service
public class FileUploadService {
	
	
	@Value("${file.upload-dir}")
	private String Uname;
		
	
	@Autowired
	private FileRepo repo;
	
	public void upload(MultipartFile file) throws IllegalStateException, IOException {
	file.transferTo(new File(Uname + file.getOriginalFilename()));
	
	FileModel fileModel = new FileModel();
	fileModel.setName(file.getOriginalFilename());
	repo.save(fileModel);
	
//	FileModel fileModel2 = new FileModel();
//	fileModel.setDirectory(file.getOriginalFilename());
//	repo.save(fileModel2);

	}

}

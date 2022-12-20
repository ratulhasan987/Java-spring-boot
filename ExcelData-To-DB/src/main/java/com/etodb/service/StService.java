package com.etodb.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.etodb.model.ExcelModel;
import com.etodb.repository.ExcelRepo;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StService {
	
	@Autowired
	private ExcelRepo repo;
	
	public void saveFileEtoDB(MultipartFile file) {
		if (ExcelSevice.isValidExcelFile(file)) {
			try {
				List<ExcelModel> excelModels = ExcelSevice.getExcelModels(file.getInputStream());
				this.repo.saveAll(excelModels);
			} catch (IOException e) {  
				throw new IllegalArgumentException("Not Valid");
//				e.printStackTrace();
			}
			
		}
		
	}
	
	public List<ExcelModel>getExcelModels(){
		return repo.findAll();
	}
	
	
	@Value("${file.upload-dir}")
	private String Uname;
		
	public void upload(MultipartFile file) throws IllegalStateException, IOException {
	file.transferTo(new File(Uname + file.getOriginalFilename()));
	
	}

}

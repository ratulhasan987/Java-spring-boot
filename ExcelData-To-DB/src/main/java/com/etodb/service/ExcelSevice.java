package com.etodb.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.etodb.model.ExcelModel;

public class ExcelSevice {
	
	static String mString ="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	// for check true or false
	public static boolean isValidExcelFile(MultipartFile file) {
		System.out.println(mString.equals(file.getContentType()));
		return mString.equals(file.getContentType());
//		return Objects.equals(file.getContentType(),"applocation/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	}

	
	 //@SuppressWarnings("unchecked")
	public static List<ExcelModel> getExcelModels(InputStream inputStream){
		 List<ExcelModel> excelModels = new ArrayList<>();
		 
//		 XSSFWorkbook workbook = null;
		 
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = workbook.getSheet("Data");
			
			int rowIndex = 0;
			for(Row row: sheet) {
				if(rowIndex == 0) {
					rowIndex++;
					continue;
				}
//An iterator over a collection. Iterator takes the place of Enumeration in the Java Collections Framework.
				Iterator<Cell> celIterator = row.iterator();
				int cellIndex = 0;
				ExcelModel excelModel = new ExcelModel();
				
				while (celIterator.hasNext())// return true if the iteration has more elements
				{
					Cell cell = celIterator.next();//Returns the next element in the iteration.
					switch(cellIndex)//The switch expression is evaluated once. The value of the expression is compared with the values of each case.
					{
//					case 0: excelModel.setId((int) cell.getNumericCellValue());
					case 0: excelModel.setName(cell.getStringCellValue());
					case 1: excelModel.setDept(cell.getStringCellValue());
					case 2: excelModel.setGender(cell.getStringCellValue());
					case 3: excelModel.setLocation(cell.getStringCellValue());
					default:{}
					}
					cellIndex ++;
				}
				excelModels.add(excelModel);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return excelModels;
	 
	 }
}

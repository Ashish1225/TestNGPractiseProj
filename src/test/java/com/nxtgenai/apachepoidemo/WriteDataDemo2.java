package com.nxtgenai.apachepoidemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataDemo2 {

	public static void main(String[] args) {
		
		// create workbook object
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		//create a sheet inside workbook
		XSSFSheet sheet = workbook.createSheet("MySheet");
		
		Object[][] data = {
				{"FirstName","Location","Experience"},
				{"Ashish","Firozabad",3},
				{"Mangal","Delhi",4},
				{"Praveen","Banaras",4},
				{"Sanjay","Gazipur",4},
				{"Bhupendra","Ghaiabad",3}
		};
		
		int rows = data.length;
		System.out.println(rows);
		
		int columns = data[0].length;
		System.out.println(columns);
		
		for(int r=0;r<rows;r++) {
			// creating row
			XSSFRow row = sheet.createRow(r);
			
			for(int c=0;c<columns;c++) {
				// creating cell
				XSSFCell cell = row.createCell(c);
				
				 Object cellValue = data[r][c];
				 if(cellValue instanceof String) {
					 cell.setCellValue((String)cellValue);
				 }
				 else if(cellValue instanceof Integer) {
					 cell.setCellValue((Integer)cellValue);
				 }
				 else if(cellValue instanceof Boolean) {
					 cell.setCellValue((Boolean)cellValue);
				 }				
			}
		}
		
		File file = new File("C:\\Users\\ashu2\\OneDrive\\Desktop\\dataset\\writeData.xlsx");
		try {
			FileOutputStream fos = new FileOutputStream(file);
			workbook.write(fos);
			workbook.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}

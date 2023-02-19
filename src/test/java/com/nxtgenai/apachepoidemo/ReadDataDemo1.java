package com.nxtgenai.apachepoidemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// reading data from excel using poi and for loop

public class ReadDataDemo1 {

	public static void main(String[] args) {
		
		String fileName = "C:\\Users\\ashu2\\OneDrive\\Desktop\\dataset\\employees.xlsx";
		
		//create a file object
		File file = new File(fileName);
		
		// read the file
		try {
			FileInputStream fis = new FileInputStream(file);
			try {
				XSSFWorkbook workbook = new XSSFWorkbook(fis);
				XSSFSheet sheet = workbook.getSheet("NameList");
				
				int ttlRows = sheet.getLastRowNum()+1;
				System.out.println(ttlRows);
				
				int ttlCells=sheet.getRow(0).getLastCellNum();
				System.out.println(ttlCells);
				
				for(int r = 1;r<ttlRows; r++) {
					XSSFRow row = sheet.getRow(r);
					
					for(int c=0;c<ttlCells;c++) {
						XSSFCell cell = row.getCell(c);
						CellType cellType = cell.getCellType();
						
						switch (cellType) {
						case STRING:
							System.out.print(cell.getStringCellValue());
							break;
						case NUMERIC:
							System.out.print(cell.getNumericCellValue());
							break;
						case BOOLEAN:
							System.out.print(cell.getBooleanCellValue());
							break;

						default:
							System.out.print(cell.getStringCellValue());
							break;
						}
						System.out.print("  ");
						
					}
					System.out.println();
					
				}
				workbook.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}

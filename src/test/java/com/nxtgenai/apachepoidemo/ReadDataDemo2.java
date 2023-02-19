package com.nxtgenai.apachepoidemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// reading data from excel using poi and using iterator

public class ReadDataDemo2 {

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
				
				Iterator<Row> itrRow = sheet.iterator();
				while(itrRow.hasNext()) {
					Row row = itrRow.next();
					Iterator<Cell> itrCell = row.cellIterator();
					//Iterator<Cell> itrCell = row.iterator(); -- both are same
					while(itrCell.hasNext()) {
						Cell cell = itrCell.next();
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

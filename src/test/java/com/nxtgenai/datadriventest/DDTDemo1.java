package com.nxtgenai.datadriventest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DDTDemo1 {
	
	// Reading data from excel
	public static void main(String[] args) {
		String path = "C:\\Users\\ashu2\\OneDrive\\Desktop\\dataset\\logincred.xlsx";
		
		File file = new File(path);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		XSSFWorkbook workbook=null;
		try {
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		// get the total rows
		int ttlRows = sheet.getLastRowNum()+1;
		System.out.println("Total rows :"+ttlRows);
		
		// get the total columns
		int ttlCells = sheet.getRow(0).getLastCellNum();
		System.out.println("Total cells :"+ttlCells);
		
		for(int r=1;r<ttlRows;r++) {
			XSSFRow row = sheet.getRow(r);
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.saucedemo.com/");
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(row.getCell(0).toString());
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(row.getCell(1).toString());
			System.out.println(row.getCell(0).toString());
			System.out.println(row.getCell(1).toString());
			driver.findElement(By.xpath("//input[@id='login-button']")).click();
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(!driver.findElements(By.xpath("//h3[contains(text(),'Epic sadface: Sorry, this user has been locked out')]")).isEmpty()) {
				System.out.println("Not logged in successfully..");
			}
			if(!driver.findElements(By.xpath("//span[@class='title']")).isEmpty()) {
				System.out.println("Logged in successfully");
			}
			if(!driver.findElements(By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match a')]")).isEmpty()) {
				System.out.println("Invalid Credentials");
			}
			driver.quit();
			/*
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
				System.out.print(" ");
			}
			*/
		}
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

}

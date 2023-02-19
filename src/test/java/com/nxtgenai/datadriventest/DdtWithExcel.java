package com.nxtgenai.datadriventest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

// login with multiple credentials using apache poi and data provider with excel

public class DdtWithExcel {
	WebDriver driver;
	
	@BeforeMethod
	public void launchApplicaion() {
		driver = new ChromeDriver();
		driver.get("http://www.tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void closeApplication() {
		
		driver.quit();
	}
	
	@Test(dataProvider ="Supplier" )
	public void loginApp(String userName, String password) {
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		try {
			Thread.sleep(3000);
			Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Edit your account information']")).isDisplayed());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
	
	// DataProvider is taking data from excel
	
	@DataProvider(name = "Supplier")
	public Object[][] dataSupplier() {
		String fileName = "C:\\Users\\ashu2\\OneDrive\\Desktop\\dataset\\tutorialsninja.xlsx";
	
		//create a file object
		File file = new File(fileName);
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		XSSFWorkbook workbook = null;		
		try {
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheet("mysheet");
		
		int ttlrows = sheet.getLastRowNum()+1;
		System.out.println("Total numbers of rows :"+ttlrows);
		int ttlcolumns = sheet.getRow(1).getLastCellNum();
		System.out.println("Total numbers of Columns in each row :"+ttlcolumns);
		
		Object[][] data = new Object[ttlrows-1][ttlcolumns];
		
		for(int r = 0; r<ttlrows-1;r++) {
			XSSFRow row = sheet.getRow(r+1);
			
			for(int c =0;c<ttlcolumns;c++) {
				XSSFCell cell = row.getCell(c);
				CellType cellType = cell.getCellType();
				
				switch (cellType) {
				case STRING:
					data[r][c] = cell.getStringCellValue();
					System.out.println(data[r][c]);
					
					break;
				case NUMERIC:
					data[r][c] = String.valueOf((int)cell.getNumericCellValue());
					System.out.println(data[r][c]);
					break;
				case BOOLEAN:
					data[r][c] = cell.getBooleanCellValue();
					System.out.println(data[r][c]);
					break;
				default:
					data[r][c] = cell.getStringCellValue();
					System.out.println(data[r][c]);
					break;
				}
			}			
		}
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
}

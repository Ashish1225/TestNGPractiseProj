package com.nxtgenai.dataprovidertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo1 {
	
	// another way to provide data from data provider when large no. data have to pass
	/*
	 * we have given single dimension array instead of more no.of arguments in login test method
	 * 
	 * public void login(String[] stud)  instead of
	 * public void login(String fname, String lname, String email, String phone, String pass, String confirmPass)
	 * 
	 */
	
	@Test(dataProvider = "enterDetails")
	public void login(String[] stud) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");
		driver.manage().window().maximize();
		driver.findElement(By.id("input-firstname")).sendKeys(stud[0]);
		driver.findElement(By.id("input-lastname")).sendKeys(stud[1]);
		driver.findElement(By.id("input-email")).sendKeys(stud[2]);
		driver.findElement(By.id("input-telephone")).sendKeys(stud[3]);
		
		driver.findElement(By.id("input-password")).sendKeys(stud[4]);
		
		driver.findElement(By.id("input-confirm")).sendKeys(stud[5]);
		
		driver.findElement(By.name("agree")).click();
		
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
	}
	
	@DataProvider(name="enterDetails")
	public Object[][] dataProvider(){
		Object[][] studDetail= {
				{"Ashish","Sahu","ashu11@gmail.com","345959443","34874343","34874343"},
				{"Kritika","Pachauri","kritika11@gmail.com","3459443","45346345","45346345"}
					};
		return studDetail;
	}

}

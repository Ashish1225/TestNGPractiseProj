package javaexecutorexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JsExeecutorDemo2 {
	
	// Enter Text into a Textbox using JavascriptExecutor in Selenium WebDriver

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		// 1st way using javascript
		js.executeScript("document.getElementById('email').value='ashu12@gmail.com';");
		
		// 2nd way using webdriver
		
		WebElement element = driver.findElement(By.id("email"));
		
		js.executeScript("arguments[0].value='ashu3242@gmail.com'", element);
		
		// retreiving the values of text field
		
		String emailText = (String)js.executeScript("return document.getElementById('email').value");
		System.out.println(emailText);
		
		driver.quit();	
	}

}

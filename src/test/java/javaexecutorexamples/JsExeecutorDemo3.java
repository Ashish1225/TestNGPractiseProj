package javaexecutorexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JsExeecutorDemo3 {
	
	// Perform Click Operation using JavascriptExecutor in Selenium WebDriver

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.hyrtutorials.com/p/basic-controls.html");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		// 1st way using javascript
		js.executeScript("document.getElementById('englishchbx').click();");
		
		// 2nd way suing webelement
		
		WebElement element = driver.findElement(By.id("latinchbx"));
		js.executeScript("arguments[0].click()", element);
		//driver.quit();	
	}

}

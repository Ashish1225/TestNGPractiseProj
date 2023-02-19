package streamexamplewithselenium;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Demo1 {
	
	// click on columns
	// capture all webelement into list
	// capture text of all webelement into new original list
	//sort on the original list -- sorted list
	// compare original list with sorted list

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		// click on columns
		driver.findElement(By.xpath("//span[text()='Veg/fruit name']")).click();
		
		// capture all webelement into list
		List<WebElement> elementsList = driver.findElements(By.xpath("//tbody//tr//td[1]"));
		
		System.out.println(elementsList);
		
		// capture text of all webelement into new original list
		//List<String> originalList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		
		//List<Object> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		
		//Assert.assertTrue(originalList.equals(sortedList));
		
		

	}

}

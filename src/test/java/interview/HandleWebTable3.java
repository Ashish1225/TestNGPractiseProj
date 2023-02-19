package interview;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWebTable3 {
	
	// Example:print all rows and column values
	
	
	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		// //*[@id='customers']/tbody/tr[3]/td[1]
		
		// colu - //*[@id='customers']/tbody/tr[2]/td
		// rows = //*[@id='customers']/tbody/tr
		
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id='customers']//tr"));
		
		System.out.println(rows.size());
		
		
		List<WebElement> columns = driver.findElements(By.xpath("//*[@id='customers']//th"));
		
		System.out.println(columns.size());
		
		for(int i = 1;i<rows.size();i++) {
			for(int j = 1;j<=columns.size();j++) {
				String name = driver.findElement(By.xpath("//*[@id='customers']/tbody/tr["+(i+1)+"]/td["+j+"]")).getText();
				
				if(name.equals("Italy")) {
					System.out.println("Name found at :"+(i+1)+" and "+j+ " location");
					break;
				}
			
			}
			
		}
		
		
		
		driver.close();
	}

}

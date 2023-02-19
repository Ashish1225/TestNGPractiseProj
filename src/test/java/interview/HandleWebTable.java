package interview;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWebTable {
	
	// Example: Fetch number of rows and columns from Dynamic WebTable
	
	
	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		
		// //*[@id="leftcontainer"]/table/thead/tr/th[1]
		// //*[@id="leftcontainer"]/table/thead/tr/th[2]
		
		List<WebElement> columns = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
		System.out.println("No. of columns are :"+columns.size());
		
		for(int i = 0; i<columns.size();i++) {
			System.out.print(columns.get(i).getText()+" | ");
		}
		System.out.println("");
		
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr/td[1]"));
		
		System.out.println("No. of rows :"+rows.size());
		
		for(int j =0 ;j<rows.size();j++) {
			System.out.println(rows.get(j).getText());
		}
		
		
		driver.close();
	}

}

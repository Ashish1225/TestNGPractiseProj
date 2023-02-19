package interview;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWebTable2 {
	
	// Example:print all rows and column values
	
	
	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		
		// //*[@id="leftcontainer"]/table/tbody/tr[1]/td[5]
		
		List<WebElement> rowsNum = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr"));
		
		List<WebElement> columnsNum =driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[1]/td"));
		
		for(int r = 1;r<rowsNum.size();r++) {
			for(int c= 1;c<columnsNum.size();c++) {
				
				String name = driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr["+r+"]/td["+c+"]")).getText();
				System.out.print(name+" | ");
				
				
			}
			
			System.out.println("");
		}
		
		
		driver.close();
	}

}

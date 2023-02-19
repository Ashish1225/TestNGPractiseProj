package interview;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWebTable4 {

	// find the Country name of corresponding company name

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/html/html_tables.asp");

		List<WebElement> elements = driver.findElements(By.xpath("//*[@id='customers']/tbody/tr/td[1]"));

		// //*[@id='customers']/tbody/tr/td[1]//following-sibling::td[2]

		for (WebElement ele : elements) {
			if (ele.getText().equals("Laughing Bacchus Winecellars")) {
				String compnayNamae = ele.getText();

				String countryName = driver
						.findElement(
								By.xpath("//td[normalize-space()='" + compnayNamae + "']//following-sibling::td[2]"))
						.getText();
				
				System.out.println(countryName);
				break;
			}
		}

		driver.close();
	}

}

package interview;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksDemo {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://www.deadlinkcity.com/");

		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));

		System.out.println("Total number of links :" + allLinks.size());

		// int resCode = 200;
		int brokenLinkCount = 0;
		for (WebElement element : allLinks) {
			String urlLink = element.getAttribute("href");

			// creating a URL object

			try {
				URL url = new URL(urlLink.trim());

				HttpURLConnection huc = (HttpURLConnection) url.openConnection();
				huc.setRequestMethod("GET");
				huc.setConnectTimeout(5000);
				huc.connect();

				int resCode = huc.getResponseCode();
				if (resCode >= 400) {
					System.out.println(urlLink +"response message is :"+huc.getResponseMessage()+ " --is broken link");
					brokenLinkCount = brokenLinkCount + 1;
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (ClassCastException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		System.out.println("Total broken links count are :" + brokenLinkCount);
		driver.quit();

	}

}

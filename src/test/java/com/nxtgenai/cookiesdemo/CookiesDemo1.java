package com.nxtgenai.cookiesdemo;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookiesDemo1 {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		Set<Cookie> cookieList = driver.manage().getCookies();
		
		System.out.println("Before adding Numbers of cookies :"+cookieList.size());
		
		for(Cookie cookies: cookieList) {
			System.out.println(cookies.getName()+" : "+cookies.getValue());
			
		}
		// get the specific cookie 
		
		Cookie cookieName = driver.manage().getCookieNamed("csm-hit");
		System.out.println("Find the name os spacific cookie: "+cookieName);
		
		// adding a new cookie
		// first you have to create a new cookie using cookie class
		Cookie c1 = new Cookie("TestAutomation", "Java Selenium");
		
		// add cookie
		driver.manage().addCookie(c1);
		cookieList = driver.manage().getCookies();
		System.out.println("After adding Numbers of cookies :"+cookieList.size());
		
		
		
		driver.quit();

	}

}

package com.nxtgenai.registerdemotestng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nxtgenai.crossbrowsertesting.MultiBrowser;

public class RegisterDemoTestNG extends MultiBrowser{

	//public WebDriver driver;
	// ---Parameterized all input values
	//String Url = "https://nxtgenaiacademy.com/";
	String regForm = "Registration Form";
	String regFormDemo = "Register For Demo";
	String firstNameValue = "Ashish";
	String lastNameValue = "Sahu";
	String streetAddressValue = "D.M.Compound";
	String apartmentValue = "D-37";
	String cityNameValue = "Firozabad";
	String stateNameValue = "Uttar Pradesh";
	String postalCodeValue = "200203";
	String countryDrpDnValue = "India";
	String emailValue = "ashu@gmail.com";
	String dateOfDemoValue = "11/20/2022";
	String hourValue = "09";
	String minuteValue = "30";
	String ampmValue = "PM";
	String mobileNumberValue = "4564574574";
	String enterYourQueryValue = "When is Selenium Framework ends ?";
	String successfulMessageText = "Registration Form is Successfully Submitted.";

	// ---Parameterized all the WebElements path
	String qaAutomationLocator = "//span[@class='text-wrap'][contains(text(),'QA Automation')]";
	String practiceAutomationLocator = "//span[@class='text-wrap'][contains(text(),'Practice Automation')]";
	String regTitleTextLocator = "//h3[normalize-space()='Register For Demo']";
	String firstNameLocator = "//input[@id='vfb-5']";
	String lastNameLocator = "//input[@id='vfb-7']";
	String maleRdoBtnLocator = "//input[@id='vfb-8-1']";
	String strtAddressLocator = "//input[@id='vfb-13-address']";
	String apartmentlocator = "//input[@id='vfb-13-address-2']";
	String cityLocator = "//input[@id='vfb-13-city']";
	String stateLocator = "//input[@id='vfb-13-state']";
	String postalCodeLocator = "//input[@id='vfb-13-zip']";
	String countryDrpDnLocator = "//select[@id='vfb-13-country']";
	String emailLocator = "//input[@id='vfb-14']";
	String dateOfDemoLocator = "//input[@id='vfb-18']";
	String hourLocator = "//select[@id='vfb-16-hour']";
	String minuteLocator = "//select[@id='vfb-16-min']";
	String mobileNumberLocator = "//input[@id='vfb-19']";
	String seleniumWebDriverLocator = "//input[@id='vfb-20-0']";
	String functionalLocator = "//input[@id='vfb-20-4']";
	String enterYourQueryLocator = "//textarea[@id='vfb-23']";
	String twoDigitLocator = "//input[@id='vfb-3']";
	String submitBtnLocator = "//input[@id='vfb-4']";
	String successfulMsgTextLocator = "//div[contains(text(),'Registration Form is Successfully Submitted')]";
	
	/*
	@BeforeClass
	public void launchApplication() {
		// To set System Property
		System.setProperty("webdriver.chrome.driver",
				"D:\\SeleniumTrainingWorkspace\\TestNGFramework\\Driver\\chromedriver.exe");

		// To create Driver Object in driver Interface
		driver = new ChromeDriver();

		// Launch the Home Url
		driver.get(Url);

		// Maximize the Window
		driver.manage().window().maximize();
		Reporter.log("Application is Launched");
	}

	@AfterClass
	public void closeApplication() {
		// close the application
		driver.close();
		Reporter.log("Application is Closed");
	}
	*/
	
	@Test(priority = 1)
	public void navigateToRegisterDemoPage() {
		// Navigate to the Register page
		WebElement qaAutomation = driver.findElement(By.xpath(qaAutomationLocator));
		

		// Create an instance of Actions class by passing WebDriver instance
		Actions actBuilder = new Actions(driver);

		// Move the mouse above the Qa Automation
		actBuilder.moveToElement(qaAutomation).build().perform();

		// Move the mouse to Practice Automation
		WebElement practiceAutomation = driver.findElement(By.xpath(practiceAutomationLocator));
		actBuilder.moveToElement(practiceAutomation).build().perform();

		// click on Demo Site Registration form
		driver.findElement(By.partialLinkText(regForm)).click();
		Reporter.log("Navigated to the Register Demo Page");

		// Validate the title of the form is displayed as "Register for Demo"
		// Positive Scenarios

		WebElement regTitleText = driver.findElement(By.xpath(regTitleTextLocator));
		if (regTitleText.isDisplayed()) {
			Reporter.log("Registered Title is displayed");
		} else {
			Reporter.log("Registered Title is not displayed");
		}

		// Verify Register Title page is enable or not
		if (regTitleText.isEnabled()) {
			Reporter.log("Registered Title is Enabled");
		} else {
			Reporter.log("Registered Title is not Enabled");
		}

		// Validate the Title text
		String actRegTitleText = regTitleText.getText();
		String exptRegTitleText = regFormDemo;

		if (actRegTitleText.equals(exptRegTitleText)) {
			Reporter.log("Register Title text is : " + actRegTitleText);
		} else {
			Reporter.log("Actual and expected register title text is not same");
			Reporter.log("Actual is: " + actRegTitleText);
			Reporter.log("Expected is : " + exptRegTitleText);
		}
	}

	@Test(priority = 2)
	public void userRegister() {
		// Fill the Registration form by entering a values
		// FirstName

		WebElement firstName = driver.findElement(By.xpath(firstNameLocator));
		// Verify First name is displayed or not
		if (firstName.isDisplayed()) {
			Reporter.log("First Name is Displayed");
		} else {
			Reporter.log("First Name is not Displayed");
		}

		// Verify First name is enable or not
		if (firstName.isEnabled()) {
			Reporter.log("First name is Enabled");
			// Enter the First Name
			firstName.sendKeys(firstNameValue);
			Reporter.log("The Present First Name Values is :" + firstNameValue);
		} else {
			Reporter.log("First Name is not Enabled");
		}

		// Last Name
		WebElement lastName = driver.findElement(By.xpath(lastNameLocator));
		// Verify Last name is displayed or not
		if (lastName.isDisplayed()) {
			Reporter.log("Last Name is Displayed");
		} else {
			Reporter.log("Last Name is not Displayed");
		}

		// Verify Last name is enable or not
		if (lastName.isEnabled()) {
			Reporter.log("Last name is Enabled");
			// Enter the Last Name
			lastName.sendKeys(lastNameValue);
			Reporter.log("The Present Last Name Values is :" + lastNameValue);
		} else {
			Reporter.log("Last Name is not Enabled");
		}

		// Gender - Male Radio Button
		WebElement maleRdoBtn = driver.findElement(By.xpath(maleRdoBtnLocator));
		// Verify male radio button is displayed or not
		if (maleRdoBtn.isDisplayed()) {
			Reporter.log("Male Radio Button is Displayed");
		} else {
			Reporter.log("Male Radio Button is not Displayed");
		}

		// Verify Male Radio button is enable or not
		if (maleRdoBtn.isEnabled()) {
			Reporter.log("Male Radio Button is Enabled");
		} else {
			Reporter.log("Male Radio Button is not Enabled");
		}

		// Verify Male Radio button is Selected
		if (maleRdoBtn.isSelected()) {
			Reporter.log("Male Radio Button is Selected");
		} else {
			Reporter.log("Male Radio Button is not Selected");
			maleRdoBtn.click();
			Reporter.log("Male Radio button has been Selected.");
		}

		// Verify Male Radio button is Selected or not
		if (maleRdoBtn.isSelected()) {
			Reporter.log("Verified Male Radio Button is Selected");
		} else {
			Reporter.log("Verified Male Radio Button is not Selected");
		}

		// -- Address
		// Street Address
		WebElement staAddress = driver.findElement(By.xpath(strtAddressLocator));
		// Verify the Street address is displayed or not
		if (staAddress.isDisplayed()) {
			Reporter.log("Street Address is Displayed");
		} else {
			Reporter.log("Street Address is not Displayed");
		}

		// Verify the Street address is enable or not
		if (staAddress.isEnabled()) {
			Reporter.log("Street Address is Enabled");
			staAddress.sendKeys(streetAddressValue);
			Reporter.log("Present Street Address value is :" + streetAddressValue);
		} else {
			Reporter.log("Street Address is not Enabled");
		}

		// Apartment Number
		WebElement apartmentAddress = driver.findElement(By.xpath(apartmentlocator));
		// Verify Apartment address is displayed or not
		if (apartmentAddress.isDisplayed()) {
			Reporter.log("Apartment Address is Displayed");
		} else {
			Reporter.log("Apartment Address is not Displayed");
		}

		// Verify Apartment address is enable or not
		if (apartmentAddress.isEnabled()) {
			Reporter.log("Apartment Address is Enabled");
			apartmentAddress.sendKeys(apartmentValue);
			Reporter.log("Present Apartment Address value is :" + apartmentValue);
		} else {
			Reporter.log("Apartment Address is not Enabled");
		}

		// City
		WebElement cityAddress = driver.findElement(By.xpath(cityLocator));
		// Verify City address is displayed or not
		if (cityAddress.isDisplayed()) {
			Reporter.log("City Address is Displayed");
		} else {
			Reporter.log("City Address is not Displayed");
		}
		// Verify City address is enable or not
		if (cityAddress.isEnabled()) {
			Reporter.log("City Address is Enabled");
			cityAddress.sendKeys(cityNameValue);
			Reporter.log("Present City Address value is :" + cityNameValue);
		} else {
			Reporter.log("City Address is not Enabled");
		}

		// state
		WebElement stateAddress = driver.findElement(By.xpath(stateLocator));
		// Verify State address is displayed or not
		if (stateAddress.isDisplayed()) {
			Reporter.log("State Address is Displayed");
		} else {
			Reporter.log("State Address is not Displayed");
		}
		// Verify City address is enable or not
		if (stateAddress.isEnabled()) {
			Reporter.log("State Address is Enabled");
			stateAddress.sendKeys(stateNameValue);
			Reporter.log("Present state Address value is :" + stateNameValue);
		} else {
			Reporter.log("State Address is not Enabled");
		}

		// Postal Code
		WebElement postalCode = driver.findElement(By.xpath(postalCodeLocator));
		// Verify Postal Code is displayed or not
		if (postalCode.isDisplayed()) {
			Reporter.log("Postal Code is Displayed");
		} else {
			Reporter.log("Postal Code is not Displayed");
		}
		// Verify Postal Code is enable or not
		if (postalCode.isEnabled()) {
			Reporter.log("Postal Code is Enabled");
			postalCode.sendKeys(postalCodeValue);
			Reporter.log("Present Postal Code value is :" + postalCodeValue);
		} else {
			Reporter.log("Postal Code is not Enabled");
		}

		// Country DropDown
		WebElement contryDrpDn = driver.findElement(By.xpath(countryDrpDnLocator));
		// Verify Country DropDown is displayed or not
		if (contryDrpDn.isDisplayed()) {
			Reporter.log("Country DropDown is Displayed");
		} else {
			Reporter.log("Country DropDown is not Displayed");
		}
		// Verify Country DropDown is enable or not
		if (contryDrpDn.isEnabled()) {
			Reporter.log("Country DropDown is Enabled");
		} else {
			Reporter.log("Country DropDown is not Enabled");
		}
		// To select the item from the country drop down, create the select object
		Select select = new Select(contryDrpDn);
		select.selectByVisibleText(countryDrpDnValue);
		Reporter.log("Present Country DropDown is :" + countryDrpDnValue);

		// Email
		WebElement email = driver.findElement(By.xpath(emailLocator));
		// Verify Email is displayed or not
		if (email.isDisplayed()) {
			Reporter.log("Email is Displayed");
		} else {
			Reporter.log("Email is not Displayed");
		}
		// Verify Email is enable or not
		if (email.isEnabled()) {
			Reporter.log("Email is Enabled");
			email.sendKeys(emailValue);
			Reporter.log("Present Email value is :" + emailValue);
		} else {
			Reporter.log("Email is not Enabled");
		}

		// Date Of Demo
		WebElement demoDate = driver.findElement(By.xpath(dateOfDemoLocator));
		// Verify Date of Demo is displayed or not
		if (demoDate.isDisplayed()) {
			Reporter.log("Date of Demo is Displayed");
		} else {
			Reporter.log("Date of Demo is not Displayed");
		}
		// Verify Email is enable or not
		if (demoDate.isEnabled()) {
			Reporter.log("Date of Demo is Enabled");
			demoDate.sendKeys(dateOfDemoValue);
			Reporter.log("Present Date of Demo value is :" + dateOfDemoValue);
		} else {
			Reporter.log("Date of Demo is not Enabled");
		}

		// Convenient Time
		// Hours drop down
		WebElement hourDrpDn = driver.findElement(By.xpath(hourLocator));
		// Verify Hours drop down is displayed or not
		if (hourDrpDn.isDisplayed()) {
			Reporter.log("Hours drop down is Displayed");
		} else {
			Reporter.log("Hours drop down is not Displayed");
		}

		// Verify Hour is enable or not
		if (hourDrpDn.isEnabled()) {
			Reporter.log("Hours drop down is Enabled");
			Select selectHour = new Select(hourDrpDn);
			selectHour.selectByVisibleText(hourValue);
			Reporter.log("Present Hours drop down value is :" + hourValue);
		} else {
			Reporter.log("Hours drop down is not Enabled");
		}

		// Minute drop down
		WebElement minDrpDn = driver.findElement(By.xpath(minuteLocator));
		// Verify Minute drop down is displayed or not
		if (minDrpDn.isDisplayed()) {
			Reporter.log("Minute drop down is Displayed");
		} else {
			Reporter.log("Minute drop down is not Displayed");
		}

		// Verify Minute is enable or not
		if (minDrpDn.isEnabled()) {
			Reporter.log("Minute drop down is Enabled");
			Select selectmin = new Select(minDrpDn);
			selectmin.selectByVisibleText(minuteValue);
			Reporter.log("Present Minute drop down value is :" + minuteValue);
		} else {
			Reporter.log("Minute drop down is not Enabled");
		}

		// Mobile Number
		WebElement mobileNum = driver.findElement(By.xpath(mobileNumberLocator));
		// Verify Mobile Number is displayed or not
		if (mobileNum.isDisplayed()) {
			Reporter.log("Mobile Number is Displayed");
		} else {
			Reporter.log("Mobile Number is not Displayed");
		}
		// Verify Mobile Number is enable or not
		if (mobileNum.isEnabled()) {
			Reporter.log("Mobile Number is Enabled");
			mobileNum.sendKeys(mobileNumberValue);
			Reporter.log("Present Mobile Number value is :" + mobileNumberValue);
		} else {
			Reporter.log("Mobile Number is not Enabled");
		}

		// Course Interest
		// Selenium WebDriver Check box
		WebElement seleniumCheck = driver.findElement(By.xpath(seleniumWebDriverLocator));
		// Verify Selenium WebDriver check box is displayed or not
		if (seleniumCheck.isDisplayed()) {
			Reporter.log("Selenium WebDriver Check box is displayed");
		} else {
			Reporter.log("Selenium WebDriver Check box is not displayed");
		}
		// Verify Selenium WebDriver check box is Enable or not
		if (seleniumCheck.isEnabled()) {
			Reporter.log("Selenium WebDriver Check box is Enabled");
		} else {
			Reporter.log("Selenium WebDriver Check box is not Enabled");
		}
		// Verify selenium Webdriver check box is selected or not selected
		if (seleniumCheck.isSelected()) {
			Reporter.log("Verified Selenium WebDriver Check box is Selected");
		} else {
			Reporter.log("Verified Selenium WebDriver Check box is not Selected");
			seleniumCheck.click();
			Reporter.log("Selenium WebDriver Check box has Selected");
		}
		// Verify selenium Webdriver check box is selected or not
		if (seleniumCheck.isSelected()) {
			Reporter.log("Verified Selenium WebDriver Check box is Selected");
		} else {
			Reporter.log("Verified Selenium WebDriver Check box is not Selected");
		}

		// Functional testing Check box
		WebElement functionalCheck = driver.findElement(By.xpath(functionalLocator));
		// Verify Functional testing check box is displayed or not
		if (functionalCheck.isDisplayed()) {
			Reporter.log("Functional testing Check box is displayed");
		} else {
			Reporter.log("Functional testing Check box is not displayed");
		}
		// Verify Functional testing check box is Enable or not
		if (functionalCheck.isEnabled()) {
			Reporter.log("Functional testing Check box is Enabled");
		} else {
			Reporter.log("Functional testing Check box is not Enabled");
		}
		// Verify sFunctional testing check box is selected or not selected
		if (functionalCheck.isSelected()) {
			Reporter.log("Verified Functional testing Check box is Selected");
		} else {
			Reporter.log("Verified Functional testing Check box is not Selected");
			functionalCheck.click();
			Reporter.log("Functional testing Check box has Selected");
		}
		// Verify Functional testing check box is selected or not
		if (functionalCheck.isSelected()) {
			Reporter.log("Verified Functional testing Check box is Selected");
		} else {
			Reporter.log("Verified Functional testing Check box is not Selected");
		}

		// Enter Your Query text
		WebElement queryText = driver.findElement(By.xpath(enterYourQueryLocator));
		// Verify Enter your Query is displayed or not
		if (queryText.isDisplayed()) {
			Reporter.log("Enter Your Query is Displayed");
		} else {
			Reporter.log("Enter Your Query is not Displayed");
		}
		// Verify Enter your Query is Enabled or not
		if (queryText.isEnabled()) {
			Reporter.log("Enter Your Query is Enabled");
			queryText.sendKeys(enterYourQueryValue);
			Reporter.log("Present Enter Your Query is :" + enterYourQueryValue);
		} else {
			Reporter.log("Enter Your Query is not Enabled");
		}

		// Enter Any Two Digits
		WebElement twoDigit = driver.findElement(By.xpath(twoDigitLocator));
		// Verify Enter two digit is displayed or not
		if (twoDigit.isDisplayed()) {
			Reporter.log("Enter Any two digit is Displayed");
		} else {
			Reporter.log("Enter Any two digit is not Displayed");
		}

		// Verify Enter two digits is enabled or not
		if (twoDigit.isEnabled()) {
			Reporter.log("Enter ANy two digits is Enabled");
			String twoDigitText = driver.findElement(By.xpath("//label[normalize-space()='Example: 99']")).getText();
			String[] num = twoDigitText.split(":");
			twoDigit.sendKeys(num[1].trim());
			Reporter.log("Enter Any two digits is:" + num[1]);
		} else {
			Reporter.log("Enter ANy two digits is not Enabled");
		}

		// Submit button
		WebElement submitBtn = driver.findElement(By.xpath(submitBtnLocator));
		// Verify Submit button is displayed or not
		if (submitBtn.isDisplayed()) {
			Reporter.log("Submit button is displayed");
		} else {
			Reporter.log("Submit button is not displayed");
		}
		// Verify Submit button is Enabled or not
		if (submitBtn.isEnabled()) {
			Reporter.log("Submit button is Enable");
			submitBtn.click();
			Reporter.log("Submit button is clicked");
		} else {
			Reporter.log("Submit button is not Enable");
		}
	}

	@Test(priority = 3)
	public void validateSuccessfulMessage() {
		WebElement successfulMsgText = driver.findElement(By.xpath(successfulMsgTextLocator));
		// Verify Successful Message text is displayed or not
		if (successfulMsgText.isDisplayed()) {
			Reporter.log("Successfull Message text is displayed");
		} else {
			Reporter.log("Successfull Message text is not displayed");
		}
		// Validating Successfull message text
		String actSuccessfulMsgText = successfulMsgText.getText();
		String exptSuccessfulMsgText = successfulMessageText;
		if (actSuccessfulMsgText.contains(exptSuccessfulMsgText)) {
			Reporter.log("Actual Success Message Text is: " + actSuccessfulMsgText);
		} else {
			Reporter.log("Actual and Expected Successful message text are not same");
			Reporter.log("Actual Success Message Text is: " + actSuccessfulMsgText);
			Reporter.log("Expected Success Message Text is: " + exptSuccessfulMsgText);
		}

	}
}

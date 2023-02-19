package com.nxtgenai.dataprovidertesting;

import org.testng.annotations.DataProvider;

public class DataProviderMethodDemo {
	

	@DataProvider(name="searchCountryMonument")
	public Object[][] dataProvider(){
		Object[][] enterData = new Object[3][2];
		enterData[0][0] = "India";
		enterData[0][1] = "Qutub Minar";
		
		enterData[1][0] = "Agra";
		enterData[1][1] = "Taj Mahal";
		
		enterData[2][0] = "Hyderabad";
		enterData[2][1] = "Char Minar";
		
		return enterData;
		
	}

}

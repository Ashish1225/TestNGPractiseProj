package com.nxtgenai.testngannotation;

import org.testng.annotations.Test;

public class RegisterDemo {
	
  @Test(priority=1)
  public void launchApplication() {
	  System.out.println("Application is launched");
  }
  
  @Test(priority=2)
  public void navigateToRegisterDemoPage() {
	  System.out.println("Registration page is loaded successfully");
  }
  
  @Test(priority=3)
  public void userRegister() {
	  System.out.println("User is registered");
  }
  
  @Test(priority=4)
  public void closeApplication() {
	  System.out.println("Application is closed");
  }
}

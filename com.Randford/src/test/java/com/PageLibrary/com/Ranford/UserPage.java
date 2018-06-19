package com.PageLibrary.com.Ranford;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import TestBase.Base;

public class UserPage extends Base{

	public static WebElement new_userBTN(WebDriver driver) {
		
		return driver.findElement(getlocator("Newuser"));
	}

	public static WebElement Customer_UserName(WebDriver driver) {
		
		
		return driver.findElement(getlocator("Username"));
	}

	public static WebElement Customer_LoginPassword(WebDriver driver) {
		
		return driver.findElement(getlocator("User_loginpwd"));
	}

	public static WebElement Customer_TransactionPassword(WebDriver driver) {
		
		return driver.findElement(getlocator("User_transectionpwd"));
	}

	public static WebElement submit(WebDriver driver) {
		
		return driver.findElement(getlocator("User_submit"));
	}

}

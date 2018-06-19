package com.PageLibrary.com.Ranford;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import TestBase.Base;

public class NewEmployeePage extends Base{

	public static WebElement New_EmpBtn(WebDriver driver) {
		return driver.findElement(getlocator("newEmployee"));
		
	}

	public static WebElement E_LoginPwd(WebDriver driver) {
		return 	driver.findElement(getlocator("loginPassword"));
		
	}

	public static WebElement E_EmployeeName(WebDriver driver) {
		
		return driver.findElement(getlocator("emplyerName"));
	}

	

	
public static WebElement E_SubmitBtn(WebDriver driver) {
		
		return driver.findElement(getlocator("submit3"));
	}
}

package com.PageLibrary.com.Randford;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import TestBase.Base;

public class AdminPage extends Base{
	
	public static WebElement Home(WebDriver driver) {
		return driver.findElement(getlocator("home"));
	}
	
	public static WebElement ChangePassword(WebDriver driver) {
		return driver.findElement(getlocator("changepassword"));
	}
	
	public static WebElement LogOut(WebDriver driver) {
		return driver.findElement(getlocator("logout"));
	}
	
	public static WebElement NewBranch(WebDriver driver) {
		return driver.findElement(getlocator("newBranch"));
	}
	
	public static WebElement Branches(WebDriver driver) {
		return driver.findElement(getlocator("branches"));
	}
	
	public static WebElement Roles(WebDriver driver) {
		return driver.findElement(getlocator("roles"));
	}
	
	public static WebElement Users(WebDriver driver) {
		return driver.findElement(getlocator("users"));
	}
	
	public static WebElement Employee(WebDriver driver) {
		return driver.findElement(getlocator("employee"));
	}
	
	/*public static WebElement Search(WebDriver driver) {
		return driver.findElement(getlocator("search"));
	}
	*/
	/*public static WebElement Clear(WebDriver driver) {
		return driver.findElement(getlocator("clear"));
	}*/
	
		
}


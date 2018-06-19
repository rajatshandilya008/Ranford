package com.PageLibrary.com.Randford;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import TestBase.Base;

public class Branch extends Base{
		
		public static WebElement Home(WebDriver driver) {
			return driver.findElement(getlocator("home"));
		}
		
		public static WebElement ChangePassword(WebDriver driver) {
			return driver.findElement(getlocator("changepassword"));
		}
		
		public static WebElement LogOut(WebDriver driver) {
			return driver.findElement(getlocator("logout"));
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
		
		public static WebElement BranchName_text(WebDriver driver) {
			return driver.findElement(getlocator("branchName"));
		}

		public static WebElement Address1_text(WebDriver driver) {
			return driver.findElement(getlocator("address1"));
		}
		
		public static WebElement Address2_text(WebDriver driver) {
			return driver.findElement(getlocator("address2"));
		}
		
		public static WebElement Address3_text(WebDriver driver) {
			return driver.findElement(getlocator("address3"));
		}
		
		public static WebElement Area_text(WebDriver driver) {
			return driver.findElement(getlocator("area"));
		}
		
		public static WebElement Zipcode_text(WebDriver driver) {
			return driver.findElement(getlocator("zipcode"));
		}
		public static WebElement state(WebDriver driver) {
			return driver.findElement(getlocator("GOA"));
		}
		public static WebElement Submit(WebDriver driver) {
			return driver.findElement(getlocator("submit1"));
		}
		
		public static WebElement Reset(WebDriver driver) {
			return driver.findElement(getlocator("reset"));
		}
		
		public static WebElement Cancel(WebDriver driver) {
			return driver.findElement(getlocator("cancel"));
		}
	}



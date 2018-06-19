package com.PageLibrary.com.Randford;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import TestBase.Base;

public class RolePage extends Base{
	public static WebElement RoleName_text(WebDriver driver) {
		return driver.findElement(getlocator("rolename"));

	}public static WebElement RoleDesc(WebDriver driver) {
		return driver.findElement(getlocator("roledesc"));
	}
	public static WebElement Submit(WebDriver driver) {
		return driver.findElement(getlocator("submit"));
	}
}

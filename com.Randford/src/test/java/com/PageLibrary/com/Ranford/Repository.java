package com.PageLibrary.com.Ranford;

import org.apache.poi.xssf.model.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import com.PageLibrary.com.Randford.AdminPage;
import com.PageLibrary.com.Randford.Branch;
import com.PageLibrary.com.Randford.Generic;
import com.PageLibrary.com.Randford.HomePage;
import com.PageLibrary.com.Randford.RolePage;

import TestBase.Base;
import dataDriven.ExcelDataDriven;
import utility.Library;

public class Repository extends Base {

	protected static WebDriver driver;
//=======================================================================================================
	public void login() {
		HomePage.userName_text(driver).sendKeys("Admin");

		HomePage.password_text(driver).sendKeys("Admin");

		HomePage.login_text(driver).click();
		AdminPage.Branches(driver).click();
	}
//========================================================================================================
	public void launch() {
		System.setProperty(config("geckokey"), config("geckovalue"));
		driver = new FirefoxDriver();
		driver.get(config("url"));

	}
//=========================================================================================================
	public void branchCreation(String Bname, String address1, String address2, String address3, String area,
			String zipcode, String country, String state, String City) {

		try {
			AdminPage.NewBranch(driver).click();

			Branch.BranchName_text(driver).sendKeys(Bname);

			Branch.Address1_text(driver).sendKeys(address1);

			Branch.Address2_text(driver).sendKeys(address2);

			Branch.Address3_text(driver).sendKeys(address3);

			Branch.Area_text(driver).sendKeys(area);

			Branch.Zipcode_text(driver).sendKeys(zipcode);

			Generic.dropdown(driver, getlocator("country"), country);

			Generic.dropdown(driver, getlocator("state"), state);

			Generic.dropdown(driver, getlocator("city"), City);

			// Generic.dropdown2(driver, getlocator("")).selectByValue("");

			Branch.Submit(driver).click();
			driver.switchTo().alert().accept();
			// Library.attachement("MindQ");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
//==========================================================================================================
	public void adminMode_Role() {
		AdminPage.Roles(driver).click();

		AdminPage.newRole(driver).click();
	}

	public void roleCreation(String rolename, String roledesc, String type) {
		RolePage.RoleName_text(driver).sendKeys(rolename);

		RolePage.RoleDesc(driver).sendKeys(roledesc);

		Generic.dropdown(driver, getlocator("roleType"), type);
		RolePage.Submit(driver).click();

	Generic.alertHandle(driver);
	}
//===========================================================================================================
public void userCreation(String urole,String ubranch,String ucustomerid,String uUsername,String uloginpwd,String uTxnpwd) throws InterruptedException {
		
		AdminPage.Users(driver).click();
		UserPage.new_userBTN(driver).click();
		Generic.dropdown(driver, getlocator("urole"),urole);
		Generic.dropdown(driver,getlocator("ubranch"),ubranch);
		Generic.dropdown(driver,getlocator("uid"),ucustomerid);
		//UserPage.Customer_Branch(driver).sendKeys("");
		//UserPage.Customer_Name(driver).sendKeys(uCustomername);
		UserPage.Customer_UserName(driver).sendKeys(uUsername);
		UserPage.Customer_LoginPassword(driver).sendKeys(uloginpwd);
		UserPage.Customer_TransactionPassword(driver).sendKeys(uTxnpwd);
		Thread.sleep(3000);
		UserPage.submit(driver).click();
		
		if(Validation.IsAlertPresent(driver, "added Sucessfully"))
		{
			Reporter.log(" pass");
		}else
		{
			Reporter.log("fail");
			Library.screenshort("user creation");
		}
				Generic.alertHandle(driver);
		}
	
//=====================================================================================================================================================================================================================	
	
	public void employeeCreation(String Ename,String Eloginpwd,String Erole,String EBranch) {
		AdminPage.Employee(driver).click();
		NewEmployeePage.New_EmpBtn(driver).click();
		NewEmployeePage.E_EmployeeName(driver).sendKeys(Ename);
		NewEmployeePage.E_LoginPwd(driver).sendKeys(Eloginpwd);
		Generic.dropdown(driver,getlocator("Erole"),Erole);
		Generic.dropdown(driver,getlocator("Ebranch"),EBranch);
		NewEmployeePage.E_SubmitBtn(driver).click();
		if(Validation.IsAlertPresent(driver, "Successfully"))
		{
			Reporter.log("pass");
		}else {
			Reporter.log("fail");
			Library.screenshort("Employee Creation");
		}
		Generic.alertHandle(driver);
	}
//=====================================================================================================================================================================================	
		
	/*public void operaionBranchTable() {
		Admin.branches_link(driver).click();
		Table.m(driver, getlocator("branchTable"), "edit", "77");
		BranchUpdationPage.Update_BTN(driver).click();
		if (Validation.IsAlertPresent(driver, "Branch updated Sucessfully")) {
			Reporter.log("branch edit test  pass");
			
		}else {
			Reporter.log("branch edit test  fail");
			Library.attachement("branchEdit failed");
		}
		Generic.alertHandle(driver);}*/

	
//============================================================================================================================================================
/*public void operationRolesTable() {
	Admin.roles_link(driver).click();
	Table.m(driver, getlocator("roleTable"), "edit", "64");
	RolesUpdationPage.UpdateBTN(driver).click();
	if(Validation.IsAlertPresent(driver, "New Role updated Sucessfully")) {
		Reporter.log("role table edit pass");
	}else {
		Reporter.log("role table edit fail");
		Library.attachement("roletable update fail");
	}
	Generic.alertHandle(driver);
}*/


  public String[][] excelcontent(String filename,String sheetname)
  {
	  
	  ExcelDataDriven.excelconnection(filename, sheetname);
	  
	  int rc=ExcelDataDriven.rcount();
	 
	  int cc=ExcelDataDriven.ccount();
	  
	  String[][] data=new String[rc-1][cc];
	  
	  for(int r=1;r<rc;r++)
	  {
		  for(int c=0;c<cc;c++)
		  {
			 data[r-1][c]=ExcelDataDriven.readData(c, r);
		  }
	  }
	return data;
	  
  }
  















}
package com.PageLibrary.com.Randford;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.PageLibrary.com.Ranford.Repository;

import dataDriven.ExcelDataDriven;

public class TestExecution extends Repository {
	@Test
	public void validLaunch() throws InterruptedException {

		launch();
		Thread.sleep(2000);
	}

	@Test(priority = 1)
	public void validLogin() throws InterruptedException {
		login();
		Thread.sleep(2000);
	}

	@DataProvider(name = "branches")
	public String[][] varify_excelcontent() {

		return excelcontent("book1.xls", "Sheet1");

	}

	@Test(priority = 2, dataProvider = "branches")
	public void varify_branchCreation(String Bname, String address1, String address2, String address3, String area,
			String zipcode, String country, String state, String City) {

		branchCreation(Bname, address1, address2, address3,area, zipcode,  country, state, City);

	}

	@DataProvider(name = "roles")
	public String[][] varify_excelcontent1() {

		return excelcontent("book1.xls", "Sheet2");

	}

	@Test(priority = 4, dataProvider = "roles")
	public void varify_rolecreation(String rolename, String roledesc, String type) {
		roleCreation(rolename, roledesc, type);
	}

	/*
	 * @Test(priority=3) private void closeBrowser() throws Exception {
	 * Library.attachement("b"); Thread.sleep(1000); close();
	 * 
	 * 
	 * }
	 */

@Test(priority=3)
public void excelcontent() throws InterruptedException
{
	ExcelDataDriven.excelconnection("datadriven.xls", "BranchSheet");
	
	ExcelDataDriven.outputexcelconnection("datadriven.xls", "output.xls", "BranchSheet");
	
	int c=ExcelDataDriven.ccount();
	for(int r=1;r<ExcelDataDriven.rcount();r++)
	{
	
		branchCreation(ExcelDataDriven.readData(0, r), ExcelDataDriven.readData(1, r), ExcelDataDriven.readData(2, r), ExcelDataDriven.readData(3, r), ExcelDataDriven.readData(4, r), ExcelDataDriven.readData(5, r), ExcelDataDriven.readData(6, r), ExcelDataDriven.readData(7, r), ExcelDataDriven.readData(8, r));
		String text=Generic.alertHandle(driver).getText();
		Generic.alertHandle(driver).accept();
		
		if(text.contains("created successufully"))
		{
			ExcelDataDriven.writedata(c++, r, "Test Passed");
			c--;
		}
		else if(text.contains("Already Exits"))
		{
			ExcelDataDriven.writedata(c++, r, "Test Failed");
			c--;
		}
		else
		{
			ExcelDataDriven.writedata(c++, r, "alert is not present");
			c--;
		}
		
		
	}
	ExcelDataDriven.saveworkbook();
}
//===========================================================================================================================================================================================================

@DataProvider(name="roles")
public String[][] verify_Rolesexcelcontent()
{
	return excelcontent("datadriven.xls", "roleSheet");
}	

@Test(priority=4,dataProvider="roles")
public void verify_rolesCreation(String rname,String rdec,String rtype) throws InterruptedException {
	roleCreation(rname,rdec,rtype);
}
//==================================================================================================================================================================================================


@DataProvider(name="user")
public String[][] verify_Userexcelcontent()
{
	return excelcontent("datadriven.xls", "UserSheet");
}	

@Test(priority=5,dataProvider="user")
public void verify_userCreation(String urole,String ubranch,String ucustomerid,String uUsername,String uloginpwd,String uTxnpwd) throws InterruptedException {
	verify_userCreation(urole,ubranch,ucustomerid,uUsername,uloginpwd,uTxnpwd);
}
//==================================================================================================================================================================================================	

@DataProvider(name="employee")
public String[][] verify_emploiyeeexcelcontent()
{
	return excelcontent("datadriven.xls", "EmployeeSheet");
}	

@Test(priority=6,dataProvider="employee")
public void verify_employeeCreation(String Ename,String Eloginpwd,String ERole,String EBranch) throws InterruptedException {
	verify_employeeCreation(Ename,Eloginpwd,ERole,EBranch);
}
//=================================================================================================================================================================================================

@Test(priority=3)
public void varify_BranchTAbleEdit() {
operationBranchTable();
}

@Test(priority=4)
public void varify_RolesTableEdit() {
operationRolesTable();

}













}
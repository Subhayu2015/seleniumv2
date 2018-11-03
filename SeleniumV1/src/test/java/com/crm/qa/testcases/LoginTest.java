package com.crm.qa.testcases;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.utils.Utils;

public class LoginTest extends TestBase {
	String className = this.getClass().getSimpleName();
	public LoginTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		TestBase.initialization();	
	}
	
	@Test
	public void loginfunction(){
		initializePOM();
		Map<String, String> m = userForm();
		loginPage.pageLogin(m.get("User"),m.get("Password"));
		crmHomePage.clickWeekView();
	}
	
	public Map<String, String> userForm(){
		String filename=prop.getProperty("filename");
		String sheetname=prop.getProperty("sheetname");
		Map<String, String> data = new HashMap<String, String>();
		try {
			data = Utils.getTestData(filename,sheetname,className);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
		
	}
	
	@AfterMethod
	public void endOfScript(){
		driver.quit();
	}

}

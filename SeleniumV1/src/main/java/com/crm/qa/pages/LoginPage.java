package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;


public class LoginPage extends TestBase {
	@FindBy(xpath="//*[@id='loginForm']/div/input[1]")
	private WebElement username;
	
	@FindBy(xpath="//*[@id='loginForm']/div/input[2]")
	private WebElement pwd;
	
	@FindBy(xpath="//*[@id='loginForm']/div/div/input")
	private WebElement loginbtn;
	

	public LoginPage(){
		PageFactory.initElements(driver, this);
		
	}
	
	public void pageLogin(String user, String password){
			username.sendKeys(user);
			pwd.sendKeys(password);
			loginbtn.click();
			
	}
}

package com.railyatri.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.railyatri.qa.base.TestBase;
import com.railyatri.qa.utils.TestUtil;

public class LoginPage extends TestBase{
	By loginBtnOption = By.xpath("//a[@class='login-button']");
	By loginOptionEmail = By.xpath("//div[@class='popover fade bottom in']//img[@src='/assets/login.png']");
		//	.xpath("//*[@class='popover fade bottom in'][@style='display:block;']//div[2]//li[5]/a/img");
	By emailTxtbox = By.xpath("//form[@id='login-form']//input[@id='user_email']");
	By passwordTxtbox = By.xpath("//form[@id='login-form']//input[@id='user_password']");
	By loginbtn = By.xpath("//form[@id='login-form']//input[@name='commit']");
	

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public HomePage Login(String un, String pwd) throws IOException {
		Wait = new WebDriverWait(driver,30);
		Wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtnOption));	
		driver.findElement(loginBtnOption).click();
		Wait.until(ExpectedConditions.visibilityOfElementLocated(loginOptionEmail));	
		driver.findElement(loginOptionEmail).click();
		Wait.until(ExpectedConditions.visibilityOfElementLocated(emailTxtbox));		
		driver.findElement(emailTxtbox).sendKeys(un);
		driver.findElement(passwordTxtbox).sendKeys(pwd);
		TestUtil.takeScreenshotAt("login");
		driver.findElement(loginbtn).click();
		return new HomePage();

	}
	
	public String validateTitle()
	{
		return driver.getTitle();
	}
	
}

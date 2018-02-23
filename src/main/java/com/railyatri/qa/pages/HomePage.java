package com.railyatri.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.railyatri.qa.base.TestBase;
import com.railyatri.qa.utils.TestUtil;

public class HomePage extends TestBase{
	By userNametxt = By.xpath("//a[@class='dropdown-toggle login-button']/span");
	By busbookingBtn = By.xpath("//a[text()='Bus Ticket Booking']");
	By logoutBtn = By.xpath("//a[text()='Logout']");
	
	public void validateLoginuserName() throws IOException
	{
		String usernametxt = driver.findElement(userNametxt).getText();
		Assert.assertEquals(usernametxt,"NNull");
		TestUtil.takeScreenshotAt("UserName");
		
	}
	
	public BusSearchPage clickBusBookingBtn()
	{
		driver.findElement(busbookingBtn).click();
		return new BusSearchPage();
	}
	
	public void logout()
	{
		driver.findElement(userNametxt).click();
	}

}

package com.railyatri.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

import com.railyatri.qa.base.TestBase;
import com.railyatri.qa.utils.TestUtil;

public class ReviewPage extends TestBase{
	By travellerNametxt =  By.xpath("//div[@class='trvl-bus-info']");
	By dateofJourneytxt = By.id("date_of_ourney");
	By boardingPointtxt = By.id("bp-point");
	By closebtn = By.xpath("//div[@id='bus-modal']//span[text()='×']");
	
	
	public void reviewDetails(String boardingpoint) throws IOException
	{
		String TravellerName = driver.findElement(travellerNametxt).getText();
		String jouneydate = driver.findElement(dateofJourneytxt).getText();
		String bp =  driver.findElement(boardingPointtxt).getText();
		TestUtil.takeScreenshotAt("reviewDetails");
		
			
	}
	public HomePage cancelTrasaction()
	{
		driver.findElement(closebtn).click();
		return new HomePage();
	}
	
	@AfterSuite
	public void teardown()
	{
		driver.close();
	}
	

}

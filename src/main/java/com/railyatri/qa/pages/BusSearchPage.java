package com.railyatri.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.railyatri.qa.base.TestBase;
import com.railyatri.qa.utils.TestUtil;

public class BusSearchPage extends TestBase{
	By sourceTxtbox = By.id("from-city");
	By destinationTxtbox = By.id("to-city");
	By fromSearchtxtbox = By.xpath("//*[@id='from_search_suggestion_page']//input[@id='from-search-input-popup']");
	By toSearchtxtBox = By.xpath("//*[@id='to_search_suggestion_page']//input[@id='to-search-input-popup']");
	By noofPassengerslstBox = By.id("no_of_pass");
	By searchBtn = By.xpath("//button[text()='Search Buses']");
	By fromcity =By.xpath("//span[text()='Chennai']");
	By toCity = By.xpath("(//span[text()='Hyderabad'])[2]");
	By thankbtn = By.id("wzrk-confirm");
	
	public void enterTxtinSource(String sourceCity)
	{
		Wait.until(ExpectedConditions.visibilityOfElementLocated(thankbtn));
		driver.findElement(thankbtn).click();
		driver.findElement(sourceTxtbox).click();
		Wait.until(ExpectedConditions.visibilityOfElementLocated(fromSearchtxtbox));
		driver.findElement(fromSearchtxtbox).sendKeys(sourceCity);
		driver.findElement(By.xpath("//span[text()='"+sourceCity+"']")).click();
	}

	public void enterTxtinDestination(String destinationCity)
	{
		
		Wait.until(ExpectedConditions.visibilityOfElementLocated(toSearchtxtBox));
		driver.findElement(toSearchtxtBox).sendKeys(destinationCity);
		Wait.until(ExpectedConditions.visibilityOfElementLocated(toCity));
		driver.findElement(By.xpath("(//span[text()='"+destinationCity+"'])[2]")).click();
	}
	
	public void chooseTravellers(String noofPassengers)
	{
		Select passenger = new Select(driver.findElement(noofPassengerslstBox));
		passenger.selectByVisibleText(noofPassengers);
		
	}
	public BusSearchResultPage clickSearchBtn()
	{
		driver.findElement(searchBtn).click();
		return new BusSearchResultPage();
	}
	
	public BusSearchResultPage EnterBusSearchDetails(String source,String destination,String travellers) throws IOException
	{
		enterTxtinSource(source);
		enterTxtinDestination(destination);
		chooseTravellers(travellers);
		TestUtil.takeScreenshotAt("SearchPage");
		clickSearchBtn();
		return new BusSearchResultPage();
	}
	
	
}

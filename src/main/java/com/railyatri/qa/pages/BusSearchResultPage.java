package com.railyatri.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.railyatri.qa.base.TestBase;
import com.railyatri.qa.utils.TestUtil;

public class BusSearchResultPage extends TestBase{
	By viewSeatsBtn =By.xpath("(//div[@data-travels='Saheel Tours & Travels']//button)[1]");
	By windowSeatckbox = By.xpath("//div[@data-travels='Saheel Tours & Travels']//div[@class='seats_row']/div[1]/div[8]");
	By nonwindowSeatckBox = By.xpath("//div[@data-travels='Saheel Tours & Travels']//div[@class='seats_row']/div[2]/div[8]");
	By boardingPointlstBox = By.id("bp");
	By droppingPointlstBox = By.id("dp");
	By continueBtn = By.xpath("//form[@id='booking_form']/button[text()='CONTINUE BOOKING']");
	
	public PassengerDetailsPage selectDetailsonsearchresult(String boardingppoint,String droppingpoint) throws IOException
	{
	driver.findElement(viewSeatsBtn).click();
	Wait.until(ExpectedConditions.visibilityOfElementLocated(windowSeatckbox));
	driver.findElement(windowSeatckbox).click();
	driver.findElement(nonwindowSeatckBox).click();
	Select chooseboardingpoint = new Select(driver.findElement(boardingPointlstBox));
	chooseboardingpoint.selectByVisibleText(boardingppoint);
	Select choosedroppingpoint = new Select(driver.findElement(droppingPointlstBox));
	choosedroppingpoint.selectByVisibleText(droppingpoint);
	TestUtil.takeScreenshotAt("SearchResult");
	driver.findElement(continueBtn).click();
	return new PassengerDetailsPage();
	}

}

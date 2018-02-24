package com.railyatri.qa.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.railyatri.qa.base.TestBase;
import com.railyatri.qa.utils.TestUtil;

public class BusSearchResultPage extends TestBase {
	By modalclosebtn = By.id("close_ry_excl_modal");
	By viewSeatsBtn = By.xpath("(//div[@data-travels='Saheel Tours & Travels']//button)[1]");
	By windowSeatckbox = By
			.xpath("//div[@data-travels='Saheel Tours & Travels']//div[@class='seats_row']/div[1]/div[8]");
	By nonwindowSeatckBox = By
			.xpath("//div[@data-travels='Saheel Tours & Travels']//div[@class='seats_row']/div[2]/div[8]");
	By boardingPointlstBox = By.id("bp");
	By droppingPointlstBox = By.id("dp");
	By continueBtn = By.xpath("//form[@id='booking_form']/button[text()='CONTINUE BOOKING']");

	public PassengerDetailsPage selectDetailsonsearchresult(String boardingppoint, String droppingpoint)
			throws IOException {
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

	public PassengerDetailsPage selectDetailsonsearchresult(String travels, String seats, String boardingppoint,
			String droppingpoint) {
		driver.findElement(modalclosebtn).click();
		driver.findElement(By.xpath("//div[@data-travels='" + travels + "']")).click();
		Wait.until(ExpectedConditions.elementToBeClickable(
				driver.findElement(By.xpath("(//div[@data-travels='" + travels + "']//button)[1]"))));
		driver.findElement(By.xpath("(//div[@data-travels='" + travels + "']//button)[1]")).click();
		Wait.until(ExpectedConditions.visibilityOfElementLocated(boardingPointlstBox));
		selectSeats(travels, seats);
		Select chooseboardingpoint = new Select(driver.findElement(boardingPointlstBox));
		chooseboardingpoint.selectByVisibleText(boardingppoint);
		Select choosedroppingpoint = new Select(driver.findElement(droppingPointlstBox));
		choosedroppingpoint.selectByVisibleText(droppingpoint);
		try {
			TestUtil.takeScreenshotAt("SearchResult");
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.findElement(continueBtn).click();
		return new PassengerDetailsPage();
	}

	public void selectSeats(String travels, String seats) {
		String[] requiredSeats = seats.split(",");
		for (String s : requiredSeats) {
			//// div[@class='seats_row']/div[1]/div[contains(@data-seat,'available":"true')
			//// and contains(@data-seat,'"name":"D1"')]
			try {
				driver.findElement(By.xpath("//div[@data-travels='" + travels
						+ "']//div[@class='seats_row']/div[@class='col-xs-12']/div[contains(@data-seat,'\"name\":\"" + s
						+ "\"') and contains(@data-seat,'available\":\"true')]")).click();

			} catch (NoSuchElementException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}

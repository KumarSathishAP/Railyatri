package com.railyatri.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.railyatri.qa.base.TestBase;

public class PassengerDetailsPage extends TestBase {
By passenger1Txtbox = By.id("name_1");
By passenger1Age = By.id("age_1");
By passenger1Gender = By.id("gender_1");
By passenger2Txtbox =By.id("name_2");
By passenger2Age =By.id("age_2");
By passenger2Gender = By.id("gender_2");
By continuebtn = By.id("btnEndStep1");

public void enterPassenger1Details(String p1Name,String p1Age,String p1Gender)
{
	driver.findElement(passenger1Txtbox).sendKeys(p1Name);
	driver.findElement(passenger1Age).sendKeys(p1Age);
	Select chooseGender = new Select(driver.findElement(passenger1Gender));
	chooseGender.selectByValue(p1Gender);
}
public void enterPassenger2Details(String p2Name,String p2Age,String p2Gender)
{
	driver.findElement(passenger2Txtbox).sendKeys(p2Name);
	driver.findElement(passenger2Age).sendKeys(p2Age);
	Select chooseGender = new Select(driver.findElement(passenger1Gender));
	chooseGender.selectByValue(p2Gender);
}
public ReviewPage clickContinuebtn()
{
	driver.findElement(continuebtn).click();
	return new ReviewPage();
}
}

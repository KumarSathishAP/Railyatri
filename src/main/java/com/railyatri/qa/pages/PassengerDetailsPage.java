package com.railyatri.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.railyatri.qa.base.TestBase;

public class PassengerDetailsPage extends TestBase {
By continuebtn = By.id("btnEndStep1");

public void enterPassengerDetails(String passenger, String pName,String pAge,String pGender)
{
	driver.findElement(By.id("name_"+passenger)).sendKeys(pName);
	driver.findElement(By.id("age_"+passenger)).sendKeys(pAge);
	Select chooseGender = new Select(driver.findElement(By.id("gender_"+passenger)));
	chooseGender.selectByValue(pGender);
}

public ReviewPage clickContinuebtn()
{
	driver.findElement(continuebtn).click();
	return new ReviewPage();
}
}

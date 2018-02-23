package com.railyatri.qa.testcases;

import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.railyatri.qa.base.TestBase;
import com.railyatri.qa.pages.BusSearchPage;
import com.railyatri.qa.pages.BusSearchResultPage;
import com.railyatri.qa.pages.HomePage;
import com.railyatri.qa.pages.LoginPage;
import com.railyatri.qa.pages.PassengerDetailsPage;
import com.railyatri.qa.pages.ReviewPage;
import com.railyatri.qa.utils.TestUtil;

public class FlowTest extends TestBase {
	LoginPage login;
	HomePage homepage;
	BusSearchPage busSearchPage;
	BusSearchResultPage busSearchResultPage;
	PassengerDetailsPage passengerDetailsPage;
	ReviewPage reviewPage;
	TestUtil testUtils;
	String sheetName = "Details";

	public FlowTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		login = new LoginPage();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

	@DataProvider
	public Object[][] getPassengerTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(dataProvider = "getPassengerTestData")
	public void loginPageTitleTest(String source, String destination, String travellers, String boardingpoint,
			String droppingpoint, String p1Name, String p1age, String p1Gender, String p2Name, String p2age,
			String p2Gender, String boardingpttxt) throws IOException {
		String title = login.validateTitle();
		System.out.println(title);
		TestUtil.takeScreenshotAt(title);
		homepage = login.Login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.validateLoginuserName();
		busSearchPage = homepage.clickBusBookingBtn();
		busSearchPage.enterTxtinSource(source);
		busSearchPage.enterTxtinDestination(destination);
		busSearchPage.chooseTravellers(travellers);
		TestUtil.takeScreenshotAt("SearchPage");
		busSearchResultPage = busSearchPage.clickSearchBtn();
		passengerDetailsPage = busSearchResultPage.selectDetailsonsearchresult(boardingpoint, droppingpoint);
		passengerDetailsPage.enterPassenger1Details(p1Name, p1age, p1Gender);
		passengerDetailsPage.enterPassenger2Details(p2Name, p2age, p2Gender);
		TestUtil.takeScreenshotAt("PassengerDetailsPage");
		reviewPage = passengerDetailsPage.clickContinuebtn();
		reviewPage.reviewDetails(boardingpttxt);
		reviewPage.cancelTrasaction();
		homepage.logout();

	}

}

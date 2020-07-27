package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.NdtvWeather;
import com.crm.qa.util.TestUtil;


/**
 * @author Lav Gupta
 * @date 27-Jul-2020
 * @description Starting Point of the test cases execution.
 */
public class QuantinstiVerification extends TestBase {

	TestUtil testUtil;
	HomePage homepage;
	String classname;

	public QuantinstiVerification() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		homepage=new HomePage();
	}

	@Test(priority=1)
	public void verifyQuantinstiVerificationTestScenarios()
	{
		homepage.loginIntoSite();
		homepage.MoveToDesireCoursePage();
		homepage.clickOnEnrollNowButton();
		homepage.verifyAndPrintsAllDesireDetails();
		
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}

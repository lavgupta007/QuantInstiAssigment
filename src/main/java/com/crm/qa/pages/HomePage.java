package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

/**
 * @author Lav Gupta
 * @date 27-Jul-2020
 * @description Page Object Repository for HOME_PAGE
 */
public class HomePage extends TestBase {

	public static String topbusinesshref,buttombusinesshref;
	public static List<String> listbusinesshref = null;
	TestUtil testUtil = new TestUtil();

	// POM with method type
	public static WebElement loginButton(){
		return driver.findElement(By.xpath("//button[@class='vue-ui-button vue-ui-button btn secondary button']"));
	}

	public static WebElement userName(){
		return driver.findElement(By.xpath("//input[@placeholder='Email ID']"));
	}

	public static WebElement password(){
		return driver.findElement(By.xpath("//input[@placeholder='Password']"));
	}

	public static WebElement submitButton(){
		return driver.findElement(By.xpath("//button[@type='submit']"));
	}


	public static WebElement browseCourses(){
		return driver.findElement(By.xpath("//a[contains(text(),'Browse Courses')]"));
	}

	public static WebElement SentimentAnalysisInTrading(){
		return driver.findElement(By.xpath("//span[contains(text(),'Sentiment Analysis in Trading')]"));
	}


	public static WebElement coursesHeading(){
		return driver.findElement(By.xpath("//h1"));
	}

	public static WebElement coursesPrice(){
		return driver.findElement(By.xpath("//div[@class='cd__data-unit__info']/span[2]/*"));
	}

	public static WebElement enrollNowButton(){
		return driver.findElement(By.xpath("//button[@class='vue-ui-button btn button secondary']//span[@class='default-slot'][contains(text(),'Enroll Now')]"));
	}


	public static List<WebElement> coursesInCart(){
		return driver.findElements(By.xpath("//div[@class='cart-item']"));
	}


	public static WebElement cartCount(){
		return driver.findElement(By.xpath("//span[@class='cart-count']"));
	}


	public static List<WebElement> summaryAmountList(){
		return driver.findElements(By.xpath("//div[@class='cart-summary-right']"));
	}

	public static WebElement viewDetails(){
		return driver.findElement(By.xpath("//div[@class='cart-item-cta']/a[1]"));
	}

	public static WebElement removeLink(){
		return driver.findElement(By.xpath("//div[@class='cart-item-cta']/a[2]"));
	}

	public static WebElement toastMessage(){
		return driver.findElement(By.xpath("//div[@class='toasted toasted-primary info']"));
	}

	public static WebElement applyCoupon(){
		return driver.findElement(By.xpath("//span[contains(text(),'Apply Coupon')]"));
	}

	public static WebElement typeCouponCode(){
		return driver.findElement(By.xpath("//input[@placeholder='Type coupon code']"));
	}


	public static WebElement applyCouponButton(){
		return driver.findElement(By.xpath("//div[@class='coupon-form__button']//button[@class='vue-ui-button btn secondary ghost-button']"));
	}


	public static WebElement couponAlert(){
		return driver.findElement(By.xpath("//div[@class='coupon-alert-box']//span"));
	}

	public static WebElement closeCouponButton(){
		return driver.findElement(By.xpath("//button[@class='close']"));
	}

	public static WebElement profileInitials(){
		return driver.findElement(By.xpath("//div[@class='profile-pic-initials']"));
	}


	public static WebElement logoutButton(){
		return driver.findElement(By.xpath("//ul[@class='avatar-menu']//a[@class='test link'][contains(text(),'Logout')]"));
	}



	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void loginIntoSite()
	{
		testUtil.waitForElementPresent(loginButton());
		loginButton().click();
		testUtil.waitForElementPresent(userName());
		userName().sendKeys(TestBase.USER_NAME);
		password().sendKeys(TestBase.PASSWORD);
		submitButton().click();
		TestUtil.wait(3);
	}

	public void MoveToDesireCoursePage()
	{
		testUtil.waitForElementPresent(browseCourses());
		browseCourses().click();
		testUtil.waitForElementPresent(SentimentAnalysisInTrading());
		SentimentAnalysisInTrading().click();
		TestUtil.wait(3);
		testUtil.waitForElementPresent(coursesHeading());
		System.out.println("**************** Successfully Landed on sentiment-analysis-trading Page ****************");
		System.out.println("Course Name is : "+ coursesHeading().getText());
		System.out.println("Course Price is : "+ coursesPrice().getText());
	}

	public void clickOnEnrollNowButton()
	{
		enrollNowButton().click();
		testUtil.waitForElementPresent(removeLink());
		System.out.println("**************** Successfully Landed on CART Page ****************");
	}

	public void verifyAndPrintsAllDesireDetails()
	{
		System.out.println("************************************************************************************************");
		System.out.println("Courses added count in the cart list are : "+ coursesInCart().size());
		System.out.println("Courses count on the cart icon are : "+ cartCount().getText());
		if(coursesInCart().size()== Integer.parseInt(cartCount().getText().trim()))
			System.out.println("Courses count are matched with the cart icon count successfully");
		else
			System.out.println("Courses count are not matched with the cart icon count");
		System.out.println("Base Amount value on summary section is : "+ summaryAmountList().get(0).getText());
		System.out.println("Amount Payable value on summary section is : "+ summaryAmountList().get(3).getText());
		String parentwindow=driver.getWindowHandle();
		viewDetails().click();
		TestUtil.wait(3);
		for (String window : driver.getWindowHandles())
		{
			if (!window.equals(parentwindow))
			{
				driver.switchTo().window(window);
				System.out.println("Switch To Child Window");
				System.out.println("View Details New opened window title is : "+ driver.getTitle());
				driver.close();
				driver.switchTo().window(parentwindow);
				System.out.println("Switch To Parent Window");
			}
		}
		testUtil.waitForElementPresent(removeLink());
		removeLink().click();
		testUtil.waitForElementPresent(toastMessage());
		System.out.println("Remove Toast Message Text is : "+toastMessage().getText());
		testUtil.waitForElementPresent(applyCoupon());
		applyCoupon().click();
		TestUtil.wait(3);
		testUtil.waitForElementPresent(applyCouponButton());
		typeCouponCode().sendKeys("ABC");
		applyCouponButton().click();
		testUtil.waitForElementPresent(couponAlert());
		System.out.println("Coupon Code Alert Message is : "+couponAlert().getText());
		closeCouponButton().click();
		TestUtil.wait(3);
		if(driver.findElements(By.xpath("//*[@class='web-push-btn sure-btn']")).size()>0)
			driver.findElement(By.xpath("//*[@class='web-push-btn sure-btn']")).click();
		testUtil.waitForElementPresent(profileInitials());
		profileInitials().click();
		testUtil.waitForElementPresent(logoutButton());
		logoutButton().click();
		System.out.println("************************************************************************************************");
	}
}

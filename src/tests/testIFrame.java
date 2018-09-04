//Deputy Test Automation technical challenge
//Author: Sat Kandhaswami

package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.NewEmployeeDetails;
import utilities.ScreenShot;
import utilities.mailValidation;

public class testIFrame {
	public static WebDriver	driver;
	private mailValidation mv = new mailValidation();

	//Launching Chrome and opening Web page
	
	@BeforeTest
	public void beforeTest()	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/browser/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://foodcourt.au.deputy.com/");	
	}
	
	@Test
	public void addNewEmployee() {
		
	//Login with username & password
	LoginPage.userName(driver).sendKeys("testautomation+andrew@deputy.com");
	LoginPage.password(driver).sendKeys("deputy22%");
	LoginPage.loginButton(driver).click();
	
	//Navigating to schedule tab
	HomePage.scheduleTab(driver).click();
	
	//Finding out the iFrame and tapping on Add new employee.
	int size = driver.findElements(By.tagName("iframe")).size();
	System.out.println("No. of iFrames: "+size);
		for(int i= 0; i<size; i++){
			driver.switchTo().frame(i);	
			if(driver.findElements(By.xpath("//*[@id='roster-emp-list-wrapper']/ul/a/li/div/div")).size()!=0)
			driver.findElement(By.xpath("//*[@id='roster-emp-list-wrapper']/ul/a/li/div/div")).click();
			driver.switchTo().defaultContent();			
		}
		
		//Filling new employee details
		NewEmployeeDetails.firstName(driver).sendKeys("Sat");
		NewEmployeeDetails.lastName(driver).sendKeys("Kandhaswami");
		NewEmployeeDetails.email(driver).sendKeys("sattester7@gmail.com");
		NewEmployeeDetails.profilePhoto(driver).click();
		NewEmployeeDetails.saveDetails(driver).click();
	
	}
	
	@Test
	
	//To click on the confirmation email
	public void registrationConfirmation() throws Exception{	
		driver = new ChromeDriver();
		driver.get(mv.getUrl());		
	}
	
	//To capture failure Screenshots
	
	@AfterMethod
	public void tearDown(ITestResult result){
		if(ITestResult.FAILURE==result.getStatus()){
			ScreenShot.capture(driver, result.getName());
		}
		driver.close();
	}
	
	@AfterSuite
	public void afterTest(){
		driver.quit();
	}
	
	
}


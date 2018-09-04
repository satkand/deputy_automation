//Deputy Test Automation technical challenge
//Author: Sat Kandhaswami

package tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.NewEmployeeDetails;
import utilities.mailValidation;

public class testIFrame {
	public static WebDriver	driver;
	private mailValidation mv = new mailValidation();

	//Launching Chrome and opening Web page
	
	@BeforeTest
	public void beforeTest()	
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/browser/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://foodcourt.au.deputy.com/");	
	}
	
	@Test
	public void test() throws IOException {
		
		try
		{
			
		
	//Login with username & password
	LoginPage.userName(driver).sendKeys("testautomation+andrew@deputy.co");
	LoginPage.password(driver).sendKeys("deputy22%");
	LoginPage.loginButton(driver).click();
	
	//Navigating to schedule tab
	HomePage.scheduleTab(driver).click();
	
	//Finding out the iFrame and tapping on Add new employee.
	int size = driver.findElements(By.tagName("iframe")).size();
	System.out.println("No. of iFrames: "+size);
		for(int i= 0; i<size; i++)
		{
			driver.switchTo().frame(i);	
			if(driver.findElements(By.xpath("//*[@id='roster-emp-list-wrapper']/ul/a/li/div/div")).size()!=0)
			driver.findElement(By.xpath("//*[@id='roster-emp-list-wrapper']/ul/a/li/div/div")).click();
			driver.switchTo().defaultContent();			
		}
		
		//Filling new employee details
		NewEmployeeDetails.firstName(driver).sendKeys("Sat");
		NewEmployeeDetails.lastName(driver).sendKeys("Kandhaswami");
		NewEmployeeDetails.email(driver).sendKeys("sateer7@gmail.com");
		NewEmployeeDetails.profilePhoto(driver).click();
		
		//String filePath = "C:/Users/Sathish Kumar/Desktop/27630.png";
		//WebElement chooseFile= driver.findElement(By.xpath(".//*[@id='pnlTeamProfilePhoto']/div/div/div[2]/a"));
		//chooseFile.sendKeys(filePath);
		NewEmployeeDetails.saveDetails(driver).click();
		
		Assert.assertTrue(NewEmployeeDetails.profileCreated(driver).isDisplayed());
		
		//driver.quit();
		//driver = new ChromeDriver();
		
		//driver.get(mv.getUrl());	
		
		}catch (Exception e){
			File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File("./screenshots" + System.currentTimeMillis() + "screen.jpg"));
		}
	}
	
	/*@AfterTest
	
	public void afterTest()
	{
		driver.quit();
	}
	*/
	
}


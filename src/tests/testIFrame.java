//Deputy Test Automation technical challenge
//Author: Sat Kandhaswami

package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.homePage;
import pages.loginPage;
import pages.newEmployeeDetails;

public class testIFrame {
	public static WebDriver	driver;

	//Launching Chrome and opening Web page
	
	@BeforeTest
	public void beforeTest()	
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/browser/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://foodcourt.au.deputy.com/");	
	}
	
	@Test
	public void test() {
		
	//Login with username & password
	loginPage.userName(driver).sendKeys("testautomation+andrew@deputy.com");
	loginPage.password(driver).sendKeys("deputy22%");
	loginPage.loginButton(driver).click();
	
	//Navigating to schedule tab
	homePage.scheduleTab(driver).click();
	
	//Finding out the iFrame and tapping on Add new employee.
	int size = driver.findElements(By.tagName("iframe")).size();
	System.out.println("Team: "+size);
		for(int i= 0; i<size; i++)
		{
			driver.switchTo().frame(i);	
			if(driver.findElements(By.xpath("//*[@id='roster-emp-list-wrapper']/ul/a/li/div/div")).size()!=0)
			driver.findElement(By.xpath("//*[@id='roster-emp-list-wrapper']/ul/a/li/div/div")).click();
			driver.switchTo().defaultContent();			
		}
		
		//Filling new employee details
		newEmployeeDetails.firstName(driver).sendKeys("Sat");
		newEmployeeDetails.lastName(driver).sendKeys("Kandhaswami");
		newEmployeeDetails.email(driver).sendKeys("sattester7@gmail.com");
		newEmployeeDetails.profilePhoto(driver).click();
		
		//String filePath = "C:/Users/Sathish Kumar/Desktop/27630.png";
		//WebElement chooseFile= driver.findElement(By.xpath(".//*[@id='pnlTeamProfilePhoto']/div/div/div[2]/a"));
		//chooseFile.sendKeys(filePath);
		newEmployeeDetails.saveDetails(driver).click();
	}
	
	@AfterTest
	
	public void afterTest()
	{
		driver.quit();
	}
	
	
}


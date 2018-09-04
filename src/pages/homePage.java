package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Page Objects of Home page & Schedule Tab

public class homePage {

private static WebElement element = null;
	
	public static WebElement scheduleTab(WebDriver driver) {		
		element = driver.findElement(By.xpath("//*[@id='roster-nav']/a/span"));
		return element;
	}
	
	public WebElement addEmployeeTab(WebDriver driver) {		
		By addEmployee = By.xpath("//div[@class =\"media-block-content u-link\"]");
		return driver.findElement(addEmployee);
	}
	
}

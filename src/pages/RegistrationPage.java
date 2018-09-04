package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
	
private static WebElement element = null;
	
	public static WebElement emailInput(WebDriver driver) {		
		element = driver.findElement(By.xpath("//*[@id=\"login-email\"]"));
		return element;
	}
	public static WebElement passwordInput(WebDriver driver) {		
		element = driver.findElement(By.xpath("//*[@id=\"login-password\"]"));
		return element;
	}
	
	public static WebElement loginButton(WebDriver driver) {		
		element = driver.findElement(By.xpath("//*[@id=\"btnLoginSubmit\"]"));
		return element;
	}
	

}

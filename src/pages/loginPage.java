package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Page Objects of Login page

public class loginPage {
	
	private static WebElement element = null;
	
	public static WebElement userName(WebDriver driver) {		
		element = driver.findElement(By.xpath("//*[@id='login']"));
		return element;
	}
	
	public static WebElement password(WebDriver driver) {		
		element = driver.findElement(By.xpath("//*[@id='password']"));
		return element;
	}
	
	public static WebElement loginButton(WebDriver driver) {		
		element = driver.findElement(By.xpath("//*[@id='btnLogin']"));
		return element;
	}
	

}

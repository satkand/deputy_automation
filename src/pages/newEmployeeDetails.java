package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Page Objects of Add new Employee 

public class NewEmployeeDetails {
	
private static WebElement element = null;
	
	public static WebElement firstName(WebDriver driver) {		
		element = driver.findElement(By.xpath(".//*[@id='txtTeamProfileEditFirstName']"));
		return element;
	}
	
	public static WebElement lastName(WebDriver driver) {		
		element = driver.findElement(By.xpath(".//*[@id='txtTeamProfileEditLastName']"));
		return element;
	}
	
	public static WebElement email(WebDriver driver) {		
		element = driver.findElement(By.xpath(".//*[@id='txtTeamProfileEditEmail']"));
		return element;
	}
	
	public static WebElement profilePhoto(WebDriver driver) {		
		element = driver.findElement(By.xpath(".//*[@id='pnlTeamEditView']/div[1]/ul/li[3]/a"));
		return element;
	}
	
	public static WebElement saveDetails(WebDriver driver) {		
		element = driver.findElement(By.xpath(".//*[@id='btnTeamProfileSave']"));
		return element;
	}
	
	public static WebElement profileCreated(WebDriver driver) {		
		element = driver.findElement(By.xpath("//*[@id=\"pnlTeamProfileView\"]/div[1]/div[1]/div[2]/div[2]/small"));
		return element;
	}
	

}

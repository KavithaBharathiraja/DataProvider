package TestCase;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import dataProvider.readExcel;
import io.github.bonigarcia.wdm.WebDriverManager;

public class loginTest {
	static WebDriver driver;
	
	@Test (dataProvider = "login", dataProviderClass=readExcel.class)
	

	public void salesforcepage (String userName, String Password) 
	{
	//System.out.printIn(userName + Password );
	WebDriverManager .chromedriver ().setup();
	driver=new ChromeDriver ();
	driver.get("https://login.salesforce.com");
	
	WebElement username=driver.findElement(By.id("username"));
	username. sendKeys (userName);
	
	WebElement password =driver.findElement (By.id("password"));
	password.sendKeys(Password);
	
	WebElement login= driver.findElement(By.id("Login"));
	login.click();
	
	Assert.assertTrue(driver.findElement(By.id("userNavButton")).isDisplayed());
	try {
	Thread. sleep (4000);
	} catch (InterruptedException e) { 
	// TODO Auto-generated catch block
	e.printStackTrace ();
	} 
	driver.quit();
	
}
}

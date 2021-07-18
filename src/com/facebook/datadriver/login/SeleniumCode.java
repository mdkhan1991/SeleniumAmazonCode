package com.facebook.datadriver.login;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;



public class SeleniumCode {
	public static ChromeDriver driver;
	
	public static void launchBrowser() {
		
		String	path=System.getProperty("user.dir");
		
		
		
		System.setProperty("webdriver.chrome.driver", path+"\\jars\\chromedriver.exe");
		
		
		 driver	=new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		
	}
	
public static void amazonPuchaseFlow(ChromeDriver driver) throws InterruptedException {
	
//Search for QA testing Books and click to search
	 WebElement searchBox=driver.findElementById("twotabsearchtextbox");
	 searchBox.sendKeys("qa testing for beginners");	 
	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); WebElement
	 searchClick =driver.findElementByXPath("//input[@type='submit']");
	 searchClick.click();
	  
	  
//Click to first book to the link visible	 
	  List<WebElement> elementsLink =driver.findElementsByXPath("//*[@id=\"search\"]//h2/a"); WebElement
	  firstElement = elementsLink.get(0); firstElement.click();
	  
	  
//Verify the visibility of price	  
	  WebElement price= driver.findElementByXPath("//span[@id='newBuyBoxPrice']");	  
	  String priceOfBook1 =price.getText();	  
	  Assert.assertTrue("Price is not displayed", price.isDisplayed());
	  
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	
	  
//clicking to Add cart button	  
	  WebElement addToCart=driver.findElementByXPath("//input[@id='add-to-cart-button']");
	  addToCart.click();	  
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  
//Verification of price same as the price visible on first page before adding to cart	  
	  WebElement price2= driver.findElementByXPath("//*[@id=\"hlb-subcart\"]//span/span[2]"); String
	  priceOfBook2 =price2.getText();	  
	  if(priceOfBook1.equals(priceOfBook2)) {
	  Assert.assertTrue("Price is not equal displayed", price2.isDisplayed());
	  
	  }
	  
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//Click to proceed to checkOut 
	  
	  WebElement proceedtocheckOut=driver.findElementByXPath("//*[@id=\"hlb-ptc-btn\"]");
	  proceedtocheckOut.click();
		
		
	}
	
	
	

	public static void main(String[] args) throws InterruptedException {
		launchBrowser();
		amazonPuchaseFlow(driver);
		

	
	}

}

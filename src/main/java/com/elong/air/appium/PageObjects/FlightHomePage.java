package com.elong.air.appium.PageObjects;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

import com.elong.air.appium.base.BasePage;

public class FlightHomePage extends BasePage{
 public FlightHomePage(AndroidDriver driver){
	 super(driver);
 }
 @FindBy(css=".choose-btn.start>span")
 public WebElement startCity;
 
 @FindBy(css=".choose-btn.end>span")
 public WebElement arriveCity;
 
 @FindBy(xpath="//div[@class='date-region start-date']/span")
 public WebElement startDate;
 
 @FindBy(xpath="//div[@class='date-region end-date']/span")
 public WebElement returnDate;
 
 @FindBy(css=".search-box>input")
 public WebElement searchInputText;
 
 @FindBy(xpath="//button[@id='doSearch']")
 public WebElement searchButton;
 
 @FindBy(css="[data-type=round]")
 public WebElement roundType;
 
 @FindBy(xpath="//ul[@class='match-list']/li")
 public List<WebElement> matchList;
 
 public void chooseStartCity(String City) throws Exception{
	 click(startCity);
	 chooseCity(City);
 }
 public void chooseArriverCity(String City) throws Exception{
	 click(arriveCity);
	 chooseCity(City);
 }
  public void chooseCity(final String city) throws Exception{
	  setInputText(searchInputText,city);
	 
	try{  
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver arg0) {
			boolean falg=arg0.findElement(By.xpath("//ul[@class='match-list' and @style='display: block;']")).isDisplayed();
			return falg;
				
			}
		});
	
	 	for(WebElement e:matchList){
			 if(e.getText().equals(city)){
				 System.out.println("getText"+e.getText());
				 click(e);
			 }
		 }
		
	}catch (Exception e){
			 throw new Exception("找不到"+city+"这个城市");
		 }
		 
  }
  public void chooseStartDate(String date){
	    click(startDate);
//		String str = "document.getElementsByClassName('date-region start-date')[0].firstElementChild.setAttribute= '"+date+"'";
//		String str2 = "document.getElementsByClassName('date-region start-date')[0].firstElementChild.getAttribute";
	
//		((JavascriptExecutor)driver).executeScript(str,startDate);
	    String xpath="//div[@class='cld page-plugin plugin-inited cld-active plugin-show']//li[@data-day='"+date+"']";
	    driver.findElement(By.xpath(xpath)).click();
		
  }
  public void chooseReturnDate(String date){
	    click(returnDate);
	   String xpath="//div[@class='cld page-plugin plugin-inited cld-active plugin-show']//li[@data-day='"+date+"']";
	    driver.findElement(By.xpath(xpath)).click();
  }
  public AirListPage searchButton() throws InterruptedException{
	String str="  document.getElementById(\"doSearch\").click()";
	((JavascriptExecutor)driver).executeScript(str);
	return new AirListPage(driver);
  }

}

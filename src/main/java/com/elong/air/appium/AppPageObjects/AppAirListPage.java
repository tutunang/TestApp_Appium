package com.elong.air.appium.AppPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import com.elong.air.appium.base.BaseAppPage;

public class AppAirListPage extends BaseAppPage{
	public AppAirListPage(AppiumDriver driver){
		super(driver);
	}
	@FindBy(className="android.widget.LinearLayout")
	public List<WebElement> airline;
	
public SeatPage chooseLine(int t){
	//super.swipeToDown(driver, 2000);

List<WebElement> li=driver.findElementById("com.elong.android.flight:id/flightlist_listswitcher").findElements(By.id("com.elong.android.flight:id/flightlist_item_departtime"));
	     System.out.println("<<<<<<<<"+li.size());
 
         li.get(t).click();      
         return  new  SeatPage(driver);
	

	
	
}
}

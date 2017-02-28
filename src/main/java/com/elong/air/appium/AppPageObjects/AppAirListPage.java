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
	
public void chooseLine(int t){
	//super.swipeToDown(driver, 2000);
	
List<WebElement> li=driver.findElementById("com.elong.android.flight:id/flightlist_listswitcher").findElements(By.id("com.elong.android.flight:id/flightlist_item_departtime"));
	System.out.println("<<<<<<<<"+li.size());
	AndroidDriver	driver1=(AndroidDriver)driver;
driver1.findElementByAndroidUIAutomator("new UiSelector().text(\"Add note\")");  

	
//super.swipeToUp(driver, 8000);
//	System.out.print(airline.size());;
//	for(int i=0;i<=airline.size();i++){
//		if(i==t){
//		airline.get(i).click();
//	}
//		
//	}
	
	
}
}

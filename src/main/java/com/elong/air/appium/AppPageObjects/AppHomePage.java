package com.elong.air.appium.AppPageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.elong.air.appium.base.BaseAppPage;

public class AppHomePage extends BaseAppPage{
public AppHomePage(AppiumDriver driver){
	super(driver);
}
@FindBy(id="com.elong.android.flight:id/flightssearch_leavecity")
public WebElement leaveCity;

public void setInformation(){
	
}

}

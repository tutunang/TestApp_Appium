package com.elong.air.appium.AppPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import com.elong.air.appium.base.BaseAppPage;

public class EnterPage extends BaseAppPage{
public EnterPage(AppiumDriver driver){
	super(driver);
}
@FindBy(id="com.elong.android.home:id/home_module_flight")
public WebElement flightIcon;
public AppHomePage enterToFlight(){
     click(flightIcon);
     return new AppHomePage(driver);
}
}

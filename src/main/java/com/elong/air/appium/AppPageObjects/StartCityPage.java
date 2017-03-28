package com.elong.air.appium.AppPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;

import com.elong.air.appium.base.BaseAppPage;
import com.elong.air.appium.bean.SearchConditionBean;

public class StartCityPage extends BaseAppPage{
public StartCityPage(AppiumDriver driver){
	super(driver);
	
}
@FindBy(id="com.elong.android.flight:id/city_select_search")
public WebElement inputCityTextField;

public void clicky(SearchConditionBean sb){
	setInputText(inputCityTextField, sb.getStart_city());
}
}

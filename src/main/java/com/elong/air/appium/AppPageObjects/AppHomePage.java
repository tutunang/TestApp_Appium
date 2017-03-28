package com.elong.air.appium.AppPageObjects;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.elong.air.appium.base.BaseAppPage;
import com.elong.air.appium.bean.SearchConditionBean;

public class AppHomePage extends BaseAppPage{
public AppHomePage(AppiumDriver driver){
	super(driver);
}
@FindBy(id="com.elong.android.flight:id/flightssearch_leavecity")
public WebElement leaveCityItem;

@FindBy(id="com.elong.android.flight:id/city_select_search")
public WebElement inputCityTextField;

@FindBy(id="com.elong.android.flight:id/flightssearch_arrivecity")
public WebElement arriveCityItem;

@FindBy(id="com.elong.android.flight:id/flight_search_bottomtab_domestic")
public WebElement listItem;

@FindBy(id="com.elong.android.flight:id/flightsearch_leave_date")
public WebElement startDateItem;

@FindBy(id="com.elong.android.flight:id/rb_search_tab_round")
public WebElement travelType;

@FindBy(id="com.elong.android.flight:id/flightsearch_submit")
public WebElement searchButton;

public AppAirListPage setInformation(SearchConditionBean sb) throws Exception{

	click(leaveCityItem);
	setInputText(inputCityTextField, sb.getStart_city());
	click(listItem);
	click(arriveCityItem);
    setInputText(inputCityTextField, sb.getEnd_city());
	click(listItem);

	if(sb.getTravel_type().equals("round")){
		click(travelType);
	}

	click(searchButton);

	return new AppAirListPage(driver);
	
}
public void setDate(int daysAfter){
	Calendar calendar2 = Calendar.getInstance();
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
	calendar2.add(Calendar.DATE, daysAfter);
	String three_days_after = sdf2.format(calendar2.getTime());
	System.out.println(three_days_after);
	String ss=three_days_after.substring(6, 8);
	System.out.println(ss);
	if(ss.startsWith("0")){
		String targetDate=ss.substring(1);
		driver.findElementByXPath("//android.widget.TextView[contains(@text,'"+targetDate+"')]").click();
	System.out.println(	ss.substring(1));
	}else{
		System.out.println(ss);
		driver.findElementByXPath("//android.widget.TextView[contains(@text,'"+ss+"')]").click();

		
		//	((AndroidDriver) driver).findElementByAndroidUIAutomator("new UiSelector().text(\"今天\")").click();
	}
	



}
}



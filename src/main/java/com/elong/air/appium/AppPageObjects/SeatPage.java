package com.elong.air.appium.AppPageObjects;

import io.appium.java_client.AppiumDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.elong.air.appium.base.BaseAppPage;

public class SeatPage extends BaseAppPage{
	
public SeatPage(AppiumDriver driver){
	super( driver);
}
@FindBy(id="com.dp.android.elong:id/common_head_title")
public WebElement loginTitle;

@FindBy(id="com.elong.android.flight:id/next")
public WebElement inputInfoTitle;



public  <T extends BaseAppPage>  T bookSeat(int i){
List<WebElement>li=driver.findElement(By.id("com.elong.android.flight:id/lv_flights_info")).findElements(By.id("com.elong.android.flight:id/hotel_list_filter_submit"));
System.out.println(li.size());
;
click(li.get(i));
try{
	if(loginTitle.isDisplayed()){
		return (T) new LoginPage(driver);
}
	}
catch(Exception e){
	   return (T) new InputInfoPage(driver);
}
return null;
}



}



 
package com.elong.air.appium.AppPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

import com.elong.air.appium.base.BaseAppPage;

public class SeatPage extends BaseAppPage{
	
public SeatPage(AppiumDriver driver){
	super( driver);
}
public void bookSeat(int i){
List<WebElement>li=driver.findElement(By.id("com.elong.android.flight:id/lv_flights_info")).findElements(By.id("com.elong.android.flight:id/hotel_list_filter_submit"));
System.out.println(li.size());
li.get(i);
}


}
 
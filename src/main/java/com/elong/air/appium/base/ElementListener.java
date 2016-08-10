package com.elong.air.appium.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.events.api.general.ElementEventListener;

public class ElementListener implements ElementEventListener {

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void afterClickOn(WebElement arg0, WebDriver arg1) {
	System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>");
		
	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>");
		
	}

}

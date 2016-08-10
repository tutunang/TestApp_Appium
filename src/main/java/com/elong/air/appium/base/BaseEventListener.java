package com.elong.air.appium.base;
import io.appium.java_client.events.api.general.AppiumWebDriverEventListener;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * 
 * @author wenjing.du
 * @date 2016-06-29
 * 
 */

public class BaseEventListener implements AppiumWebDriverEventListener {
	protected Logger log = Logger.getLogger(this.getClass());

	public void beforeNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable throwable, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

//	public void beforeNavigateTo(String url, WebDriver driver) {
//		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>");
//		
//	}
//
//	public void afterNavigateTo(String url, WebDriver driver) {
//		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>");
//		
//	}
//
//	public void beforeNavigateBack(WebDriver driver) {
//		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>");
//		
//	}
//
//	public void afterNavigateBack(WebDriver driver) {
//		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>");
//		
//	}
//
//	public void beforeNavigateForward(WebDriver driver) {
//		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>");
//		
//	}
//
//	public void afterNavigateForward(WebDriver driver) {
//		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>");
//		
//	}
//
//	public void beforeNavigateRefresh(WebDriver driver) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void afterNavigateRefresh(WebDriver driver) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void afterFindBy(By by, WebElement element, WebDriver driver) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void beforeClickOn(WebElement element, WebDriver driver) {
//		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>");
//		log.debug("------点击页面元素的文本是："+element.getText()+"------");
//		((JavascriptExecutor) driver).executeScript(
//				"arguments[0].style.border=\"5px solid red\"", element);
//		
//	}
//
//	public void afterClickOn(WebElement element, WebDriver driver) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void afterChangeValueOf(WebElement element, WebDriver driver) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void beforeScript(String script, WebDriver driver) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void afterScript(String script, WebDriver driver) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void onException(Throwable throwable, WebDriver driver) {
//		// TODO Auto-generated method stub
//		
//	}
//	
	
}

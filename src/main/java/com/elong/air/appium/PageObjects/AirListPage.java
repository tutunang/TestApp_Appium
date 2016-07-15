package com.elong.air.appium.PageObjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

import com.elong.air.appium.base.BaseAppPage;

public class AirListPage extends BaseAppPage{
public AirListPage(AndroidDriver driver){
	super(driver);
}
@FindBy(xpath="//ul[@class='list']/li")
public List<WebElement> airList;




public void chooseAirPlan(){
	WebDriverWait wait = new WebDriverWait(driver, 100);
	wait.until(new ExpectedCondition<Boolean>() {
		public Boolean apply(WebDriver arg0) {
		boolean falg=arg0.findElement(By.xpath("//ul[@class='list']")).isDisplayed();
		return falg;
		}
	});

//	driver.findElement(By.xpath("//ul[@class='list']/"+"li['"+i+"']")).click();
	Random random = new Random();
    int a=random.nextInt(airList.size());
	String str="document.getElementsByClassName('list')[0].children['"+a+"'].click()";
	((JavascriptExecutor)driver).executeScript(str);
}
}
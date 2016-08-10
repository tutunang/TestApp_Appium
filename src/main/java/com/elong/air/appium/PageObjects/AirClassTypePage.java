package com.elong.air.appium.PageObjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import com.elong.air.appium.base.BaseAppPage;

public class AirClassTypePage extends BaseAppPage{
	public AirClassTypePage(AppiumDriver driver){
		super(driver);
	}
	@FindBy(xpath="//ul[@class='list']/li//div[@class='order']/div[2]")
	public List<WebElement> airClassList;
	
	public InputInformationPage chooseClassType() {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver arg0) {
			boolean falg=arg0.findElement(By.xpath("//ul[@class='list']/li//div[@class='order']/div[2]")).isDisplayed();
			return falg;
			}
		});
		Random random = new Random();
		int a = random.nextInt(airClassList.size());
		for (int i = 0; i <= airClassList.size(); i++) {
			if (i == a) {
				airClassList.get(i).click();
				break;
			}

		}
		return new InputInformationPage(driver);
	}

}

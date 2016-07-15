package com.elong.air.appium.PageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.android.AndroidDriver;

import com.elong.air.appium.base.BaseAppPage;

public class InputInformationPage extends BaseAppPage{
public	InputInformationPage(AndroidDriver driver){
	super(driver);
}
@FindBy(xpath="//span[@class='add-icon']")
public WebElement addNew;

@FindBy(css=".person-list.page-plugin.plugin-inited.page-from-right-to-center.plugin-show .title")
public WebElement title;

@FindBy(css=".table-view-cell.right-triangle-icon.to-add-people span:nth-child(1)")
public WebElement addNewPassenger;

@FindBy(css="#order-name")
public WebElement addName;

@FindBy(css="#order-cert-type")
public WebElement cardType;

@FindBy(css="#order-cert-type")
public WebElement birthDate;

@FindBy(xpath="//input[@id='order-cert-number']")
public WebElement cardNumInputText;

@FindBy(xpath="//div[@class='slide-selector plugin-inited selector-active plugin-show']//label[@class='label-radio clearfix']//div[@class='radio-text']")
public List<WebElement> cardTypeList;

public void addNew(String name,String card,String cardNum){
	click(addNew);
	if(title.getText()=="选择乘机人"){
		click(addNewPassenger);
	}
	this.setInputText(addName, name);
	click(cardType);
//	String str="//div[@class='slide-selector plugin-inited selector-active plugin-show']//label[@class='label-radio clearfix']//div[@class='radio-text']";
//	((JavascriptExecutor)driver).executeScript(str);
	
	for(WebElement e:cardTypeList){
		if(e.getText().equals(card)){
			e.click();
		}
	}
	this.setInputText(cardNumInputText, cardNum);
	String str="document.getElementById('birth-date').removeAttribute('readonly')";
	((JavascriptExecutor)driver).executeScript(str);
	
	
}
}
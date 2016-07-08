package com.elong.air.appium.PageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.android.AndroidDriver;

import com.elong.air.appium.base.BasePage;

public class CabinListPage extends BasePage{
	public CabinListPage(AndroidDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//ul[@class='list']//div[@class='clearfix']//div[@class='order']/div[2]")
	public List<WebElement>cabinList;
	
	
	
//随机取一个舱位
	public InputInformationPage getCabinType(){
		Random r=new Random();
	    int a=r.nextInt(cabinList.size());
		String str="document.getElementsByClassName('list')[0].getElementsByClassName('order')['"+a+"'].getElementsByTagName('div')[1].click()";
		((JavascriptExecutor)driver).executeScript(str);
		 return new InputInformationPage(driver);
	
	}
	//按舱位等级取
	public InputInformationPage getCabinTypeByName(int index) throws Exception{
	List<Integer>type=	getAllCabinType();
try{	
	for(int i:type){
		if(i==index){
			String xpath="//ul[@class='list']//div[@class='clearfix']//div[@class='order']/div[@saletype='"+index+"']";
		    driver.findElement(By.xpath(xpath));
		    return new InputInformationPage(driver);
		}
	
	}}catch(Exception e){
		throw new Exception("没有找到指定舱位类型");
	}
	return null;
	}
	//遍历所有舱位类型
	public List<Integer > getAllCabinType(){
		List<Integer> l=new ArrayList();
		for(WebElement e:cabinList){
		String saletype=e.getAttribute("saletype");
		System.out.println(saletype);
	    int a=Integer.parseInt(saletype);
			l.add(a);
			
		}
		return l;
	}
	
}

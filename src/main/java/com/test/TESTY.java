package com.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TESTY {


	public static void main(String[] args) throws Exception {
		AndroidDriver driver;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appPackage", "com.dp.android.elong");  
        capabilities.setCapability("appActivity", "com.elong.activity.others.AppGuidActivity"); 
		 capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");  
         capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"68a3dba");  
         capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4.4");  
       //  capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");  
         driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//         driver.get("http://m.elong.com/flight");
//         driver.swipe(720,0, 720,1280, 1000);
        Thread.sleep(5000);
        
        
        int width=driver.manage().window().getSize().width;
        int height=driver.manage().window().getSize().height;  
        driver.swipe(width/2,height*3/4, width/2,height/4, 1000);
        Thread.sleep(5000);
        driver.findElement(By.id("com.elong.android.home:id/home_module_flight")).click();
        Thread.sleep(5000);
        
        //		  Random random = new Random();
//        int a=random.nextInt(10)+1;
//        System.out.println(a);
	}

}

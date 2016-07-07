package com.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TESTY {


	public static void main(String[] args) throws Exception {
//		AppiumDriver driver;
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		 capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");  
//         capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"68a3dba");  
//         capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4.4");  
//         capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");  
//         driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//         driver.get("http://m.elong.com/flight");
//         driver.swipe(720,0, 720,1280, 1000);
//        Thread.sleep(5000);
		Random random = new Random();
        int a=random.nextInt(10)+1;
    System.out.println(a);
	}

}

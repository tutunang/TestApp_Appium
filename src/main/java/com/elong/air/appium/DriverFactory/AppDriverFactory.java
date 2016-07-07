package com.elong.air.appium.DriverFactory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.elong.air.appium.base.BaseEventListener;
import com.elong.air.appium.tools.OptionFile;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppDriverFactory {
private static AndroidDriver driver;
private static String  platform_Name=OptionFile.readProperties("./src/main/resources/config.properties", "platform_Name");
private static String platform_Version=OptionFile.readProperties("./src/main/resources/config.properties", "platform_Version");
private static String  device_Name=OptionFile.readProperties("./src/main/resources/config.properties", "device_Name");
private static String browser_Name=OptionFile.readProperties("./src/main/resources/config.properties", "browser_Name");
private static String appPackage=OptionFile.readProperties("./src/main/resources/config.properties", "appPackage");
private static String appActivity=OptionFile.readProperties("./src/main/resources/config.properties", "appActivity");
private static String hubURL=OptionFile.readProperties("./src/main/resources/config.properties", "hubURL");
private static String install=OptionFile.readProperties("./src/main/resources/config.properties", "install");
private static String source=OptionFile.readProperties("./src/main/resources/config.properties", "source");
private static String apkPath=OptionFile.readProperties("./src/main/resources/config.properties", "apkPath");	
private static	String url = OptionFile.readProperties("./src/main/resources/config.properties", "visitURL");
public static AndroidDriver setUpDriver() throws Exception  {
	
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    if(source.equals("App")){
	    	if(install.equals("true")){
	    		File file=new File(apkPath);
                capabilities.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
	    	}
	    	  capabilities.setCapability("appPackage", appPackage);  
	          capabilities.setCapability("appActivity", appActivity); 
	          capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platform_Name);  
	          capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,device_Name);  
	          capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platform_Version);  
	          driver = new AndroidDriver(new URL(hubURL), capabilities);
	    }
	    	if(source.equals("H5")){
	    	capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browser_Name); 
	        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platform_Name);  
	        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,device_Name);  
	        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platform_Version);  
	          driver = new AndroidDriver(new URL(hubURL), capabilities);
	         // WebDriver webDriver= registerEvent(driver);
	        //  AndroidDriver adriver=(AndroidDriver)webDriver;
	
			driver.get(url);
			}
	          
		return driver;
	}
private static EventFiringWebDriver registerEvent(AndroidDriver driver) {
	EventFiringWebDriver event = new EventFiringWebDriver(driver);
	BaseEventListener eventlis = new BaseEventListener();
	event.register(eventlis);
	return event;
}

}
package com.elong.air.appium.DriverFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.events.EventFiringWebDriverFactory;
import io.appium.java_client.remote.MobileCapabilityType;
import java.io.File;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.elong.air.appium.base.AlertListener;
import com.elong.air.appium.base.ElementListener;
import com.elong.air.appium.tools.OptionFile;

public class AppDriverFactory {
//private static AppiumDriver driver;
	
	public static void main(String args[]) {
		try {
			AppDriverFactory.setUpDriver();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
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
public static AppiumDriver<?> setUpDriver() throws Exception  {
	AppiumDriver<?> driver=null;
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    if(source.equals("App")){
	    	if(install.equals("true")){
	    		File file=new File(apkPath);
                capabilities.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
	    	}
	    	  capabilities.setCapability("appPackage", appPackage);  
	          capabilities.setCapability("appActivity", appActivity); 
	          capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platform_Name);  
	          //capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
	          capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,device_Name);  
	          capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platform_Version); 
	      	//重置输入法为系统默认
	          capabilities.setCapability("unicodeKeyboard", "True");
	          capabilities.setCapability("resetKeyboard", "True");
	          
	          driver = new AndroidDriver(new URL(hubURL), capabilities);
	          driver= EventFiringWebDriverFactory.getEventFiringWebDriver(driver, new AlertListener(), new ElementListener());
	    }
	    	if(source.equals("H5")){
	    	capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browser_Name); 
	        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platform_Name);  
	        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,device_Name);  
	        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platform_Version);  
//	        capabilities.setCapability("appPackage", "com.android.browser");
//	        capabilities.setCapability("appActivity", ".BrowserActivity");

	  driver = new AndroidDriver(new URL(hubURL),capabilities);
      driver= EventFiringWebDriverFactory.getEventFiringWebDriver(driver, new AlertListener(), new ElementListener());
	 
	          driver.get(url);
			}
	          
		return driver;
	}

}

package Appium.elongTest;

import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.elong.air.appium.DataProvider.BaseProvider;
import com.elong.air.appium.base.BaseAppTestClass;
import com.elong.air.appium.bean.ConvertToBean;
import com.elong.air.appium.bean.SearchConditionBean;

@Listeners({com.elong.air.appium.base.BaseScreenShortListener.class})
public class AppTest extends BaseAppTestClass{
	public int sheet = 3;
	
	@Test(dataProvider="testdp",dataProviderClass = BaseProvider.class)
	public void testApp(Object caseNum) throws Exception {
		int num=(Integer)caseNum;
	    SearchConditionBean scb=ConvertToBean.getDataBean(sheet,num);
		 Thread.sleep(5000);
		  int width=driver.manage().window().getSize().width;
	        int height=driver.manage().window().getSize().height;  
	        driver.swipe(width/2,height*3/4, width/2,height/4, 1000);
	        Thread.sleep(5000);
	        driver.findElement(By.id("com.elong.android.home:id/home_module_flight")).click();
	        driver.findElement(By.id("com.elong.android.flight:id/flightssearch_leavecity")).click();;
	     System.out.println("<<<<<"+scb.getStart_city()+">>>>>>");
	     WebElement s=   driver.findElement(By.id("com.elong.android.flight:id/city_select_search"));
	      
	      s.sendKeys(scb.getStart_city());
	    //  s.sendKeys();
	
	        Thread.sleep(5000);
	}

}

package Appium.elongTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.elong.air.appium.DataProvider.BaseProvider;
import com.elong.air.appium.base.BaseAppTestClass;

@Listeners({com.elong.air.appium.base.BaseScreenShortListener.class})
public class AppTest extends BaseAppTestClass{
	
	
	@Test(dataProvider="testdp",dataProviderClass = BaseProvider.class)
	public void testApp() throws Exception {
		 Thread.sleep(5000);
		    
		    
		    
//         int width=driver.manage().window().getSize().width;
//         int height=driver.manage().window().getSize().height;
//    	for(int i=0;i<=1;i++){
//    		 driver.swipe(width*4/5, height/2, width*1/5, height/2, 1000);
//    	}
//         driver.tap(1,height/2,width*1/2, 200);
//    
//    	 Thread.sleep(5000);
	}

}

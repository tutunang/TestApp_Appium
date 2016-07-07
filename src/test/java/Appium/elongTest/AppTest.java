package Appium.elongTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.elong.air.appium.base.BaseAppTestClass;

@Listeners({com.elong.air.appium.base.BaseScreenShortListener.class})
public class AppTest extends BaseAppTestClass{
	
	
	@Test
	public void testApp() throws Exception {
		 Thread.sleep(5000);
		   int width=driver.manage().window().getSize().width;
		    int height=driver.manage().window().getSize().height;
		    System.out.print(width+"jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
		    System.out.print(height);
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

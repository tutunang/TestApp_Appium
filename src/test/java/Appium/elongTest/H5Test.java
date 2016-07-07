package Appium.elongTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.elong.air.appium.PageObjects.AirListPage;
import com.elong.air.appium.PageObjects.FlightHomePage;
import com.elong.air.appium.base.BaseAppTestClass;

@Listeners({com.elong.air.appium.base.BaseScreenShortListener.class})
public class H5Test extends BaseAppTestClass{
	
	
	@Test
	public void testH5() throws Exception {
	FlightHomePage	fl=new FlightHomePage(driver);
	fl.chooseStartCity("上海");
	fl.chooseArriverCity("广州");
	fl.chooseStartDate("2016-07-25");
	AirListPage ap=	fl.searchButton();
	ap.chooseAirPlan();
	Thread.sleep(5000);
	}

}

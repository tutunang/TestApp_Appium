package Appium.elongTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.elong.air.appium.AppPageObjects.AppAirListPage;
import com.elong.air.appium.AppPageObjects.AppHomePage;
import com.elong.air.appium.AppPageObjects.EnterPage;
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
        EnterPage ep=new EnterPage(driver);
	   // ep.swipeToUp(driver,500);
	    Thread.sleep(5000);
	    AppHomePage ap=  ep.enterToFlight();
	    AppAirListPage al=ap.setInformation(scb);
	    al.chooseLine(2);

	}

}

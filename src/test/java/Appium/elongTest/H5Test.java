package Appium.elongTest;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.elong.air.appium.DataProvider.BaseProvider;
import com.elong.air.appium.PageObjects.AirClassTypePage;
import com.elong.air.appium.PageObjects.AirListPage;
import com.elong.air.appium.PageObjects.FlightHomePage;
import com.elong.air.appium.PageObjects.InputInformationPage;
import com.elong.air.appium.base.BaseAppTestClass;
import com.elong.air.appium.bean.ConvertToBean;
import com.elong.air.appium.bean.SearchConditionBean;

@Listeners({com.elong.air.appium.base.BaseScreenShortListener.class})
public class H5Test extends BaseAppTestClass{
	public int sheet = 3;
	
@Test(dataProvider="testdp",dataProviderClass = BaseProvider.class)
	public void testH5(Object caseNum) throws Exception {
	int num=(Integer)caseNum;
    SearchConditionBean scb=ConvertToBean.getDataBean(sheet,num);
    Reporter.log("this is test");
	FlightHomePage	fl=new FlightHomePage(driver);
	fl.chooseStartCity(scb.getStart_city());
	fl.chooseArriverCity(scb.getEnd_city());
	fl.chooseStartDate(scb.getStart_date());
	AirListPage ap=	fl.searchButton();

	AirClassTypePage acp=ap.chooseAirPlan();
	InputInformationPage ip=acp.chooseClassType();
	ip.addNewPassenger(scb.getInputInformation_Bean());
	Thread.sleep(5000);
	}

}

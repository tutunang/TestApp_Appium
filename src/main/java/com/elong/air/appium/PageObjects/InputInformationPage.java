package com.elong.air.appium.PageObjects;

import io.appium.java_client.AppiumDriver;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.elong.air.appium.base.BaseAppPage;
import com.elong.air.appium.bean.InputInformationBean;

public class InputInformationPage extends BaseAppPage {
	public InputInformationPage(AppiumDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[@class='add-icon']")
	public WebElement addNew;

	@FindBy(xpath = "//li[@class='delivery clearfix']")
	public WebElement addressItem;

	@FindBy(css = ".table-view-cell.right-triangle-icon.to-add-people span:nth-child(1)")
	public WebElement addNewPassenger;

	@FindBy(xpath = "//div[@class='next']")
	public WebElement confirm;
	
	@FindBy(css = ".check-box.label-checkbox .checkbox")
	public List<WebElement> customerCheckboxList;

	@FindBy(css = "#order-mobile")
	public WebElement contactPhome;

	@FindBy(css = ".checkbox.active")
	public WebElement receiptButton;

	@FindBy(css = ".next.commit")
	public WebElement nextStep;

	@FindBy(xpath = "//div[@class='slide-selector plugin-inited selector-active plugin-show']//label[@class='label-radio clearfix']//div[@class='radio-text']")
	public List<WebElement> cardTypeList;

	public void setCustomerToLocalStorage(InputInformationBean info) {
		int size = info.getCustomer().size();
		String userInfoStr = "";
		for (int i = 0; i < size; i++) {
			String name = info.getCustomer().get(i).getCname();
			String num = info.getCustomer().get(i).getCcardNum();
			String type = info.getCustomer().get(i).getCcardType();
			String bir = info.getCustomer().get(i).getCbirthday();
			userInfoStr += name + "-" + num + "-" + type + "-" + bir;
			if (i != (size - 1)) {
				userInfoStr += ",";
			}
			System.out.println(userInfoStr);
		}

		String js = "window.localStorage.orderPeopleList='" + userInfoStr + "'";
		((JavascriptExecutor)driver).executeScript(js);
	}
//public void setDeliveryToLocalStorage(InputInformationBean info){
//	String Mname=info.getAddress().getMname();
//	String Mtel=info.getAddress().getMtel();
//	String Min=info.getAddress().getInvoiceTitle();
//	String Mcode=info.getAddress().getMcode();
//	String Mdetail=info.getAddress().getMaddressDetails();
//	String Mprovince=info.getAddress().getProvinces();
//	String delivery="window.localStorage.deliveryInfo='[{name:"+Mname+",phone:"+Mtel+",street:"+Mprovince+"+"+Mdetail+",default:false}]'";
//	
////	window.localStorage.deliveryInfo='[{"name":"杜文静","phone":"86-15811173084","street":"北京 北京 东城区 酒仙桥中路10号","default":false}]'
//	((JavascriptExecutor)driver).executeScript(delivery);
//	
//	
//}


public  void setDeliveryToLocalStorage(InputInformationBean info){
	String Mname=info.getAddress().getMname();
	String Mtel=info.getAddress().getMtel();
	String Min=info.getAddress().getInvoiceTitle();
	String Mcode=info.getAddress().getMcode();
	String Mdetail=info.getAddress().getMaddressDetails();
	String Mprovince=info.getAddress().getProvinces();
	String zzz=	"[{\"name\":\"%s\",\"phone\":\"%s\",\"street\":\"%s %s\",\"default\":false}]";
	String xxx=	String.format(zzz, Mname,Mtel,Mprovince,Mdetail);
		System.out.println(xxx);
		String scrip="window.localStorage.deliveryInfo='"+xxx+"'";
		((JavascriptExecutor)driver).executeScript(scrip);
}
	public void addNewPassenger(InputInformationBean info) {
		click(addNew);
		setCustomerToLocalStorage(info);
		driver.navigate().refresh();
		click(addNew);
		for(int i=0;i<customerCheckboxList.size()-1;i++){
			customerCheckboxList.get(i+1).click();
		}
		click(confirm);
	
		if(	info.getReceipt().equals("true")){
String recepit="document.getElementsByClassName('checkbox active')[0].click()";
((JavascriptExecutor)driver).executeScript(recepit);
		    setDeliveryToLocalStorage(info);
			
		}
		String receiptItem="document.getElementsByClassName('post-info')[0].click()";
		((JavascriptExecutor)driver).executeScript(receiptItem);
		click(addressItem);

		//setInputText(contactPhome, info.getContactTel());
	
		String phoneInput="document.getElementById('order-mobile').value='"+info.getContactTel()+"'";
		((JavascriptExecutor)driver).executeScript(phoneInput);
		
		String nextStep="document.getElementsByClassName('next commit')[0].click()";
		((JavascriptExecutor)driver).executeScript(nextStep);
		
//		if (title.getText() == "选择乘机人") {
//			click(addNewPassenger);
//		}
//		this.setInputText(addName, name);
//		click(cardType);
//		// String
//		// str="//div[@class='slide-selector plugin-inited selector-active plugin-show']//label[@class='label-radio clearfix']//div[@class='radio-text']";
//		// ((JavascriptExecutor)driver).executeScript(str);
//
//		for (WebElement e : cardTypeList) {
//			if (e.getText().equals(card)) {
//				e.click();
//			}
//		}
//		this.setInputText(cardNumInputText, cardNum);
//		String str = "document.getElementById('birth-date').removeAttribute('readonly')";
//		((JavascriptExecutor) driver).executeScript(str);

	}
}
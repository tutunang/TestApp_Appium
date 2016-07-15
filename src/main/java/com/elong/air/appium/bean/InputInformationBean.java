package com.elong.air.appium.bean;

import java.util.List;

public class InputInformationBean {
	public boolean Receipt;
	public String ContactTel;
	public List<CustomerBean> customer;
	public MailAddressBean address;
	
	public boolean isReceipt() {
		return Receipt;
	}
	public void setReceipt(boolean receipt) {
		Receipt = receipt;
	}
	public String getContactTel() {
		return ContactTel;
	}
	public void setContactTel(String contactTel) {
		ContactTel = contactTel;
	}
	public List<CustomerBean> getCustomer() {
		return customer;
	}
	public void setCustomer(List<CustomerBean> customer) {
		this.customer = customer;
	}
	public MailAddressBean getAddress() {
		return address;
	}
	public void setAddress(MailAddressBean address) {
		this.address = address;
	}
	

}

package com.elong.air.appium.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.elong.air.appium.DataProvider.ITestData;

public class ConvertToBean {
	public static SearchConditionBean getDataBean(int sheet,int caseNum){
	Map<String ,String>map=	ITestData.getTestData(sheet, caseNum);
	SearchConditionBean s=new SearchConditionBean();
	
	s.setStart_city(map.get("出发城市"));
	s.setEnd_city(map.get("到达城市"));
	s.setCabin_leavel(map.get("舱位等级"));
	s.setTravel_type(map.get("航程类型"));
	s.setStart_date(map.get("出发日期"));
	s.setReturn_date(map.get("返程日期"));
	//拆分填写页
	InputInformationBean info=new InputInformationBean();
	s.setInputInformation_Bean(info);
	s.getInputInformation_Bean().setContactTel(map.get("手机号"));
	s.getInputInformation_Bean().setReceipt(map.get("是否报销"));
	System.out.println(s.getInputInformation_Bean().getReceipt());
	System.out.println(s.getInputInformation_Bean().getContactTel());
	
	//拆分乘机人
	List<CustomerBean> cb=new ArrayList();

    
	String []Cname= map.get("乘机人姓名").split("\\|");
	String[] CcardTpye=map.get("证件类型").split("\\|");
	String[] Ccardnum=map.get("证件号码").split("\\|");
	String[] Cbirthdate=map.get("出生日期").split("\\|");
	String[] Cinsurance=map.get("购买保险").split("\\|");
	
	System.out.println(Cname.length);
	for(int i=0;i<Cname.length;i++){
		CustomerBean cbean=new CustomerBean();
		cb.add(cbean);
	    info.setCustomer(cb);
		s.getInputInformation_Bean().getCustomer().get(i).setCname(Cname[i]);
		s.getInputInformation_Bean().getCustomer().get(i).setCcardType(CcardTpye[i]);
		s.getInputInformation_Bean().getCustomer().get(i).setCcardNum(Ccardnum[i]);
		s.getInputInformation_Bean().getCustomer().get(i).setCbirthday(Cbirthdate[i]);
		s.getInputInformation_Bean().getCustomer().get(i).setCinsurance(Cinsurance[i]);
		System.out.println(s.getInputInformation_Bean().getCustomer().get(i).getCname());
		System.out.println(	s.getInputInformation_Bean().getCustomer().get(i).getCcardNum());
		System.out.println(s.getInputInformation_Bean().getCustomer().get(i).getCbirthday());
		System.out.println(s.getInputInformation_Bean().getCustomer().get(i).getCinsurance());
		System.out.println(s.getInputInformation_Bean().getCustomer().get(i).getCcardType());
		
	}
	
	
	/*
	String[] CcardTpye=map.get("证件类型").split("\\|");
	for(int i=0;i<=CcardTpye.length;i++){
		s.getInputInformation_Bean().getCustomer().get(i).setCcardNum(CcardTpye[i]);
	}
	String[] Ccardnum=map.get("证件号码").split("\\|");
	for(int i=0;i<=Ccardnum.length;i++){
		s.getInputInformation_Bean().getCustomer().get(i).setCcardNum(Ccardnum[i]);
	}
	String[] Cbirthdate=map.get("出生日期").split("\\|");
	for(int i=0;i<=Cbirthdate.length;i++){
		s.getInputInformation_Bean().getCustomer().get(i).setCcardNum(Cbirthdate[i]);
	}
	
	String[] Cinsurance=map.get("购买保险").split("\\|");
	for(int i=0;i<=Cinsurance.length;i++){
		s.getInputInformation_Bean().getCustomer().get(i).setCcardNum(Cinsurance[i]);
	}
	*/
	
//拆分报销凭证
	MailAddressBean ab=new MailAddressBean();
	s.getInputInformation_Bean().setAddress(ab);
s.getInputInformation_Bean().getAddress().setMname(map.get("姓名"));
s.getInputInformation_Bean().getAddress().setMaddressDetails(map.get("详细地址"));
s.getInputInformation_Bean().getAddress().setMcode(map.get("邮编"));
s.getInputInformation_Bean().getAddress().setInvoiceTitle(map.get("发票抬头"));
s.getInputInformation_Bean().getAddress().setMtel(map.get("电话"));

System.out.println(s.getInputInformation_Bean().getAddress().getMname());
System.out.println(s.getInputInformation_Bean().getAddress().getMaddressDetails());
System.out.println(s.getInputInformation_Bean().getAddress().getMcode());
System.out.println(s.getInputInformation_Bean().getAddress().getInvoiceTitle());
System.out.println(s.getInputInformation_Bean().getAddress().getMtel());
	
	
	
	
	

		return s;
	}

	
	public static void main(String[] args) {
getDataBean(3,4);
	}
}

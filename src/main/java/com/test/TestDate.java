package com.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate {
	
public static void main(String[] args) {
//	Date date=new Date();
//	DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
//	String time=format.format(date);
//	System.out.println(time);
	Calendar c=Calendar.getInstance();   
	DateFormat df=new SimpleDateFormat("yyyy-MM-dd");   
	c.setTime(new Date());   
	c.add(Calendar.DATE,20);   
	Date d2=c.getTime();   
	String s=df.format(d2);   
System.out.println(s);



//Calendar now = Calendar.getInstance();  
//System.out.println("年: " + now.get(Calendar.YEAR));  
//System.out.println("月: " + (now.get(Calendar.MONTH) + 1) + "");  
//System.out.println("日: " + now.get(Calendar.DAY_OF_MONTH));  
//System.out.println("时: " + now.get(Calendar.HOUR_OF_DAY));  
//System.out.println("分: " + now.get(Calendar.MINUTE));  
//System.out.println("秒: " + now.get(Calendar.SECOND));  
//System.out.println("当前时间毫秒数：" + now.getTimeInMillis());  
//System.out.println(now.getTime());  


Calendar calendar2 = Calendar.getInstance();
SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
calendar2.add(Calendar.DATE, 3);
String three_days_after = sdf2.format(calendar2.getTime());
System.out.println(three_days_after);
String ss=three_days_after.substring(6, 8);
System.out.println(ss);
if(ss.startsWith("0")){
System.out.println(	ss.substring(1));
}else{
	System.out.println(ss);
}
}

}  
package com.elong.air.appium.DataProvider;

import java.util.Map;
import java.util.Set;

import com.elong.air.appium.tools.OptionFile;


public class ITestData {
	//static String filepaString = OptionFile.readProperties(
	//		"./src/main/resources/config.properties", "excel");
	static String filepaString = "./src/test/resources/testdata.xls";
	public static Map<String, String> getTestData(int sheet, int caseNum) {
		Map<String, String> map = OptionFile.getExcelDataByCaseNum(
				filepaString, sheet, caseNum);
		Set<String> set = map.keySet();
		for(String name:set) {
			String value = map.get(name);
			System.out.println("map中的name："+name+"，value："+value);
		}
		return map;
	}
	
	
	public static void main(String[] args) {
		getTestData(3,4);
		
	}
}

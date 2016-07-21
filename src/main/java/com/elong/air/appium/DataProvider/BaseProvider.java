package com.elong.air.appium.DataProvider;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import com.elong.air.appium.tools.OptionFile;

public class BaseProvider {
	@DataProvider(name = "testdp")
	public static Iterator<Object[]> createData(Method method,
			ITestContext context) throws Exception {

		String testclass = method.getDeclaringClass().getName();
		Class clzz = Class.forName(testclass);
		Object object = clzz.newInstance();
		Field field = clzz.getDeclaredField("sheet");
		String testsheet = field.get(object).toString();

		Logger log = Logger.getLogger(BaseProvider.class);
		
		// 读取测试用例的级别
	//	int case_count = 0;
	//	int case_start = 4;
		int sheet = Integer.parseInt(testsheet);
	//	Priority p = null;
		final String P_FROM_PROPERTY = OptionFile.readProperties(
				"./src/main/resources/config.properties", "priority");
		System.out.println("------执行数据驱动，执行的用例优先级是："+P_FROM_PROPERTY+"，执行的excel-sheet页是"+sheet+"------");
		log.debug("------执行数据驱动，执行的用例优先级是："+P_FROM_PROPERTY+"，执行的excel-sheet页是"+sheet+"------");
		// ---------------遍历excel找到指定测试级别的casenum--------------

		String filepaString = "./src/test/resources/testdata.xls";
		List<Integer> listtemp = OptionFile.getExcelPriority(filepaString,
				sheet, P_FROM_PROPERTY);

		if (listtemp.size() < 1) {

		}

		List<Object[]> list = new ArrayList<Object[]>();
		for (Integer itg : listtemp) {
			list.add(new Object[] { itg });
		}

		return list.iterator();

	}
}

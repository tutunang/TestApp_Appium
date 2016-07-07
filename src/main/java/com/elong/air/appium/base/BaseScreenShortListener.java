package com.elong.air.appium.base;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 * 监听异常截图类，所有测试类都要在类前面加入@Listeners({com.elong.air.base.BaseScreenShortListener.
 * class})

 */
public class BaseScreenShortListener extends TestListenerAdapter {
	BaseAppTestClass bc = new BaseAppTestClass();

	@Override
	public synchronized void onTestFailure(ITestResult result) {
		bc.takeScreenShort(result);
	}
}

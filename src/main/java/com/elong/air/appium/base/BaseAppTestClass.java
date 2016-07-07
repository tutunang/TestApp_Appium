package com.elong.air.appium.base;

import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.elong.air.appium.DriverFactory.AppDriverFactory;
import com.elong.air.appium.tools.OptionFile;

/**
 * 
 * @author wenjing.du
 * @date 2016-06-29
 * 
 */
public class BaseAppTestClass 
{
	 public  AndroidDriver  driver;
	 public AndroidDriver getDriver() {
	        System.out.println("这是构造方法");
		return driver;
	}

	public void setDriver(AndroidDriver driver) {
		this.driver = driver;
	}

	private BaseAppTestClass(AndroidDriver driver){
		 this.driver=driver;
	 }
	 
	public BaseAppTestClass(){
//		 this.driver=driver;
	 }
	 @BeforeClass
	 public void setUpAndroidDriver() throws Exception{
        driver=AppDriverFactory.setUpDriver();
        System.out.println("这是beforeclass");
      //  visitURL( driver);
	 }
	 @AfterClass
	 public void distoryDriver(){
		// driver.close();
		 driver.quit();
	 }
	 
	 
	 
	

		/**
		 * 自动截图实现方法，以测试类名为文件夹存储失败的截图
		 * 
		 * @Title: takeScreenShort
		 * @param result
		 * @return void
		 * @throws
		 */
		protected void takeScreenShort(ITestResult result) {
			Object currentClass = result.getInstance();
					AndroidDriver andDriver = ((BaseAppTestClass) currentClass).getDriver();		
			if (andDriver != null) {
				Date currentTime = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat(
						"yyyy-MM-dd-HH-mm-ss");
				String dateString = formatter.format(currentTime);
				File scrFile = ((TakesScreenshot) andDriver)
						.getScreenshotAs(OutputType.FILE);
				try {
					String fileclass = result.getMethod().getRealClass().getName();
					String filename = fileclass + "-" + result.getName() + "-"
							+ dateString + ".png";

					File file = new File("ExceptionScreenshotImg/" + fileclass);
					if (!file.exists()) {
						file.mkdir();
					}
					File screenshot = new File(file, filename);
					FileUtils.copyFile(scrFile, screenshot);

					Reporter.setCurrentTestResult(result);
					String filepath = screenshot.getAbsolutePath();
					//System.out.println("-------------失败截图路径----------------"
					//		+ filepath);
//					log.debug("------发生异常，自动截图，图片存放路径是："+filepath+"------");
					// Reporter.log("<a href=\"" + filepath +
					// "\" target=\"_blank\">Failed Screen Shot</a>",true);
					Reporter.log("Failed Screen Shot Path：" + filepath, true);

					// HTMLReporter html = new HTMLReporter();
					// Reporter r = html.generateReport(List<XmlSuite>
					// xmlSuites,List<ISuite> suites, "sdfsdf");
					// r.log("<a href=\"" + filepath +
					// "\" target=\"_blank\">Failed Screen Shot</a>",true);
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	private void visitURL(AndroidDriver driver) {
//		String url = OptionFile.readProperties("./src/main/resources/config.properties", "visitURL");
//		driver.get(url);
//		
//	}
	
	
	
	public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}

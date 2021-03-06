package com.elong.air.appium.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.elong.air.appium.tools.OptionFile;

public class BaseAppPage {

	public static final String NO_SUCH_FRAME = "no-such-frame";
	protected String name = "";
	private static String source=OptionFile.readProperties("./src/main/resources/config.properties", "source");
	public AppiumDriver driver;
	//private Logger log = Logger.getLogger(BasePageObject.class);
	protected Logger log = Logger.getLogger(this.getClass());
	// 全局的超时时间设置
	private final int TIMEOUT = Integer.parseInt(OptionFile.readProperties(
			"./src/main/resources/config.properties", "timeout"));;

	/**
	 * 构造方法时，判断页面title是否正确,使用传入的title判断页面title
	 * 
	 * @param driver
	 * @param title
	 */
		
	public BaseAppPage(AppiumDriver driver, final String title) {
		log.debug("------使用BasePageObject(WebDriver driver)构造方法开始------");
		
		//final String pagetitle = this.getClass().getCanonicalName();
		this.driver = driver;

		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		try {
			wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver arg0) {
					// TODO Auto-generated method stub
					String acttitle = arg0.getTitle();
				boolean falg=arg0.findElement(By.xpath(title)).isDisplayed();
		arg0.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
					log.debug("------预期页面title是："+title+"，实际页面title是：acttitle");
					return falg;
					
				}
			});
		} catch (TimeoutException te) {
			throw new IllegalStateException("当前不是预期页面，当前页面title是："
					+ driver.getTitle());
		}

		PageFactory.initElements(
				new AjaxElementLocatorFactory(driver, TIMEOUT), this);

	}

	/***
	 * 构造方法时，从配置文件中取得界面唯一的logo的xpath定位
	 * 
	 * @param driver
	 * @update wenjing
	 */
	public BaseAppPage(AppiumDriver driver) {
		this.driver = driver;
		log.debug("------使用BasePageObject(WebDriver driver)构造方法开始------");
		//driver.navigate().refresh();
		if(source.equals("H5")){
		final String pagetitle = this.getClass().getCanonicalName();
		final String logo = OptionFile.readProperties(
				"./src/main/resources/pagetitle.properties", pagetitle);

		System.out.println("当前page类是：" + pagetitle + " ;取到的logo是：" + logo);
		
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		try {
			wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver arg0) {
					return arg0.findElement(By.xpath(logo)).isDisplayed();
				}
			});
		} catch (TimeoutException te) {
			throw new IllegalStateException("页面未加载完毕或者找不到元素");
		}
		}

		PageFactory.initElements(
				new AjaxElementLocatorFactory(driver, TIMEOUT), this);
	}
//	public BasePage(AndroidDriver driver) {
//		this.driver=driver;
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		PageFactory.initElements(
//		new AjaxElementLocatorFactory(driver, TIMEOUT), this);
//
//	}
	public BaseAppPage() {
	}
	
	
	

	/*-------------------------常用方法封装------------------------------------------------------------*/
	protected void click(WebElement element) {
		// switchFrame(element);
	//	takeScreenShot(driver);
		element.click();
	}

	protected void setInputText(WebElement element, String text) {
		// switchFrame(element);
		System.out.println("--------sendkeys:"+text);
		//element.clear();//暂时注销，登录密码框会报错
		element.sendKeys(text);
	}

	protected void setCheck(WebElement element) {
		boolean fa=element.isSelected();
		if (element.isSelected()) {
			return;
		} else {
			element.click();
		}

	}

	protected static void switchFrame(WebDriver driver, String frameName) {
		if (frameName == null) {
			return;
		}
		driver.switchTo().defaultContent();
		if (frameName.equals(NO_SUCH_FRAME)) {
			return;
		}
		if (!"".equals(frameName)) {
			if (frameName.indexOf('|') != -1) {
				String[] subFrames = frameName.split("[|]");
				for (String subFrame : subFrames) {
					WebElement element = driver.findElement(By
							.cssSelector(subFrame));
					if (element == null
							|| !element.getTagName().contains("frame")) {
						return;
					}
					driver.switchTo().frame(element);
				}
			} else {
				String[] subFrames = frameName.split("[.]");
				for (String subFrame : subFrames) {
					driver.switchTo().frame(subFrame);
				}
			}
		}
	}

	protected void switchWindow() {
		String currentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String s : handles) {
			if (currentWindow.equals(s)) {
				continue;
			}
			driver.switchTo().window(s);

		}

	}

	protected void switchWindow1() {
		String currentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			String handle = it.next();
			if (currentWindow.equals(handle))
				continue;
			driver.switchTo().window(handle);
		}
	}

	// 截图
//	protected void takeScreenShot(WebDriver driver) {
//		final String path = "D:/eclipseWorkSpace/AirGUIDemo/test-output/ScreenShot/";
//		try {
//			File file = ((TakesScreenshot) driver)
//					.getScreenshotAs(OutputType.FILE);
//			Random rd = new Random();
//			int tmp = Math.abs(rd.nextInt());
//			System.out.println(path + name + "jjjjjjjjjjjjjjjjjjjjjjjjj");
//			FileUtils.copyFile(file, new File(path + name, tmp
//					+ "screenshopt.png"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	/*----------------------------qiaojiafei----------------------------*/
	/**
	 * 刷新页面
	 */
	protected  void refreshPage() {
		driver.navigate().refresh();
	}
	/**
	 * 浏览器前进
	 */
	protected void forwardPage() {
		driver.navigate().forward();
	}
	/**
	 * 浏览器后退
	 */
	protected void backPage() {
		driver.navigate().back();
	}
	/**
	 * 确认Alert弹框
	 * @throws Exception 
	 */
	protected void alertConfirm() throws Exception {
		Alert alert = driver.switchTo().alert();
		try {
			alert.accept();
		} catch (Exception notFindAlert) {
			throw notFindAlert;
		}
	}
	/**
	 * 关闭Alter弹框
	 * @throws Exception 
	 */
	protected void alertDismiss() throws Exception {
		Alert alert = driver.switchTo().alert();
		try {
			alert.dismiss();
		} catch (Exception notFindAlert) {
			throw notFindAlert;
		}
	}
	/**
	 * 获得Alter弹框文本内容
	 * @return
	 * @throws Exception 
	 */
	protected String getAlertText() throws Exception {
		Alert alert = driver.switchTo().alert();
		try {
			return alert.getText();
		} catch (Exception notFindAlert) {
			throw notFindAlert;
		}
	}
	/**
	 * 执行JavaScript
	 * @param js
	 */
	protected void executorJS(String js) {
		JavascriptExecutor jsexe = (JavascriptExecutor) driver;
		jsexe.executeScript(js);

	}
	/**
	 * 跳转至默认容器，即最顶层Frame
	 */
	protected void toDefaultContent() {
		driver.switchTo().defaultContent();
	}
	/**
	 * 跳转至父级(上一层)Frame
	 */
	protected void toParentFrame() {
		driver.switchTo().parentFrame();
	}
	/**
	 * 跳转至Frame，可传参数类型：String、Integer、WebElment
	 * @param ob
	 */
	protected void toFrame(Object ob) {
		if(ob instanceof  String) {
			String s = (String)ob;
			driver.switchTo().frame(s);
		}else if (ob instanceof  WebElement) {
			WebElement we = (WebElement)ob;
			driver.switchTo().frame(we);
		}else if(ob instanceof  Integer){
			Integer it = (Integer)ob;
			driver.switchTo().frame(it.intValue());
		}else{
			log.debug("");
		}
	}
	/**
	 * 使用JS给富文本框传值
	 * @param element
	 * @param text
	 */
	protected void setRichTextBox(WebElement element, String text) {		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].innerHTML = \"" + text + "\"", element);
	}
	/**
	 * 使用JS获取富文本框内容
	 * @param element
	 * @param text
	 * @return
	 */
	protected String getRichTextBox(WebElement element) {	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String result = (String) js.executeScript(
				"arguments[0].getInnerHTML()", element);
		return result;
	}
	/**
	 * 使用Actions来滑动滚动条到页面底部
	 */
	protected void scrollToBottom() {
		Actions a = new Actions(driver);
		a.sendKeys(Keys.END).perform();
	}
	/**
	 * 使用Actions来滑动滚动条到页面顶部
	 */
	protected void scrollToTop() {
		Actions a = new Actions(driver);
        a.sendKeys(Keys.HOME).perform();
	}
	/**
	 * 使用Actions来滑动滚动条到指定元素
	 */
	protected void scrollToElement(WebElement element) {
		Actions a = new Actions(driver);
	    a.moveToElement(element).perform();
	}
	
	protected void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);;
	}
	
	protected void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	protected void selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	/**
	 * 得到Select对象
	 * @param element
	 * @return
	 */
	protected Select getSelect(WebElement element) {		
		Select select = new Select(element);		
		return select;
	}
	
	protected void selectByIndex(Select select, int index) {
		select.selectByIndex(index);;
	}
	
	protected void selectByValue(Select select, String value) {
		select.selectByValue(value);
	}
	protected void selectByVisibleText(Select select, String text) {
		select.selectByVisibleText(text);
	}
	/**
	 * 判断元素是否可见
	 * @param by
	 * @param time
	 * @return
	 */
	protected boolean isElementPresent(final By by) {
        boolean isPresent = false;
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        isPresent = wait.until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver dr) {
                return dr.findElement(by);
            }
        }).isDisplayed();
        return isPresent;
	}
	
	protected WebElement findElement(final By by) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        WebElement element = wait.until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver dr) {
                return dr.findElement(by);
            }
        });
        return element;
	}
	
	protected List<WebElement> findElements(final By by) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        List<WebElement> elements = wait.until(new ExpectedCondition<List<WebElement>>() {
            public List<WebElement> apply(WebDriver dr) {
                return dr.findElements(by);
            }
        });
        return elements;
	}
	
	protected WebElement findElement(final WebElement webelement, final By by) {
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        WebElement element = wait.until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver dr) {
                return webelement.findElement(by);
            }
        });
        return element;
	}
	
	protected List<WebElement> findElements(final WebElement webelement, final By by) {
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		List<WebElement> elements = wait.until(new ExpectedCondition<List<WebElement>>() {
            public List<WebElement> apply(WebDriver dr) {
                return webelement.findElements(by);
            }
        });
        return elements;
	}
	/**
	 * 切换浏览器标签至新打开窗口，当前浏览器打开多个(>2)浏览器标签时
	 * @param set
	 */
	protected void switchToWindow(Set<String> set) {
	   Set<String> setCur = driver.getWindowHandles();
	   if(setCur.containsAll(set)) {
		   setCur.removeAll(set);
	   }
	   String newwindow = Arrays.toString(setCur.toArray());
	   driver.switchTo().window(newwindow);
	}
	/**
	 * 切换浏览器标签至新打开窗口
	 * @param set
	 */
	protected void switchToWindow() {
	   String curW = driver.getWindowHandle();
	   Set<String> set = driver.getWindowHandles();
	   for(String s:set) {
		   if(!s.equals(curW)) {
			   driver.switchTo().window(s);
		   }
	   }
	}
	
	protected boolean isAlertPresent() throws Exception {
		boolean flag = false;
		try {
			ExpectedConditions.alertIsPresent().apply(driver);
			flag = true;
		} catch (Exception NofindAlert) {
			// TODO: handle exception
			flag = false;
			throw NofindAlert;
		}
		return flag;
	}
	protected void testriver() {
	  
	}
	/*----------------------------app ----------------------------*/
	 public void swipeToUp(AppiumDriver driver2, int during) {
	        int width = driver2.manage().window().getSize().width;
	        int height = driver2.manage().window().getSize().height;
	        driver2.swipe(width / 2, height * 3 / 4, width / 2, height / 4, during);
	        // wait for page loading
	    }

	 
	    public void swipeToDown(AppiumDriver driver, int during) {
	        int width = driver.manage().window().getSize().width;
	        int height = driver.manage().window().getSize().height;
	        driver.swipe(width / 2, height / 4, width / 2, height * 3 / 4, during);
	        // wait for page loading
	    }

	
	    public void swipeToLeft(AppiumDriver driver, int during) {
	        int width = driver.manage().window().getSize().width;
	        int height = driver.manage().window().getSize().height;
	        driver.swipe(width * 3 / 4, height / 2, width / 4, height / 2, during);
	        // wait for page loading
	    }


	    public void swipeToRight(AppiumDriver driver, int during) {
	        int width = driver.manage().window().getSize().width;
	        int height = driver.manage().window().getSize().height;
	        driver.swipe(width / 4, height / 2, width * 3 / 4, height / 2, during);
	        // wait for page loading

	    }
     
}

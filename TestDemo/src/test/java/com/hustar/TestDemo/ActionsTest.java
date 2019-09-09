package com.hustar.TestDemo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActionsTest {
	WebDriver driver;
//  @BeforeTest
//  public void open() {
//	  System.setProperty("webdriver.chrome.driver", "D:\\\\Java\\\\apache-maven-3.6.1\\\\drivers\\\\chromedriver.exe");
//      driver = new ChromeDriver();
////	  driver.get("file:///F:/Web自动化selenium+java/源码/webdriver_demo/selenium_html/index.html");
//  }
  @Test
  public void contextClickTest() throws InterruptedException {
	  WebElement element = driver.findElement(By.className("baidu"));
	  Actions action = new Actions(driver);
	  action.doubleClick(element).perform();//右击
	  Thread.sleep(3000);
  }
  /**
   * 鼠标移动到某个元素上
   * builder.moveToElement(element).perform()
   * @throws InterruptedException
   */
  @Test
  public void moveTOTest() throws InterruptedException {
	  driver.get("http://baidu.com");
	  Thread.sleep(3000);
	  Actions action = new Actions(driver);
	  WebElement element = driver.findElement(By.linkText("更多产品"));
	  action.moveToElement(element).perform();;
  }
  
  /**
   * 把元素拖动到（x,y）
   * dragAndDropBy()
   * @throws InterruptedException
   */
  @Test
  public void dragTest() throws InterruptedException {
	  driver.get("F:\\Web自动化selenium+java\\源码\\webdriver_demo\\selenium_html\\dragAndDrop.html");
	  Thread.sleep(3000);
	  WebElement element = driver.findElement(By.id("drag"));
	  WebElement div = driver.findElement(By.xpath("/html/body/h1"));
	  Actions action = new Actions(driver);
	  action.dragAndDrop(element, div).perform();;
  }
  
  /**
   * 下拉框多选
   * 
   * @throws InterruptedException
   */
  @Test
  public void multiselectTest() throws InterruptedException {
	  driver.get("F:\\Web自动化selenium+java\\源码\\webdriver_demo\\selenium_html\\index.html");
	  Thread.sleep(3000);
	  driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
	  List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]/option"));
	  Actions action = new Actions(driver);
	  Action act = action.click(list.get(1)).keyDown(Keys.SHIFT).click(list.get(2)).build();
	  act.perform();
	  Thread.sleep(3000);
  }
  
  /**
   * Robot类，用来实现更复杂的键盘
 * @throws AWTException 
   * @throws InterruptedException
   */
  
  @Test
  public void robotTest() throws AWTException, InterruptedException {
	  driver.get("http://www.baidu.com");
	  Robot robot = new Robot();
	  robot.keyPress(KeyEvent.VK_CONTROL);
	  robot.keyPress(KeyEvent.VK_S);
	  Thread.sleep(3000);
	  robot.keyPress(KeyEvent.VK_ENTER);
  }
  /**
   * 上传文件的处理
   * 定位上传控件
   * 使用sendkeys()方法，并传入文件路径
   * @throws InterruptedException
   */
  
  @Test
  public void upload() throws InterruptedException {
	  driver.get("file:///F:/Web自动化selenium+java/源码/webdriver_demo/selenium_html/index.html");
	  driver.findElement(By.id("load")).sendKeys("F:\\《Java基础入门》_课后习题答案\\《Java基础入门》_课后习题答案.pdf");
	  Thread.sleep(3000);
  }
  
  /**
   * 自动下载
   * new一个ChromeOptions对象，设置下载的设置
   * 需要创建一个hashMap类
   * @throws InterruptedException
   */
  @Test
  public void loadTest() {
	  ChromeOptions option = new ChromeOptions();
	  HashMap<String, Object> chromPrefs = new HashMap<String, Object>();
	  chromPrefs.put("profile.default_content_settings.popups", 2);
	  chromPrefs.put("download.default_directory", "F:\\Web自动化selenium+java\\PPT");
	  System.setProperty("webdriver.chrome.driver", "D:\\\\Java\\\\apache-maven-3.6.1\\\\drivers\\\\chromedriver.exe");
	  option.setExperimentalOption("prefs", chromPrefs);
	  driver = new ChromeDriver(option);
	  driver.get("https://y.qq.com");
	  driver.findElement(By.xpath("/html/body/div[9]/a")).click();
	  new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[9]/a")));
	  
	  
  }

  @AfterTest
  public void close() throws InterruptedException {
	  if(driver != null) {
		  Thread.sleep(3000);
		  driver.quit();
	  }
  }
}

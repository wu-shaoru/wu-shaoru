package com.hustar.TestDemo;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;


public class UsenessOfWeb {
	/**
	 * 以Google Chrome浏览为例，演示浏览器的常用操作
	 * 
	 */
  WebDriver driver;
  @BeforeTest
  public void openChromeTest() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver","D:\\Java\\apache-maven-3.6.1\\drivers\\chromedriver.exe");
	  driver = new ChromeDriver();
	  Thread.sleep(3000);
  }
  
  /**
   * 演示浏览器最大化
   * 1.打开浏览器‘
   * 2.使用driver.manage().window().maximize()来最大化浏览器
   * 3.关闭浏览器
   */
  @Test
  public void maximizeWindowTest() {
	  driver.manage().window().maximize();
  }
  
  /**
   * 设置浏览器的宽和高
   * @throws InterruptedException
   */
  @Test
  public void setSizeTest() {
	  Dimension dimension = new Dimension(400, 500);
	  driver.manage().window().setSize(dimension);
  }
  
  /**
   * 控制浏览器前进后退
   * 使用driver.navigate().back()
   * driver.navigate().forward()
   * @throws InterruptedException
   */
  @Test
  public void backAndForward() throws InterruptedException {
	  driver.get("http://www.baidu.com");
	  Thread.sleep(3000);
	  driver.get("https://www.qq.com/");
	  Thread.sleep(3000);
	  driver.navigate().back();
	  Thread.sleep(3000);
	  driver.navigate().forward();
  }
  
  /**
   * 浏览器刷新
   * @throws InterruptedException
   */
  @Test
  public void refreshTest() throws InterruptedException {
	  driver.get("http://www.baidu.com");
	  Thread.sleep(3000);
	  String strr = driver.getTitle();
	  Assert.assertEquals(strr, "百度一下，你就知道");

  }
  
  @Test
  public void clearTest() throws InterruptedException {
	  driver.get("http://www.baidu.com");
	  WebElement kw = driver.findElement(By.id("kw"));
	  kw.sendKeys("nihaoi");
	  Thread.sleep(3000);
	  kw.clear();
  }
  
  
  @Test
  public void getTextTest() {
	  
	  driver.get("http://www.baidu.com");
	  String titile = driver.findElement(By.className("title")).getText();
	  Assert.assertEquals(titile,"下载百度APP");
  }
  
  /**
   * 获取属性值，用getAttribute()
   * @throws InterruptedException
   */
  @Test
  public void getAttributionTets() {
	  driver.get("http://www.baidu.com");
	  String valkue = driver.findElement(By.id("su")).getAttribute("type");
	  Assert.assertEquals(valkue, "submit");
  }
  
  /**
   * 判断元素是否展示isDisplayed()
   * @throws InterruptedException
   */
  @Test
  public void isDisplayTest() {
	  driver.get("http://www.baidu.com");
	  Boolean res = driver.findElement(By.id("su")).isDisplayed();
	  Assert.assertTrue(res);
  }
  
  /**
   * 截图测试
 * @throws IOException 
   * @throws InterruptedException
   */
  @Test
  public void screenShotTest() throws IOException {
	  driver.get("http://www.baidu.com");
	  File file = ((RemoteWebDriver)driver).getScreenshotAs(OutputType.FILE);
	  Files.copy(file,new File("C:\\Users\\wuwu\\Desktop\\a.png"));
	  
  }
  
  @AfterTest
  public void closeChromeTest() throws InterruptedException {
	  if(driver != null) {
		  Thread.sleep(3000);
		  driver.quit();
	  }
  }
}

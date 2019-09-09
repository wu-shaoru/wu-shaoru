package com.hustar.TestDemo;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class locateElement {
	  WebDriver driver;
	  @BeforeTest
	  public void openChromeTest() throws InterruptedException {
		  System.setProperty("webdriver.chrome.driver","D:\\Java\\apache-maven-3.6.1\\drivers\\chromedriver.exe");
		  driver = new ChromeDriver();
	  }
	  /**
	   * 八种元素定位方式
	   * id,name,classname,tagname,linktext,partialLinkText,xPath,sccSelector
	   * 1.by.id
	 * @throws InterruptedException 
	   */
	  @Test
	  public void byIdTest() throws InterruptedException {
		  driver.get("http://www.baidu.com");
		  WebElement element = driver.findElement(By.id("kw"));
		  element.sendKeys("selenium");
	  }
	  
	  @Test
	  public void bynameTest() throws InterruptedException {
		  driver.get("http://www.baidu.com");
		  Thread.sleep(3000);
		  WebElement element = driver.findElement(By.name("wd"));
		  element.sendKeys("你好");
	  }
	  
	  @Test
	  public void byclassNameTest() throws InterruptedException {
		  driver.get("http://www.baidu.com");
		  WebElement element = driver.findElement(By.className("mnav"));
		  element.click();
	  }
	  
	  @Test
	  public void bytagName() {
		  driver.get("http://www.baidu.com");
		  String tagname = driver.findElement(By.tagName("area")).getTagName();
		  System.out.println(tagname);
	  }
	  
	  @Test
	  public void bylinkTextTest() throws InterruptedException {
		  driver.get("http://www.baidu.com");
		  driver.findElement(By.linkText("新闻")).click();
		  Thread.sleep(3000);
	  }
	  
	  @Test
	  public void partialLinkText() {
		  driver.get("http://www.baidu.com");
		  driver.findElement(By.partialLinkText("新")).click();
	  }
	  
	  @Test
	  public void cssSelector() {
		  driver.get("http://www.baidu.com");
		  driver.findElement(By.cssSelector("#u1 > a:nth-child(1)")).click();;
	  }
	  
	  @Test
	  public void xpathTest() {
		  
		  driver.get("http://www.baidu.com");
		  List<WebElement> drivers = driver.findElements(By.xpath("//*[@id=\"u1\"]/a"));
		  for(WebElement element:drivers) {
			  System.out.println(element.toString());
		  }
	  }
  
	  @AfterTest
	  public void closeChromeTest() throws InterruptedException {
		  if(driver != null) {
			  Thread.sleep(3000);
			  driver.quit();
		  }
	  }
}

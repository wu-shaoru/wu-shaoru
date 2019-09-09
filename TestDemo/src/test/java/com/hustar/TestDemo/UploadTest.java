package com.hustar.TestDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UploadTest {
	  WebDriver driver;
	  @BeforeTest
	  public void openChromeTest() throws InterruptedException {
		  System.setProperty("webdriver.chrome.driver","D:\\Java\\apache-maven-3.6.1\\drivers\\chromedriver.exe");
		  driver = new ChromeDriver();
	  }
	  @Test
	  public void uploadTest() throws InterruptedException {
		  driver.get("https://mail.10086.cn/");
		  Thread.sleep(3000);
		  driver.findElement(By.id("txtUser")).sendKeys("15135960754");
		  driver.findElement(By.id("txtPass")).sendKeys("wushaoru011301");
		  
		  driver.findElement(By.id("loginBtn")).click();
		  Thread.sleep(3000);
	  }
	  
	  
	  /**
	   * 返回元素的尺寸
	   * @throws InterruptedException
	   */
	  @Test
	  public void sizeTest() {
		  driver.get("http://www.baidu.com");
		  Dimension dimension = driver.findElement(By.id("kw")).getSize();
		  System.out.println(dimension.toString());
	  }
	  
	  @AfterTest
	  public void closeChromeTest() throws InterruptedException {
		  if(driver != null) {
			  Thread.sleep(3000);
			  driver.quit();
		  }
	  }
}

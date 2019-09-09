package com.hustar.TestDemo.day3;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SeleniumGridTest {
	@DataProvider(name="data2")
	public Object[][] data(){
		return new Object[][] {
			{"http://222.24.18.34:4444/wd/hub","chrome"},
			{"http://222.24.18.34:4444/wd/hub","chrome"}
		};
	}
  @Test(dataProvider = "data2")
  public void f(String url,String browser) throws MalformedURLException, InterruptedException {
	  
	  DesiredCapabilities desiredCapabilities ;
	  if(browser.equals("chrome")) {
		  desiredCapabilities = DesiredCapabilities.chrome();
	  }else if (browser.equals("firefox")) {
		  desiredCapabilities = DesiredCapabilities.firefox();		
	  }else {
		  desiredCapabilities = DesiredCapabilities.chrome();
	  }
	  WebDriver driver = new RemoteWebDriver(new URL(url),desiredCapabilities);
	  driver.get("http://www.baidu.com");
	  System.out.println("f");
	  Thread.sleep(3000);
	  driver.quit();
  }
  
  
  @Test(dataProvider = "data2")
  public void f1(String url,String browser) throws MalformedURLException, InterruptedException {
	  
	  DesiredCapabilities desiredCapabilities ;
	  if(browser.equals("chrome")) {
		  desiredCapabilities = DesiredCapabilities.chrome();
	  }else if (browser.equals("firefox")) {
		  desiredCapabilities = DesiredCapabilities.firefox();		
	  }else {
		  desiredCapabilities = DesiredCapabilities.chrome();
	  }
	  WebDriver driver = new RemoteWebDriver(new URL(url),desiredCapabilities);
	  driver.get("http://www.baidu.com");
	  System.out.println("f1");
	  Thread.sleep(3000);
	  driver.quit();
  }
}

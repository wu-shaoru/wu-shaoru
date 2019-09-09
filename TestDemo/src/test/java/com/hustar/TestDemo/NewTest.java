package com.hustar.TestDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class NewTest {
	WebDriver driver;
	@BeforeTest
	public void open() {	
	}
	/**
	 * 启动Chrome浏览器
	 * 1.设置driver路径
	 * 2.new一个ChromeDriver对象，启动Chrome浏览器
	 * 3.用driver.get()方法访问百度页面
	 * 4.等待3秒
	 * 5.退出浏览器
	 * @throws InterruptedException
	 */
//	@Test
//	public void openChromeTest() throws InterruptedException {
//		System.setProperty("webdriver.chrome.driver", "D:\\Java\\apache-maven-3.6.1\\drivers\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.get("http://www.baidu.com");
//	}
	
	/**
	 * 启动IE浏览器
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void openIETest() {
		System.setProperty("webdriver.ie.driver", "D:\\Java\\apache-maven-3.6.1\\drivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.get("http://www.baidu.com");
	}
	
	@AfterTest
	public void close() throws InterruptedException {
		if(driver != null) {
			Thread.sleep(3000);
			driver.quit();
		}
	}


}

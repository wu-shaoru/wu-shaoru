package com.hustar.TestDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UIAutomationTest {
	WebDriver driver;
	@BeforeTest
	public void open() {
		System.setProperty("webdriver.chrome.driver", "D:\\\\Java\\\\apache-maven-3.6.1\\\\drivers\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///F:/Web自动化selenium+java/源码/webdriver_demo/selenium_html/index.html");
	}
	
	/**
	 * Alert的处理
	 * 1.打开file:///F:/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium+java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html
	 * 2.定位alert元素
	 * 3.点击alert按钮
	 * 4.转交driver控制权给Alert
	 * 5.Alert点击确定accept()
	 * @throws InterruptedException 
	 */

	@Test
	public void alertTest() throws InterruptedException {
	
		driver.findElement(By.xpath("//*[@id=\"alert\"]/input")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(3000);
	}
	
	/**
	 * 打开UI自动化测试主页
	 * 点击confirm按钮
	 * 再confirm警告框点击确认或取消按钮
	 * @throws InterruptedException 
	 */
	@Test
	public void confirmTest() throws InterruptedException {
		driver.findElement(By.className("confirm")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		Thread.sleep(3000);
		alert.accept();
	}
	
	
	/**
	 * 打开UI自动化测试主页
	 * 点击prompt弹窗
	 * 再弹窗中输入，点击确定/取消按钮
	 * @throws InterruptedException
	 */
	@Test
	public void promptTest() throws InterruptedException {
		driver.findElement(By.className("prompt")).click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("这是Prompt");
		Thread.sleep(3000);
		alert.accept();
	}
	
	/**
	 * iFrame的处理
	 * 1.定位IFrame
	 * 2.driver控制权转交给IFrame
	 * 3.操作IFrame中的元素
	 * 4.driver控制权交回原页面
	 * @throws InterruptedException
	 */
	@Test
	public void iframetTest() throws InterruptedException {
		driver.switchTo().frame("aa");
		driver.findElement(By.linkText("baidu")).click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.findElement(By.id("user")).sendKeys("nihao");
	}
	
	/**
	 * 下拉框的处理
	 * 1.selectByIndex()根据索引来选取，从0开始
	 * 2.selectByValue()根据value属性值来选取
	 * 3.selectByVisibleText();根据标签之间的Text值，也就是页面显示的
	 * @throws InterruptedException
	 */
	@Test
	public void selectTest() throws InterruptedException {
		WebElement element = driver.findElement(By.id("moreSelect"));
		Select select = new Select(element);
		select.selectByIndex(2);
		Thread.sleep(3000);
		select.selectByValue("meizu");
		Thread.sleep(3000);
		select.selectByVisibleText("huawei");
		
	}
	
	/**
	 * 多窗口的处理
	 * @throws InterruptedException
	 */
	@Test
	public void winTest() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.linkText("Open new window")).click();
		String handle = driver.getWindowHandle();
		for(String handles:driver.getWindowHandles()) {
			if(handle != handles) {
				driver.switchTo().window(handles);
			}
		}
		driver.findElement(By.id("user")).sendKeys("test1");
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(handle);
		driver.findElement(By.id("user")).sendKeys("test2");
	}
	
	/**
	 * 元素等待
	 * ‘1.线程等待：Thread。sleep（）
	 * 2.全局等待：driver.manage().timeout().implicitlyWait(30,TimeUnit.Seconds)
	 * 3.显示等待：
	 * new WebDriverWait(driver,30).until(ExceptedConditions.presenceOfElementLocated(By))
	 * @throws InterruptedException
	 */
	
	@Test
	public void waitTest() {
		
//		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("user")));
//		driver.findElement(By.id("s"));
	}


	
	@AfterTest
	public void close() throws InterruptedException {
		if(driver != null) {
			Thread.sleep(3000);
			driver.quit();
		}
	}
}

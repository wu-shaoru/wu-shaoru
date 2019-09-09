package com.hustar.TestDemo.day3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
	WebDriver driver;
	
	@Test
	public void errorLogin() {
		driver.findElement(By.id("switchAccountLogin")).click();
		  driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"loginDiv\"]//iframe")));
		  driver.findElement(By.name("email")).sendKeys("wu_shaoru");
		  driver.findElement(By.name("password")).sendKeys("wushaoru011301");
		  driver.findElement(By.id("dologin")).click();
		  String text = driver.findElement(By.xpath(".//*[text()=\"帐号或密码错误\"]")).getText();
		  Assert.assertEquals(text, "帐号或密码错误");
	}

  @Test
  public void LoginTest() throws InterruptedException {
	  new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("switchAccountLogin")));
	  driver.findElement(By.id("switchAccountLogin")).click();
	  driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"loginDiv\"]//iframe")));
	  driver.findElement(By.name("email")).sendKeys("wu_shaoru");
	  driver.findElement(By.name("password")).sendKeys("wushaoru0113");
	  driver.findElement(By.id("dologin")).click();
//	  driver.switchTo().defaultContent();
	  driver.findElement(By.xpath(".//*[@id=\"dvNavTop\"]/ul/li[2]/span[2]")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath(".//*[@aria-label=\"收件人地址输入框，请输入邮件地址，多人时地址请以分号隔开\"]")).sendKeys("wu_shaoru@163.com");
	  driver.findElement(By.xpath(".//*[@aria-label=\"邮件主题输入框，请输入邮件主题\"]/input")).sendKeys("邮件主题");
	  driver.findElement(By.xpath(".//*[@title=\"一次可发送2000张照片，600首MP3，一部高清电影\"]/input")).sendKeys("C:\\Users\\wuwu\\Desktop\\微信图片_20190905210813.jpg");
	  driver.switchTo().frame(driver.findElement(By.className("APP-editor-iframe")));
	  driver.findElement(By.className("nui-scroll")).sendKeys("nerong");
	  driver.switchTo().defaultContent();
	  driver.findElement(By.xpath(".//*[text()=\"发送\"]")).click();
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "F:\\javadocument\\TestDemo\\drivers\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  driver.get("https://mail.163.com/");
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}

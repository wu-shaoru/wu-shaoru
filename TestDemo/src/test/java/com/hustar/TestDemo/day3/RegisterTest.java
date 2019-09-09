package com.hustar.TestDemo.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest {
	WebDriver driver;
  @Test
  public void registerTest() throws InterruptedException {
	  driver.get("https://reg.mail.163.com/unireg/call.do?cmd=register.entrance&from=163mail_right");
//	  driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
//	  new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"commonOperation\"]/a[2]")));
//	  driver.findElement(By.xpath("//*[@id=\"commonOperation\"]/a[2]")).click();
//	  String handle = driver.getWindowHandle();
//	  for(String handles: driver.getWindowHandles()) {
//		  if(handles.equals(handle)) {
//			  continue;
//		  }
//		  driver.switchTo().window(handles);
//	  }
	  System.out.println("register");
	  String time = String.valueOf(System.currentTimeMillis()/100);
	  driver.findElement(By.id("nameIpt")).sendKeys("main"+time);
	  driver.findElement(By.id("mainPwdIpt")).sendKeys("psw"+time);
	  driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("psw"+time);
	  driver.findElement(By.id("vcodeIpt")).sendKeys("123455");
	  driver.findElement(By.id("mainMobileIpt")).sendKeys(time);
	  driver.findElement(By.id("mainAcceptIpt")).click();
	  driver.findElement(By.id("mainRegA")).click();
	  new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"m_vcode\"]/span")));
	  String error = driver.findElement(By.xpath("//*[@id=\"m_vcode\"]/span")).getText();
	  Assert.assertEquals(error, "  验证码不正确，请重新填写");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "F:\\javadocument\\TestDemo\\drivers\\chromedriver.exe");
	  driver = new ChromeDriver();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}

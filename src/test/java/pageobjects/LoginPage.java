package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import testbase.Base;

public class LoginPage extends Base{
	

 public static WebElement username_txt() {
	 return driver.findElement(By.name(readElement("username_txt_name")));
 }
	
 public static WebElement password_txt() {
	 return driver.findElement(By.name(readElement("password_txt_name")));
 }	
	
 public static WebElement login_btn() {
	 return driver.findElement(By.xpath(readElement("login_btn_xpath")));
 }
 
 public static WebElement logout_btn() {
	 return driver.findElement(By.xpath(readElement("logout_xpath")));
 }
 
 public static WebElement logout_msg() {
	 return driver.findElement(By.xpath(readElement("logout_msg_xpath")));
 }
 
 public static WebElement login_msg() {
	 return driver.findElement(By.xpath(readElement("login_msg_xpath")));
 }
}

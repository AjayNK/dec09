package testbase;

import java.io.*;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import java.util.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import pageobjects.LoginPage;

public class Base {
	static Properties p;

	public static WebDriver driver;
	public static Logger log = Logger.getLogger(Base.class);
	public static ExtentReports extentreport;
	public static ExtentTest extenttest;

	@BeforeSuite
	public static void launch_Application() {
		extentreport = new ExtentReports("C:\\Users\\User\\eclipse-workspace_framework_hybrid\\Hybrid_FW\\src\\test\\resources\\reports\\report.html", false);
		driver = new ChromeDriver();
		log.info("Chrome browser launched");
		driver.get(readTestdata("url"));
		log.info("Application url opened: "+readTestdata("url"));
		driver.manage().window().maximize();
		
	}
	
	
	public void Report_Extent() {
	}

	@AfterSuite
	public static void logout_Application() {
		try {
			LoginPage.logout_btn().click();
			Thread.sleep(3000);
			String actual_logout_msg = LoginPage.logout_msg().getText();
			if (actual_logout_msg.equals(readTestdata("logout_msg_expected"))) {
				System.out.println("Logout was successful");
				log.info("Logout was successful");
			} else {
				System.out.println("Logout was unsuccessful");
				log.info("Logout was unsuccessful");
			}
			driver.close();
			extentreport.endTest(extenttest);
			extentreport.flush();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void loadproperty1() {
		try {
			File f = new File(
					"C:\\Users\\User\\eclipse-workspace_framework_hybrid\\Hybrid_FW\\src\\test\\resources\\Testdata.properties");
			FileReader fr = new FileReader(f);
			p = new Properties();
			p.load(fr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String readTestdata(String skey) {
		loadproperty1();
		String x = p.getProperty(skey);
		return x;
	}

	public static void loadproperty2() {
		try {
			File f = new File(
					"C:\\Users\\User\\eclipse-workspace_framework_hybrid\\Hybrid_FW\\src\\test\\resources\\identification.properties");
			FileReader fr = new FileReader(f);
			p = new Properties();
			p.load(fr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String readElement(String skey) {
		loadproperty2();
		String x = p.getProperty(skey);
		return x;
	}
}

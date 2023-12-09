package repo;

import com.relevantcodes.extentreports.LogStatus;

import pageobjects.LoginPage;
import testbase.Base;

public class Repository extends Base{
	
	
	public static void login_application() {
		LoginPage.username_txt().sendKeys(readTestdata("username"));
		log.info("Entered username: "+readTestdata("username"));
		extenttest.log(LogStatus.PASS, "Entered username: "+readTestdata("username"));
		LoginPage.password_txt().sendKeys(readTestdata("password"));
		log.info("Entered password: "+readTestdata("password"));
		extenttest.log(LogStatus.PASS, "Entered password: "+readTestdata("password"));
		LoginPage.login_btn().click();	
		String actual_login_Msg = LoginPage.login_msg().getText();
		if(actual_login_Msg.equals(readTestdata("login_msg_expected"))) {
			log.info("Login was successful");
			System.out.println("Login was successful");
		} else {
			log.info("Login was unsuccessful");
			System.out.println("Login was unsuccessful");
		}
			
	}
	

}

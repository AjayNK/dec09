package repo;

import org.testng.annotations.Test;

import testbase.Base;

public class Test_Login extends Base{
	
	@Test
	public static void Login() {
		Repository.login_application();
		System.out.println("Updated");
	}
	

}

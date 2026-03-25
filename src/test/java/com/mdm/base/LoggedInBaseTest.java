package com.mdm.base;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;

import com.mdm.config.ConfigReader;
import com.mdm.pages.LoginPage;

public class LoggedInBaseTest extends BaseTest {

	@BeforeMethod
	public void login() throws IOException {

		ConfigReader cr = new ConfigReader();

		driver.get(cr.getURL());

		LoginPage lp = new LoginPage(driver);
		lp.userName(cr.getUserName());
		lp.passWord(cr.getPassWord());
		lp.logInButton();

	}

}

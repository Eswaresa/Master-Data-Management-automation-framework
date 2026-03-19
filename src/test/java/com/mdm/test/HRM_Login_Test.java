package com.mdm.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mdm.base.BaseTest;
import com.mdm.config.ConfigReader;
import com.mdm.pages.LoginPage;

public class HRM_Login_Test extends BaseTest {

	LoginPage lp;

	@Test

	public void loginTest_Valid_userName_passWord() throws IOException {
		lp = new LoginPage(driver);
		ConfigReader cr = new ConfigReader();

		String URL = cr.getURL();
		String username = cr.getUserName();
		String password = cr.getPassWord();

		driver.get(URL);
		lp.userName(username);
		lp.passWord(password);
		lp.logInButton();

		String Expected = "OrangeHRM";

		String Actual = driver.getTitle();

		System.out.println(Actual);
		Assert.assertTrue(Expected.contains(Actual));

	}

}

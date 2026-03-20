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

		String ExpectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

		String CurrentURL = driver.getCurrentUrl();

		System.out.println(CurrentURL);
		Assert.assertEquals(CurrentURL, ExpectedUrl);

	}
	
	@Test
	public void loginTest_inValid_passWord() throws IOException {
		lp = new LoginPage(driver);
		ConfigReader cr = new ConfigReader();
		String URL = cr.getURL();
		String username = cr.getUserName();
		String invalidPassword = cr.getInvalidPassword();
		
		driver.get(URL);
		lp.userName(username);
		lp.passWord(invalidPassword);
		lp.logInButton();
		
		String Expected = "Invalid credentials";
		String Actual = lp.invalidMessage();
		
		System.out.println(Actual);
		
		
		Assert.assertTrue(Expected.contains(Actual));
		
		
	}

}

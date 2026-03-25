package com.mdm.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mdm.base.BaseTest;
import com.mdm.config.ConfigReader;
import com.mdm.pages.LoginPage;

public class HRM_Login_Test extends BaseTest {

	LoginPage lp;
	ConfigReader cr;

	@BeforeMethod
	public void init() throws IOException {
		lp = new LoginPage(driver);
		cr = new ConfigReader();

		driver.get(cr.getURL());

	}

	@Test

	public void loginTest_Valid_userName_passWord() throws IOException {

		lp.login(cr.getUserName(), cr.getPassWord());

		String Actual = driver.getTitle();
		Assert.assertTrue(Actual.contains("OrangeHRM"));

		String CurrentURL = driver.getCurrentUrl();
		Assert.assertTrue(CurrentURL.contains("dashboard"));

	}

	@Test
	public void loginTest_inValid_passWord() throws IOException {
		lp.login(cr.getUserName(), cr.getInvalidPassword());

		String Expected = "Invalid credentials";
		Assert.assertEquals(Expected, "Invalid credentials");

	}

}

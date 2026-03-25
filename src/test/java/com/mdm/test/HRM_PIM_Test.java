package com.mdm.test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mdm.base.BaseTest;
import com.mdm.base.LoggedInBaseTest;
import com.mdm.config.ConfigReader;
import com.mdm.pages.LoginPage;
import com.mdm.pages.PIMPage;

public class HRM_PIM_Test extends LoggedInBaseTest {

	PIMPage pim;

	@BeforeMethod
	public void init() {

		pim = new PIMPage(driver);
	}

	@Test()
	public void empListValidation() throws IOException {
		int Actual;
		pim.pimClickButton().click();
		pim.employeeListBtn();
		List<WebElement> empList = pim.employeeList();
		System.out.println(empList.size());

		Actual = empList.size();
		Assert.assertTrue(Actual > 0, ("VEmployee list is empty"));

	}

	@Test()
	public void eployeeSearchValidation() throws IOException {

		pim.pimClickButton().click();
		pim.employeeListBtn();
		pim.employeeNameSearch("Ada");
		pim.selectEmployeeFromDropDown();
		pim.empSearchsubmitBtn();

		List<WebElement> empList = pim.employeeList();
		empList.remove(0);
		System.out.println("Filtered Count: " + empList.size());
		Assert.assertTrue(empList.size() >= 1, "Search result is incorrect");
	}

}

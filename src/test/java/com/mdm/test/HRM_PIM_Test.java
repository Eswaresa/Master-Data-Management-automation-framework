package com.mdm.test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mdm.base.BaseTest;
import com.mdm.config.ConfigReader;
import com.mdm.pages.LoginPage;
import com.mdm.pages.PIMPage;

public class HRM_PIM_Test extends BaseTest {

	LoginPage lp;
	PIMPage pim;

	@Test()
	public void empListValidation() throws IOException {
		lp = new LoginPage(driver);
		pim = new PIMPage(driver);
		ConfigReader cr = new ConfigReader();

		String userName = cr.getUserName();
		String password = cr.getPassWord();

		driver.get(cr.getURL());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for login page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

		lp.userName(userName);
		lp.passWord(password);
		lp.logInButton();

		// Wait for PIM menu
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//aside//span[text()='PIM']")));

		pim.pimClickButton().click();
		pim.employeeListBtn();

		// Wait for employee list
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='oxd-table-card']")));

		List<WebElement> empList = pim.employeeList();

		System.out.println(empList.size());

		int Actual = empList.size();

		Assert.assertTrue(Actual > 0, "Value is not greater than 0");

	}

	@Test()
	public void eployeeSearchValidation() throws IOException {

		lp = new LoginPage(driver);
		pim = new PIMPage(driver);
		ConfigReader cr = new ConfigReader();

		String userName = cr.getUserName();
		String password = cr.getPassWord();

		driver.get(cr.getURL());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Login
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		lp.userName(userName);
		lp.passWord(password);
		lp.logInButton();

		// Navigate to PIM
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//aside//span[text()='PIM']")));
		pim.pimClickButton().click();
		pim.employeeListBtn();

		// Search
		pim.employeeNameSearch("Ada");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='listbox']")));

		pim.selectEmployeeFromDropDown();
		pim.empSearchsubmitBtn();

		// REPLACE WAIT HERE
		wait.until(ExpectedConditions
				.numberOfElementsToBeMoreThan(By.xpath("//div[contains(@class,'oxd-table-row') and @role='row']"), 1));

		// THEN fetch elements
		List<WebElement> empList = pim.employeeList();

		// remove header row
		empList.remove(0);

		System.out.println("Filtered Count: " + empList.size());

		Assert.assertTrue(empList.size() >= 1, "Search result is incorrect");
	}

}

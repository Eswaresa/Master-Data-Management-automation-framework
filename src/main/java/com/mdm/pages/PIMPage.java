package com.mdm.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIMPage {

	WebDriver driver;
	WebDriverWait wait;

	By PIMClickBtn = By.xpath("//aside//span[text()='PIM']");
	By EmployeeListBtn = By.xpath("//div[@id='app']/div[1]/div[1]/header/div[2]/nav/ul/li[2]/a");
	By EmployeeList = By.xpath("//div[contains(@class,'oxd-table-row') and @role='row']");
	By EmployeeNameSearch = By.xpath("(//input[@placeholder='Type for hints...'])[1]");
	By EmployeeSearchSubmitBtn = By.xpath("//button[@type = 'submit']");
	By EmployeeSuggestion = By.xpath("//div[@role='listbox']//div[@role='option']");

	public PIMPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public WebElement pimClickButton() {

		return driver.findElement(PIMClickBtn);
	}

	public void employeeListBtn() {
		driver.findElement(EmployeeListBtn).click();
	}

	public List<WebElement> employeeList() {
		return driver.findElements(EmployeeList);

	}

	public void employeeNameSearch(String empName) {

		driver.findElement(EmployeeNameSearch).sendKeys(empName);
	}

	public void empSearchsubmitBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(EmployeeSearchSubmitBtn)).click();
	}

	public void selectEmployeeFromDropDown() {

		// wait for dropdown to appear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='listbox']")));

		List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(EmployeeSuggestion));

		if (!options.isEmpty()) {
			options.get(0).click();
		} else {
			// fallback (VERY IMPORTANT)
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		}
	}

}
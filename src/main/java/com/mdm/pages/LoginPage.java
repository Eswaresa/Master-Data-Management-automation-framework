package com.mdm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mdm.utils.WaitUtils;

public class LoginPage {

	WebDriver driver;
// Locators
	By usernmae = By.name("username");
	By password = By.name("password");
	By loginBtn = By.xpath("//button[@type = 'submit']");
	By invalidMsg = By.xpath("//div[@role = 'alert']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}
	
	

	public void userName(String user) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    WebElement usernameField = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(By.name("username"))
	    );
	    usernameField.sendKeys(user);
	}

	public void passWord(String pass) {
		driver.findElement(password).sendKeys(pass);
	}

	public void logInButton() {
		driver.findElement(loginBtn).click();
	}
	
	public String invalidMessage() {
		return driver.findElement(invalidMsg).getText();
		
	}
	public void login(String user, String pass) {
	    WaitUtils.waitforElement(driver, usernmae).sendKeys(user);
	    driver.findElement(password).sendKeys(pass);
	    driver.findElement(loginBtn).click();
	}

}

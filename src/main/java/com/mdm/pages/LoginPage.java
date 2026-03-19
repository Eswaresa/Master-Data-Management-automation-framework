package com.mdm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	By usernmae = By.name("username");
	By password = By.name("password");
	By loginBtn = By.xpath("//button[@type = 'submit']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}
	
	public void userName(String user) {
		driver.findElement(usernmae).sendKeys(user);
	}
	public void passWord(String pass) {
		driver.findElement(password).sendKeys(pass);
	}
	public void logInButton() {
		driver.findElement(loginBtn).click();
	}

}

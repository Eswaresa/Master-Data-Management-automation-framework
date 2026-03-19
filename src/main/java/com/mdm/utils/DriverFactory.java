package com.mdm.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	private static WebDriver driver;

	public static void initDriver() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static WebDriver getDriver() {
		return driver;
	}

}

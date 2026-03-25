package com.mdm.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.mdm.utils.DriverFactory;

public class BaseTest {

protected WebDriver driver;

@BeforeMethod
public void setUp() {
	DriverFactory.initDriver();
	driver = DriverFactory.getDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
}

@AfterMethod
public void tearDown() {
	
	DriverFactory.quitDriver();
}


}

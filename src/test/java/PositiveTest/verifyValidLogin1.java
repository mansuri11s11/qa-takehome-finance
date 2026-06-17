package PositiveTest;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

public class verifyValidLogin1 {

	WebDriver driver;
	@Test
	public void verifyValidLogin() {

	    LoginPage login = new LoginPage(driver);

	    login.enterUsername("Admin");
	    login.enterPassword("admin123");
	    login.clickLogin();

	    WebDriverWait wait =
	        new WebDriverWait(driver, Duration.ofSeconds(30));

	    wait.until(ExpectedConditions.urlContains("dashboard"));

	    Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
	}
}

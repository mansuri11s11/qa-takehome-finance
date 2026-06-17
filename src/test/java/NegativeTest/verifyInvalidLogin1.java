package NegativeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

public class verifyInvalidLogin1 {
	
	WebDriver driver;
	@Test
	public void verifyInvalidLogin() {

	    LoginPage login = new LoginPage(driver);

	    login.enterUsername("Admin");
	    login.enterPassword("WrongPassword");
	    login.clickLogin();

	    WebDriverWait wait =
	        new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//p[contains(@class,'alert-content-text')]")));

	    Assert.assertEquals(
	            login.getErrorMessage(),
	            "Invalid credentials");
	}

}

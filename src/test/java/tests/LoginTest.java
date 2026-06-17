package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

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
    
    @Test 
	public void verifyInvalidLogin() {

	    LoginPage login = new LoginPage(driver);

	    login.enterUsername("Admin");
	    login.enterPassword("WrongPassword");
	    login.clickLogin();

	    WebDriverWait wait =
	        new WebDriverWait(driver, Duration.ofSeconds(30));

	    wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//p[contains(@class,'alert-content-text')]")));

	    Assert.assertEquals(
	            login.getErrorMessage(),
	            "Invalid credentials");
	}


    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}
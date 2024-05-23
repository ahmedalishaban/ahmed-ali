package com.saucedemo.tests;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.Utilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    @BeforeClass
    public void setUp(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void loadApplication(){
        loginPage = new LoginPage(driver,
                new WebDriverWait(driver, Duration.ofSeconds(10)));
    }

    @Test(priority = 1)
    public void verifyValidUsernameAndPassword(){
        loginPage.openLoginPage();
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginBTN();

            Assert.assertEquals(Utilities.getURL(driver),
                    "https://www.saucedemo.com/inventory.html",
                    "You have logged in successfully");
    }


    @Test(priority = 2)
    public void verifyValidUsernameAndInvalidPassword(){
        loginPage.openLoginPage();
        loginPage.setUsername("standard_user");
        loginPage.setPassword("ahmedali123");
        loginPage.clickLoginBTN();

            assertErrorMsg("Epic sadface: Username and password do not match any user in this service");

    }


    @Test(priority = 3)
    public void verifyInvalidUsernameAndValidPassword(){
        loginPage.openLoginPage();
        loginPage.setUsername("ahmedali123");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginBTN();
            assertErrorMsg("Epic sadface: Username and password do not match any user in this service");

    }


    @Test(priority = 4)
    public void verifyInvalidUsernameAndInvalidPassword(){
        loginPage.openLoginPage();
        loginPage.setUsername("ahmedali123");
        loginPage.setPassword("ahmedali123");
        loginPage.clickLoginBTN();
            assertErrorMsg("Epic sadface: Username and password do not match any user in this service");


    }


    @Test(priority = 5)
    public void verifyUsernameAndPasswordEmpty(){
        loginPage.openLoginPage();
        loginPage.setUsername("");
        loginPage.setPassword("");
        loginPage.clickLoginBTN();
            assertErrorMsg("Epic sadface: Username is required");

    }

    @AfterMethod
    public void takeFailedScreenShots(ITestResult testResult){
        if (ITestResult.FAILURE == testResult.getStatus()) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") +
                    "\\src\\main\\resources\\screenshots\\" + testResult.getName() + ".png");
            try {
                FileHandler.copy(source,destination);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void assertErrorMsg(String expectedMsg){

        SoftAssert softAssert = new SoftAssert();

        Assert.assertEquals(Utilities.getURL(driver),
                "https://www.saucedemo.com/",
                "You are prevented to login");

        softAssert.assertEquals(loginPage.getErrorMessage(),
                        expectedMsg,
                "You are blocked to login");

        softAssert.assertEquals(loginPage.getErrorMsgColor(),
                "rgba(226, 35, 26, 1)",
                "The error message not working properly");

        softAssert.assertAll();
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

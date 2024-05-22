package com.instabug.tests;

import com.instabug.pages.BasePage;
import com.instabug.pages.LoginPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    private WebDriver driver;
    protected LoginPage loginPage;
    protected BasePage basePage;

    @BeforeClass
    public void setUp(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @BeforeMethod
    public void loadApplication(){
        basePage = new BasePage();
        loginPage = new LoginPage();
        basePage.setDriver(driver);
    }




}

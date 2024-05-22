package com.saucedemo.tests;

import com.saucedemo.pages.BasePage;
import com.saucedemo.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

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

package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends BaseTest {


    @Test(priority = 1)
    public void verifyValidUsernameAndPassword(){
        loginPage.openLoginPage();
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginBTN();

            Assert.assertEquals(basePage.getURL(),
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

    private void assertErrorMsg(String expectedMsg){

        SoftAssert softAssert = new SoftAssert();

        Assert.assertEquals(basePage.getURL(),
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

}

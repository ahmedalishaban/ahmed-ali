package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final String loginPage = "https://www.saucedemo.com/";
    private final By usernameElem = By.id("user-name");
    private final By passwordElem = By.id("password");
    private final By loginBtn = By.id("login-button");
    private final By errorMsg = By.xpath("//h3[@data-test='error']");
    private final By errorMsgBackground =
            By.xpath("//div[contains(@class,'error-message-container')]");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void openLoginPage(){
        Utilities.openPage(driver,loginPage);
    }

    public void setUsername(String username){Utilities.setText(driver,usernameElem, username);}

    public void setPassword(String password){Utilities.setText(driver,passwordElem, password);}

    public void clickLoginBTN(){
        Utilities.click(driver,loginBtn);
    }

    public String getErrorMessage(){
       return Utilities.getText(wait,errorMsg);
    }

    public String getErrorMsgColor(){
        return Utilities.getElemColor(wait,errorMsgBackground);
    }







}

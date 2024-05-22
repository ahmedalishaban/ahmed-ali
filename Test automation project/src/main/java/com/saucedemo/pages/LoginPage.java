package com.saucedemo.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    String loginPage = "https://www.saucedemo.com/";
    By usernameElem = By.id("user-name");
    By passwordElem = By.id("password");
    By loginBTN = By.id("login-button");
    By errorMsg = By.xpath("//h3[@data-test='error']");
    By errorMsgBackground =
            By.xpath("//div[contains(@class,'error-message-container')]");

    public void openLoginPage(){
        openPage(loginPage);
    }

    public void setUsername(String username){
        setText(usernameElem,
                username);
    }

    public void setPassword(String password){
        setText(passwordElem,
                password);
    }

    public void clickLoginBTN(){
        click(loginBTN);
    }

    public String getErrorMessage(){
       return getText(errorMsg);
    }

    public String getErrorMsgColor(){
        return getColor(errorMsgBackground);
    }







}

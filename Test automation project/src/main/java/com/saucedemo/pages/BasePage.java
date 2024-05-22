package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private static WebDriver driver;

    public void setDriver(WebDriver driver){
        BasePage.driver = driver;
    }

    protected void openPage(String pageURL){
        driver.navigate().to(pageURL);
    }

    protected WebElement find(By locator){
        return driver.findElement(locator);
    }


    protected void click(By locator){
        driver.findElement(locator).click();
    }


    public String getURL(){
        return driver.getCurrentUrl();
    }

    public void setText(By locator ,String text){
        driver.findElement(locator).sendKeys(text);
    }

    public String getText(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String text =  wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
        System.out.println("Current Text: " + text);
        return text;
    }

    public String getColor(By locator){

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        return wait.until(ExpectedConditions
                        .visibilityOfElementLocated(locator))
                .getCssValue("background-color");
    }

}

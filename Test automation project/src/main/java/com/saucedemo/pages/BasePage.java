package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
        String text =  waitForElement(locator).getText();
        System.out.println("Current Text: " + text);
        return text;
    }

    public String getElemColor(By locator){
        return waitForElement(locator).getCssValue("background-color");
    }

    protected WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}

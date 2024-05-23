package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Utilities {

    public static void openPage(WebDriver driver,String pageURL){
        driver.navigate().to(pageURL);
    }

    public static WebElement find(WebDriver driver, By locator){
        return driver.findElement(locator);
    }


    public static void click(WebDriver driver, By locator){
        driver.findElement(locator).click();
    }


    public static String getURL(WebDriver driver){
        return driver.getCurrentUrl();
    }

    public static void setText(WebDriver driver,By locator ,String text){
        driver.findElement(locator).sendKeys(text);
    }

    public static String getText(WebDriverWait wait, By locator){

        String text =  waitForElement(wait,locator).getText();
        System.out.println("Current Text: " + text);
        return text;
    }

    public static String getElemColor(WebDriverWait wait,By locator){
        return waitForElement(wait,locator).getCssValue("background-color");
    }

    public static WebElement waitForElement(WebDriverWait wait,By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}

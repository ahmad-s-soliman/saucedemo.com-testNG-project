package com.swaglabs.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utility {
    public static void clickingWait(WebDriver Driver, By locator){
        new WebDriverWait(Driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(locator))
                .click();
    }

    public static void sendData(WebDriver Driver, By locator, String text){
        new WebDriverWait(Driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(locator))
                .sendKeys(text);
    }
}

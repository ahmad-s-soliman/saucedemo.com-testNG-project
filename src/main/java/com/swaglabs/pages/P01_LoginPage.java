package com.swaglabs.pages;

import com.swaglabs.utils.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage {


    //driver //simple variable declaration without initialization. Upon declaration, IDE suggested implementing constructor, which is below.
    private final WebDriver Driver;


    //Locators //Locators of type By for the needed elements for the login page. All locators are using ID in this case.
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");


    //Driver constructor //As suggested by the IDE.
    public P01_LoginPage(WebDriver Driver) {
        this.Driver = Driver;
    }


    //Actions //Functions that will be needed to execute the test case. Each function accepts relevant variables.
    public P01_LoginPage enterUsername(String user){
        //loginDriver.findElement(username).sendKeys(user);
        Utility.sendData(Driver, username, user);
        return this;
    }

    public P01_LoginPage enterPassword(String pass){
        //loginDriver.findElement(password).sendKeys(pass);
        Utility.sendData(Driver, password, pass);

        return this;
    }

    public void clickOnLoginButton(){
        //loginDriver.findElement(loginButton).click();
        Utility.clickingWait(Driver, loginButton);
        //return new P02_LandingPage(loginDriver);
    }

    //Validations //Expected url is compared to the actual after login attempt.
    public boolean verifyLogin(String expectedURL){
        return Driver.getCurrentUrl().equals(expectedURL);
    }

}

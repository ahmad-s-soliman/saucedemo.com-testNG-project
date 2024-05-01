package com.swaglabs.tests;

import com.swaglabs.pages.P01_LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TC01_LoginTest {

    /*
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass");
    }
    */

    WebDriver Driver;
    P01_LoginPage loginPage; //declaration and initialization in one step
    @BeforeMethod
    public void setup(){
        //System.out.println("beforeMethod");
        Driver = new ChromeDriver();
        Driver.manage().window().maximize();
        Driver.get("https://www.saucedemo.com/");
    }

    @Test //Also referred to as method
    public void validLoginTC(){
        //System.out.println("validLoginTC");
        //step 1: enter username
        //step 2: enter password
        //step 3: click on login button
        new P01_LoginPage(Driver)
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickOnLoginButton();
        //assertion: validate login successfully
       Assert.assertEquals(Driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        //Assert.assertTrue(new P01_LoginPage(testDriver).verifyLogin("https://www.saucedemo.com/inventory.html"));
    }


    @Test //Also referred to as method
    public void invalidLoginTC(){
        //System.out.println("invalidLoginTC");
        new P01_LoginPage(Driver)
                .enterUsername("standard_user")
                .enterPassword("falsePass")
                .clickOnLoginButton();
        //assertion: validate login successfully
        Assert.assertFalse(new P01_LoginPage(Driver).verifyLogin("https://www.saucedemo.com/inventory.html"));

    }

    @AfterMethod
    public void quit(){
        //System.out.println("afterMethod");
        Driver.quit();
    }

    /*
    @AfterClass
    public void afterClass(){
        System.out.println("afterClass");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("afterTest");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite");
    }

     */
}

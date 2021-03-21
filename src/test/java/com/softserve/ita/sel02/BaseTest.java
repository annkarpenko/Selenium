package com.softserve.ita.sel02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private final static int SECONDSTOWAIT = 10;
    public WebDriver driver;
    public WebDriverWait wait;
    public Page page;
    public String baseURL;

    @BeforeClass
    public void setup () {
        //Create a Chrome driver. All test classes use this.
        driver = new ChromeDriver();

        //Set beseURL
        baseURL = "http://www.leafground.com/home.html";

        driver.manage().timeouts().implicitlyWait(SECONDSTOWAIT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        page = new Page(driver);
    }

    /*
    @AfterClass
    public void teardown () {
        driver.quit();
    }*/


}

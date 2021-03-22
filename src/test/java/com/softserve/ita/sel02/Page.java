package com.softserve.ita.sel02;

import com.softserve.ita.sel02.pages.ButtonsPage;
import com.softserve.ita.sel02.pages.DisapperPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.softserve.ita.sel02.pages.RadioButtonsPage;

public class Page {
    private final int timeOut = 10;
    public WebDriver driver;
    public WebDriverWait wait;

    //Pages
    private RadioButtonsPage _radioButtonsPage;
    private ButtonsPage _ButtonsPage;

    //Constructor
    public Page(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, timeOut);
    }


    public RadioButtonsPage radioButtonsPage() {
        return (_radioButtonsPage == null) ? (_radioButtonsPage = new RadioButtonsPage(this)) : (_radioButtonsPage);
    }

    public ButtonsPage ButtonsPage() {
        return (_ButtonsPage == null) ? (_ButtonsPage = new ButtonsPage(this)) : (_ButtonsPage);
    }

  /*  public DisapperPage DisapperPage() {
        return (_DisapperPage == null) ? (_DisapperPage = new DisapperPage(this)) : (_DisapperPage);
    }*/

    // Open URL
    public void open(String url) {
        driver.get(url);
    }

    //Clicks by selector
    public void click(By selector) {
        driver.findElement(selector).click();
    }

    //Clicks on WebElement
    public void click(WebElement element) {
        element.click();
    }





}

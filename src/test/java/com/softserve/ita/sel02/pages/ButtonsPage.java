package com.softserve.ita.sel02.pages;

import com.softserve.ita.sel02.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

public class ButtonsPage {
    public Page page;

    public ButtonsPage (Page p){
        page = p;
    }

    public By goToButtonPageButton = By.xpath("//*[contains(text(), 'Button')]");
    public By goToHomePageButton = By.xpath("//button[@id='home']");
    public By getPositionButton = By.xpath("//button[@id='home']");
    public By colorButton = By.xpath("//button[@id='color']");
    public By sizeButton = By.xpath("//button[@id='size']");


    public void goToButtonPage() {
        page.click(goToButtonPageButton);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickGoToHomePageButton (){
        page.driver.findElement(goToHomePageButton).click();

    }

    public Point getPositionButton(){
        return page.driver.findElement(getPositionButton).getLocation();
    }

    public String getColorButton(){
        return page.driver.findElement(colorButton).getCssValue("background-color");

    }

    public String getWidthHeightButtonTest(){
        String height = String.valueOf(page.driver.findElement(sizeButton).getSize().getHeight());
        String width = String.valueOf(page.driver.findElement(sizeButton).getSize().getWidth());
        return height + " " + width;
    }




}

package com.softserve.ita.sel02.test;

import com.softserve.ita.sel02.BaseTest;
import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ButtonsPageTest extends BaseTest {

    @BeforeClass
    public void start() {
        page.open(baseURL);
        page.ButtonsPage().goToButtonPage();
    }


    @Test
    public void getButtonPositionTest(){
        Point location = page.ButtonsPage().getPositionButton();
        String position = location.toString();
        String expectedPosition = "(240, 200)";
        Assert.assertEquals(position, expectedPosition,  "Current position: 240, 200");
    }


    @Test
    public void getColorButtonTest(){
        String color = page.ButtonsPage().getColorButton();
        String expectedColor = "rgba(144, 238, 144, 1)";
        Assert.assertEquals(color, expectedColor, "button color is rgba(144, 238, 144, 1)");
    }

    @Test
    public void getSizeButtonTest(){
        String size = page.ButtonsPage().getWidthHeightButtonTest();
        String expectedSize = "20 122";
        Assert.assertEquals(size, expectedSize, "button size is not 20 122");
    }

    @Test
    public void goToHomePageButtonTest(){
        page.ButtonsPage().clickGoToHomePageButton();
    }



}

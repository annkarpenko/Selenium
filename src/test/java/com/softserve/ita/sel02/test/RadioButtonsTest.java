package com.softserve.ita.sel02.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.softserve.ita.sel02.BaseTest;

public class RadioButtonsTest extends BaseTest {

    @AfterTest
    public void start (){
    page.open(baseURL);
    page.radioButtonsPage().goToRadioButtonPage();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void ButtonTest (){
        page.radioButtonsPage().selectYesButton();
        System.out.println("Are you enjoying the classes? - yes is selected");


    }

}

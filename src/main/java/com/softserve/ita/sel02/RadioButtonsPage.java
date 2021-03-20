package com.softserve.ita.sel02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;

public class RadioButtonsPage {


    public static void main(String[] args) {
        String url = "http://www.leafground.com/pages/radio.html";
        ChromeDriver driver = new ChromeDriver();

        //open a window
        driver.get(url);

        //1. Choose Yes by Id
        driver.findElementByCssSelector("#yes").click();

        //2.Find default selected radio button
        //Create list of inputs by name
        List<WebElement> input = driver.findElements(By.name("news"));

        //find input values
        for (WebElement webElement : input) {
            String checked = webElement.getAttribute("checked");
            if (checked == null) {
                checked = "false";
            }

            String labelText = ((RemoteWebElement) input.get(1)).findElementByXPath("..").getText();
            if (checked.equals("true")) {
                System.out.println("The title of default radio button: " + labelText);
            }
        }

        //Select age group
        int myAge = 18;

        if (myAge < 21) {
            driver.findElementByXPath("//*[@id=\"contentblock\"]/section/div[3]/div/div/input[1]").click();
        } else if (myAge > 40){
            driver.findElementByXPath("//*[@id=\"contentblock\"]/section/div[3]/div/div/input[3]").click();
        } else {
            driver.findElementByXPath("//*[@id=\"contentblock\"]/section/div[3]/div/div/input[2]").click();
        }

    }
}
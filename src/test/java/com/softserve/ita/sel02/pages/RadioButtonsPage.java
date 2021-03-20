package com.softserve.ita.sel02.pages;

import com.softserve.ita.sel02.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;

public class RadioButtonsPage {
    public Page page;

    public RadioButtonsPage (Page p){
        page = p;
    }

    public By RadioButtonPage = By.xpath("//*[contains(text(), 'Radio Button')]");
    public By radioButtonYes = By.xpath("//input[@id='yes']");
    public By youngAgeInput = By.xpath("//input[@type='radio' and @name='age' and @value='0']");
    public By middleAgeInput = By.xpath("//input[@type='radio' and @name='age' and @value='1']");
    public By seniorAgeInput = By.xpath("//input[@type='radio' and @name='age' and @value='2']");


    // Go to radioButtonPage
    public void goToRadioButtonPage() {
        page.click(RadioButtonPage);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 1. Choose Yes by Id
    public void selectYesRadioButton() {
        page.click(radioButtonYes);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String verifyAttributes(String attr1) {
        return page.driver.findElement(radioButtonYes).getAttribute(attr1);
    }

    //2.Find default selected radio button
    public void findDefaultRadio(){
        String checked;
        String labelText;

        List<WebElement> input = page.driver.findElements(By.name("news"));

        for (WebElement webElement : input) {
            checked = webElement.getAttribute("checked");
            if (checked == null) {
                checked = "false";
            }

            labelText = ((RemoteWebElement) input.get(1)).findElementByXPath("..").getText();
            if (checked.equals("true")) {
                System.out.println("The title of default radio button: " + labelText);
            }
        }
    }

    //Select age group
    public void selectAgeGroup(int test, int age){
        if (age < 21) {
            page.driver.findElement(youngAgeInput).click();
        } else if (age < 41) {
            System.out.println("Default state");
        } else {
            page.driver.findElement(seniorAgeInput).click();
        }
    }
}

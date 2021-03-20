package com.softserve.ita.sel02.test;

import org.testng.Assert;
import org.testng.annotations.*;

import com.softserve.ita.sel02.BaseTest;

public class RadioButtonsPageTest extends BaseTest {

    @BeforeClass
    public void start() {
        page.open(baseURL);
        page.radioButtonsPage().goToRadioButtonPage();
    }

    @Test
    public void selectYesRadioButtonTest() {
        page.radioButtonsPage().selectYesRadioButton();
        String result = page.radioButtonsPage().verifyAttributes("Checked");
        Assert.assertNotNull(result, "Are you enjoying the classes? - yes is selected");
        System.out.println("Test 1 is finished");
    }

    @Test
    public void findDefaultRadioButtonTest() {
        page.radioButtonsPage().findDefaultRadio();
        System.out.println("Test 2 is finished");
    }

    @Test(dataProvider = "getData")
    public void selectAgeTest(Integer test,Integer age) {
       page.radioButtonsPage().selectAgeGroup(test, age);

    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {1, 0},
                {2, 21},
                {3, 41}
        };
    }
}

package com.softserve.ita.sel01;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Main {
    public static void main(String[]args){
        String url = "http://www.leafground.com/pages/Window.html";
        ChromeDriver driver = new ChromeDriver();

        //open a window
        driver.get(url);

        //find element on “Open Multiple Windows” button
        driver.findElement(By.xpath("//button [text () = 'Open Multiple Windows']")).click();

        //Display all windows titles in console
        Set<String> allWindowHandles = driver.getWindowHandles();
        String titleToSwitch = "";
        
        for (String window: allWindowHandles) {
             driver.switchTo().window(window);
             String title = driver.getTitle();
             System.out.println("Title of opened page: " + title);
             if (title.equals("TestLeaf - Interact with Buttons")){
                 titleToSwitch = window;
             }
        }

        //Switch to one of that windows - to ‘Interact with Buttons’ (Bond with Buttons)
        driver.switchTo().window(titleToSwitch);
        System.out.println("Navigated to 'Interact with Buttons' page");

        //Make it full screen
        driver.manage().window().maximize();

        //Display some title of the button from that page to console
        driver.findElement(By.xpath("//button [text () = 'What color am I?']"));
        System.out.println("Button 'What color am I?' has been found on 'Interact with Buttons' page ");


        //Close all windows
        for (String window: allWindowHandles) {
            driver.switchTo().window(window);
            String title = driver.getTitle();
            driver.close();
            System.out.println("Page is closed: " + title);
        }
    }
}

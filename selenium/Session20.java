package com.evy.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * How to handle slider
 */
public class Session20 {
    public static void main(String[] args) {
        Driver.getDriver().get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
        WebElement min_slider=Driver.getDriver().findElement(By.cssSelector("div>span:first-of-type"));
        WebElement max_slider=Driver.getDriver().findElement(By.cssSelector("div>span:last-of-type"));

        //The distance from top left of the page
        System.out.println(min_slider.getLocation());//(59, 250)
        System.out.println(max_slider.getLocation());//(766, 250)

        //size of elements height and width
        System.out.println(min_slider.getSize());
        System.out.println(max_slider.getSize());

        Actions actions=new Actions(Driver.getDriver());
        actions.dragAndDropBy(min_slider,100,0).perform();
        actions.dragAndDropBy(max_slider,-150,0).perform();

        System.out.println(min_slider.getLocation());
        System.out.println(max_slider.getLocation());


        Driver.quitDriver();


    }
}

package com.evy.selenium;

import org.openqa.selenium.By;

/**
 * How to handle iframes
 */
public class Session14 {
    public static void main(String[] args) {
        Driver.getDriver().get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
        Driver.getDriver().switchTo().frame("iframeResult");
        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.cssSelector("iframe[width]")));
        System.out.println(Driver.getDriver().findElement(By.tagName("h1")).getText());
        Driver.quitDriver();

    }
}

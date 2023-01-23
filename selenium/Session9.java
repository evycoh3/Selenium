package com.evy.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

/**
 * How to select from auto suggest google places dropdown
 */
public class Session9 {
    public static void main(String[] args) throws InterruptedException {
        Driver.getDriver().get("https://www.twoplugs.com/newsearchserviceneed");

        WebElement location = Driver.getDriver().findElement(By.id("autocomplete"));
        location.clear();
        location.sendKeys("israel");
        String txt = null;
        do {
            location.sendKeys(Keys.ARROW_DOWN);
            txt = location.getAttribute("value");
            if (txt.equalsIgnoreCase("Israels Plads, Copenhagen Municipality, Denmark")) {
                location.sendKeys(Keys.ENTER);
                break;
            }
        } while (!txt.isEmpty());
        Thread.sleep(1500);
        Driver.quitDriver();
    }
}

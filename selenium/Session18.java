package com.evy.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * How to handle date picker
 */
public class Session18 {
    public static void main(String[] args) throws InterruptedException {
        Driver.getDriver().get("https://www.redbus.in/");
        Driver.getDriver().findElement(By.id("onward_cal")).click();

        while(true) {
            String monthYear = Driver.getDriver().findElement(By.cssSelector("td.monthTitle")).getText();
            String[] array = monthYear.split(" ");
            String mon = array[0];
            String yr = array[1];
            if (yr.equalsIgnoreCase("2024") && mon.equalsIgnoreCase("Jan")) {
                break;
            } else {
                Driver.getDriver().findElement(By.xpath("//button[text()='>']")).click();
            }
        }
            List<WebElement> days=Driver.getDriver().findElements(By.cssSelector("td.wd.day"));
            for(WebElement element:days){
                if(element.getText().equalsIgnoreCase("11")){
                    element.click();
                    break;
                }
            }



        Thread.sleep(1500);
        Driver.quitDriver();

    }
}

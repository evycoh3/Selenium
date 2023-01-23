package com.evy.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * How to handle java script alerts
 */
public class Session12 {
    public static void main(String[] args) {
        Driver.getDriver().get("http://omayo.blogspot.com/2013/05/page-one.html");
        //Handle Simple Alert
        Driver.getDriver().findElement(By.id("alert1")).click();
        Driver.getDriver().switchTo().alert().accept();

        //Handle 2 button alert( confirm alert)
        Driver.getDriver().findElement(By.id("confirm")).click();
        Driver.getDriver().switchTo().alert().accept();

        //Handle prompt
        Driver.getDriver().findElement(By.id("prompt")).click();
        System.out.println(Driver.getDriver().switchTo().alert().getText());
        Driver.getDriver().switchTo().alert().sendKeys("Hello World!");
        Driver.getDriver().switchTo().alert().accept();

        //Ho to accept alert with WebDriverWait Object
        Driver.getDriver().findElement(By.id("alert1")).click();
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15)).until(ExpectedConditions.alertIsPresent()).accept();

        Driver.quitDriver();

    }
}

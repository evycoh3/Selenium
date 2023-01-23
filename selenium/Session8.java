package com.evy.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * How to handle google auto suggest dropdown
 */
public class Session8 {
    public static void main(String[] args) throws InterruptedException {
        Driver.getDriver().get("https://www.google.com/");


        Driver.getDriver().findElement(By.name("q")).sendKeys("Selenium");
        List<WebElement> list=new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(15)).ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOfAllElements(Driver.getDriver().findElements(By.xpath("//ul[@class='G43f7e']//li//b"))));

        for(WebElement element:list){
                if(element.getText().equalsIgnoreCase("chromedriver")){
                    element.click();
                    break;
                }
            }

        new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(15)).ignoring(StaleElementReferenceException.class)
                        .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='ChromeDriver · SeleniumHQ/selenium Wiki - GitHub']"))).click();
        Thread.sleep(1500);
        Driver.quitDriver();
    }
}

package com.evy.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * How to handle bootstrap dropdowns
 * 1.click on trigger button of the list
 * 2.locate all elements in list
 * 3.iterate the list
 */
public class Session6 {
    public static void main(String[] args) throws InterruptedException {
        Driver.getDriver().get("https://buyme.co.il/");
        WebElement clickOnDropdown=new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[alt='סכום']")));
        clickOnDropdown.click();

        List<WebElement> list=Driver.getDriver().findElements(By.cssSelector("div.dropdown span"));
        for(WebElement element:list){
            if(element.getText().contains("299")){
                element.click();
                break;
            }
        }
        Thread.sleep(1500);
        Driver.quitDriver();


    }
}

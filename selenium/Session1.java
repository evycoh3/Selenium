package com.evy.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Status of WebElements:
 * isDisplayed:if element is displayed (exists) in page
 * isEnabled: if element is enabled o disabled in page(by default all element in page are enabled otherwise its should be metnion as disabled)
 * isSelected:if element is selected(clicked) or not
 *
 * all 3 method will throw 'noSuchElement' exception if element is not exist in the page
 *
 */
public class Session1 {
    public static void main(String[] args) {
        Driver.getDriver().get("https://itera-qa.azurewebsites.net/home/automation");


        //male gender radio button -check selected status
        WebElement maleElement= Driver.getDriver().findElement(By.id("male"));
        System.out.println("male default selected status "+maleElement.isSelected());
        maleElement.click();
        System.out.println("male selected status after clicking: "+maleElement.isSelected());

        //Page Header textbox - check display status
        WebElement header_textbox=Driver.getDriver().findElement(By.cssSelector(".display-3"));
        System.out.println("Page Header displayed status: "+header_textbox.isDisplayed());

        //other gender radio button -enabled/disabled status
        WebElement otherGender=Driver.getDriver().findElement(By.id("other"));
        System.out.println("Other gender enabled status: "+otherGender.isEnabled());



        Driver.quitDriver();

    }
}

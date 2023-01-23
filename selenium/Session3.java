package com.evy.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 *Differences between findElement() & findElements()
 */
public class Session3 {
    public static void main(String[] args) {
        Driver.getDriver().get("https://itera-qa.azurewebsites.net/home/automation");

        /*1st Case: for A single WebElement Present in Page:
         both method will return a single element
        Access:  directly <> iteration
        returnType: WebElement<>list
        * */
        WebElement singleElement=Driver.getDriver().findElement(By.id("male"));
        List<WebElement> singleElementList=Driver.getDriver().findElements(By.id("male"));
        System.out.println(singleElement.getAttribute("value"));
        System.out.println(singleElementList.get(0).getAttribute("value"));


        /*2nd Case: Multiple WebElements present in page
         return the first element present in page <> return all elements
        Access:  directly <> iteration
        returnType: WebElement<>list
         */
        WebElement multipleElements=Driver.getDriver().findElement(By.name("optionsRadios"));
        List<WebElement>multipleElementsList=Driver.getDriver().findElements(By.name("optionsRadios"));
        System.out.println(multipleElements.getAttribute("id"));
        for(WebElement element:multipleElementsList){
            System.out.println(element.getAttribute("id"));
        }

        /*
        3rd Case: if WebElement is not present in page
        throw noSuchElementException <>return a list of 0 elements

         */
      //  Driver.getDriver().findElement(By.id("notExist")).sendKeys("aa");
       List<WebElement>listOfElementNotExist= Driver.getDriver().findElements(By.id("notExist"));
        System.out.println(listOfElementNotExist.size());
        Driver.quitDriver();

    }
}

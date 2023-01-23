package com.evy.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * How to perform keys actions
 * copy & paste example
 */
public class Session21 {
    public static void main(String[] args) {
        Driver.getDriver().get("https://text-compare.com/");
        WebElement textbox1=Driver.getDriver().findElement(By.name("text1"));
        WebElement textbox2=Driver.getDriver().findElement(By.name("text2"));

        textbox1.sendKeys("Hello World!");
        Actions actions=new Actions(Driver.getDriver());
        //CTRL+A
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("a");
        actions.keyUp(Keys.CONTROL);
        actions.perform();
        //CTRL+C
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("c");
        actions.keyUp(Keys.CONTROL);
        actions.perform();

        //TAB-shift to textbox2
        actions.sendKeys(Keys.TAB);
        actions.perform();

        //CTRL+V
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("v");
        actions.keyUp(Keys.CONTROL);
        actions.perform();
        if(textbox1.getAttribute("value").equalsIgnoreCase(textbox2.getAttribute("value"))){
            System.out.println("Text copied");
        }else{
            System.out.println("Text not copied");
        }

        Driver.quitDriver();


    }
}

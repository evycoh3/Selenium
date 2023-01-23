package com.evy.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * How to handle select dropdown is selenium
 */
public class Session5 {
    public static void main(String[] args) throws InterruptedException {
        Driver.getDriver().get("https://demo.guru99.com/test/newtours/register.php");
        WebElement dropdown=Driver.getDriver().findElement(By.name("country"));
        Select select=new Select(dropdown);
        Thread.sleep(1500);
        //Select By visible text
        select.selectByVisibleText("ISRAEL");
        //select by index
        Thread.sleep(1500);
        select.selectByIndex(4);

        //select by value
        Thread.sleep(1500);
        select.selectByValue("CYPRUS");

        //getOption

        List<WebElement> list=select.getOptions();
        for(WebElement element:list){
            if(element.getText().equalsIgnoreCase("fiji")){
                element.click();
                break;
            }
        }
        Thread.sleep(1500);
        Driver.quitDriver();
    }
}

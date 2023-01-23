package com.evy.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

/**
 * How to handle multiple checkbox
 */
public class Session7 {
    public static void main(String[] args) throws InterruptedException {
        Driver.getDriver().get("https://itera-qa.azurewebsites.net/home/automation");
        By list= By.cssSelector("input[class='form-check-input'][type='checkbox']");
    //    selectMultipleCheckboxes(list,"All");
        selectMultipleCheckboxes(list,"monday","friday");
        Thread.sleep(1500);
        Driver.quitDriver();
    }

    public static  void selectMultipleCheckboxes(By by,String ...value){
        List<WebElement>list=Driver.getDriver().findElements(by);
        if(!value[0].equalsIgnoreCase("All")){
            for(WebElement element:list){
                String str=element.getAttribute("id");
                for(String val:value){
                    if(val.equalsIgnoreCase(str)){
                        element.click();
                        break;
                    }
                }
            }
        }else{
            for(WebElement element:list){
                element.click();
            }
        }
    }
}

package com.evy.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {

    public static String getTitle(){
        JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();
       return js.executeScript("return document.title;").toString();
    }
    public static void sendKeys(By by, String value){
        JavascriptExecutor jse = (JavascriptExecutor)Driver.getDriver();
        WebElement element=Driver.getDriver().findElement(by);
        jse.executeScript("arguments[0].value='"+ value +"';", element);
    }
    public static void click(By by){
        JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();
        WebElement element=Driver.getDriver().findElement(by);
        js.executeScript("arguments[0].click();",element);
    }
    public static void scrollToElement(By by){
        WebElement element=Driver.getDriver().findElement(by);
        JavascriptExecutor jse = (JavascriptExecutor)Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView();", element);

    }
    public static void scrollPageDown(){
        JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    public static void scrollPageUp(){
        JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }
    public static void zoomPage(){
        JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();
        js.executeScript("document.body.style.zoom='150%'");
    }
    public static void flush(By by){
        WebElement element=Driver.getDriver().findElement(by);
        JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();
        String color=element.getCssValue("backgroundColor");
        for(int i=0;i<10;i++){
            changeColor(by,"#00000");
            changeColor(by,color);
        }
    }
    public static void changeColor(By by,String color){
        WebElement element=Driver.getDriver().findElement(by);
        JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].style.backgroundColor='"+color+"'",element);
        try{
            Thread.sleep(150);
        }catch (Exception e){
            e.getMessage();
        }
    }



    public static void main(String[] args) throws InterruptedException {
        Driver.getDriver().get("https://www.amazon.com/");
        JavaScriptUtil.scrollPageDown();
        Thread.sleep(1500);
        JavaScriptUtil.scrollPageUp();
        Thread.sleep(1500);
        JavaScriptUtil.zoomPage();
        Thread.sleep(1500);
        JavaScriptUtil.flush(By.id("twotabsearchtextbox"));
        Thread.sleep(1500);
        Driver.quitDriver();
    }
}

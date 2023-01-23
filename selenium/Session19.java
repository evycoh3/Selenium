package com.evy.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

/**
 * Mouse operations in selenium:
 * right click
 * double click
 * drag and drop
 * mouse hover
 */
public class Session19 {
    public static void main(String[] args) throws InterruptedException {
        performDoubleClick();
        performRightClick();
        performDragAndDrop();
        performMouseHover();
        Driver.quitDriver();
    }

    public static void performDoubleClick() throws InterruptedException {
        Driver.getDriver().get("http://omayo.blogspot.com/2013/05/page-one.html");
        WebElement dblClickElement = Driver.getDriver().findElement(By.cssSelector("button[ondblclick]"));
        new Actions(Driver.getDriver()).doubleClick(dblClickElement).build().perform();
        Driver.getDriver().switchTo().alert().accept();
        Thread.sleep(1500);
    }
    public static void performRightClick() throws InterruptedException {
        Driver.getDriver().get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        WebElement rightClick=Driver.getDriver().findElement(By.xpath("//span[text()='right click me']"));
        new Actions(Driver.getDriver()).contextClick(rightClick).build().perform();
        List<WebElement> list=Driver.getDriver().findElements(By.cssSelector("ul[class]>li>span"));
        for(WebElement element:list){
            if(element.getText().equalsIgnoreCase("Edit")){
                element.click();
                break;
            }
        }
        Driver.getDriver().switchTo().alert().accept();
        Thread.sleep(1500);
    }
    public static void performDragAndDrop() throws InterruptedException {
        Driver.getDriver().get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        WebElement ele1=Driver.getDriver().findElement(By.id("box1"));
        WebElement ele2=Driver.getDriver().findElement(By.id("box101"));
        new Actions(Driver.getDriver()).dragAndDrop(ele1,ele2).build().perform();
        Thread.sleep(1500);
    }
    public static void performMouseHover(){
        Driver.getDriver().get("https://demo.nopcommerce.com/");
        WebElement element=Driver.getDriver().findElement(By.cssSelector("ul[class='top-menu notmobile']>li:first-of-type"));
        new Actions(Driver.getDriver()).moveToElement(element).build().perform();
    }
}

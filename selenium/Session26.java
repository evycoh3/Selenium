package com.evy.selenium;

import org.openqa.selenium.By;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

/**
 * How to upload file in selenium
 * 1.send keys
 * robot class
 */
public class Session26 {
    public static void main(String[] args) throws AWTException, InterruptedException {
        Driver.getDriver().get("https://www.foundit.in/");
        Driver.getDriver().findElement(By.cssSelector("i.mqfihd-upload")).click();

        //using sendkeys
    //   Driver.getDriver().findElement(By.id("aa")).sendKeys("file path///");

        //using robot class
        Driver.getDriver().findElement(By.id("file-upload")).click();
        Robot robot=new Robot();
        robot.delay(2000);
        StringSelection s=new StringSelection(System.getProperty("user.dir")+"/download/file-sample_100kB.doc");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(1500);
        Driver.quitDriver();



    }
}

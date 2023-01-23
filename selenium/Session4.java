package com.evy.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * How to enter text to textbox
 * How to clear text to textbox
 * How to capture text from textbox(preloaded text)
 *differences between getAttribute & getText:
 * getAttribute: is one of the character of the element
 * getText-inner text of the element
 */
public class Session4 {
    public static void main(String[] args) {
        Driver.getDriver().get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");


        //Locate Elements
        WebElement email=Driver.getDriver().findElement(By.id("Email"));
        WebElement password=Driver.getDriver().findElement(By.id("Password"));

        //Capture preloaded text from text box
        String em=email.getAttribute("value");
        String pw=password.getAttribute("value");
        System.out.println(em+"\n"+pw);

        //How to clear text from text box
        email.clear();
        password.clear();

        //How to sendText to textbox
        email.sendKeys(em);
        password.sendKeys(pw);

        Driver.quitDriver();
    }
}

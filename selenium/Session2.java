package com.evy.selenium;


/**
 * How to navigate back & forward
 * how to refresh page
 * the difference between get() && navigate.to() :
 * get()-> accept only one String as parameter
 * navigate.to()->accept String & url instance as parameter (its also help us to store cookies to navigate back & forward)
 */
public class Session2 {
    public static void main(String[] args) {
        Driver.getDriver().get("https://www.google.co.il/");
        Driver.getDriver().navigate().to("https://www.amazon.com/");
        Driver.getDriver().navigate().back();
        System.out.println("Page Title:"+Driver.getDriver().getTitle());
        Driver.getDriver().navigate().forward();
        System.out.println("Page Title: "+Driver.getDriver().getTitle());
        Driver.getDriver().navigate().refresh();
        Driver.quitDriver();


    }
}

package com.evy.selenium;

/**
 * How to handle authenticate popups
 */
public class Session13 {
    public static void main(String[] args) {
        Driver.getDriver().get("http://admin:admin@the-internet.herokuapp.com/basic_auth");

    }
}

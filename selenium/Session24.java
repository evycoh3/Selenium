package com.evy.selenium;

import org.openqa.selenium.Cookie;

import java.util.Set;

/**
 * How to handle cookies in selenium
 */
public class Session24 {
    public static void main(String[] args) {
        Driver.getDriver().get("https://www.amazon.com/");

        //How to capture all cookies and print
        Set<Cookie> cookieSet=Driver.getDriver().manage().getCookies();
        System.out.println(cookieSet.size());
        for(Cookie cookie:cookieSet){
            System.out.println(cookie.getName()+","+cookie.getValue());
        }
        //Add cookie and print
        Cookie cookie1=new Cookie("evy","12345");
        Driver.getDriver().manage().addCookie(cookie1);
        cookieSet=Driver.getDriver().manage().getCookies();
        System.out.println(cookieSet.size());
        for(Cookie cookie:cookieSet){
            System.out.println(cookie.getName()+","+cookie.getValue());
        }
        //delete cookie and print
        Driver.getDriver().manage().deleteCookieNamed("evy");
        cookieSet=Driver.getDriver().manage().getCookies();
        System.out.println(cookieSet.size());
        for(Cookie cookie:cookieSet){
            System.out.println(cookie.getName()+","+cookie.getValue());
        }

        //Delete all cookies
        Driver.getDriver().manage().deleteAllCookies();

        Driver.quitDriver();
    }
}

package com.evy.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Session11 {
    public static void main(String[] args) throws IOException {
        Driver.getDriver().get("http://www.deadlinkcity.com/");
        List<WebElement> links=Driver.getDriver().findElements(By.tagName("a"));
        int brokenLinks=0;

        for(WebElement element:links){
            String url=element.getAttribute("href");
            if(url.isEmpty() || url==null){
                System.out.println("url is empty");
                continue;
            }
            URL link=new URL(url);
            HttpURLConnection httpURLConnection= (HttpURLConnection) link.openConnection();
            httpURLConnection.connect();
            if(httpURLConnection.getResponseCode()>400){
                System.out.println("Broken link: "+httpURLConnection.getResponseCode()+url);
                brokenLinks++;
            }
            else{
                System.out.println(httpURLConnection.getResponseCode()+ url +"is valid link");
            }

        }
        System.out.println(brokenLinks);
        Driver.quitDriver();
    }

}

package com.evy.selenium;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Session10 {
    public static void main(String[] args) throws InterruptedException {
        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");


        Driver.getDriver().findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click(); //will open a new window (child window)
        Set<String> windowHandles=Driver.getDriver().getWindowHandles();
        List<String>windowHandlesList=new ArrayList<>(windowHandles);
        System.out.println(windowHandlesList.get(0)+":Parent Id");
        System.out.println(windowHandlesList.get(1)+":child id");


        Driver.getDriver().switchTo().window(windowHandlesList.get(1));
        Thread.sleep(1500);
        Driver.getDriver().switchTo().window(windowHandlesList.get(0));

        for(String value:windowHandlesList){
            String title=Driver.getDriver().switchTo().window(value).getTitle();
            if(title.contains("Free")){
                Driver.getDriver().close();
            }
        }

        Thread.sleep(2500);
        Driver.quitDriver();
    }
}

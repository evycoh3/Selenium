package com.evy.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * How to handle dynamic webTable
 */
public class Session17 {
    public static void main(String[] args) throws InterruptedException {
        Driver.getDriver().get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
        Driver.getDriver().findElement(By.cssSelector("button[type='submit']")).click();
        Driver.getDriver().findElement(By.cssSelector("nav.mt-2>ul>li:nth-of-type(2)>a")).click();
        Driver.getDriver().findElement(By.xpath("//p[text()=' Products']")).click();
        for(int i=1;i<=4;i++){
            WebElement activePage=Driver.getDriver().findElement(By.xpath("//a[text()="+i+"]"));
            System.out.println("Active Page :"+activePage.getText());
            int rows=Driver.getDriver().findElements(By.xpath("//table[@id]//tbody//tr")).size();
            System.out.println(rows);
            for(int r=1;r<rows;r++){
                Thread.sleep(1500);
                String a=Driver.getDriver().findElement(By.xpath("//table[@id]//tbody//tr["+r+"]//td[3]")).getText();
                String b=Driver.getDriver().findElement(By.xpath("//table[@id]//tbody//tr["+r+"]//td[4]")).getText();
                String c=Driver.getDriver().findElement(By.xpath("//table[@id]//tbody//tr["+r+"]//td[5]")).getText();
                System.out.println(a+" "+b+" "+c);
            }
            String pageNum=Integer.toString(i+1);
            Driver.getDriver().findElement(By.xpath("//a[text()='"+pageNum+"']")).click();


        }


        Driver.quitDriver();


    }
}

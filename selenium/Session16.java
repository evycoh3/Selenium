package com.evy.selenium;

import org.openqa.selenium.By;

import java.io.FileWriter;
import java.io.IOException;

/**
 * How to handle static webTables
 */
public class Session16 {
    public static void main(String[] args) throws IOException {
        Driver.getDriver().get("http://omayo.blogspot.com/2013/05/page-one.html");
       int rows= Driver.getDriver().findElements(By.xpath("//table[@id='table1']//tbody//tr")).size();
       int cols=Driver.getDriver().findElements(By.xpath("//table[@id='table1']//tbody//tr[1]//td")).size();
       FileWriter fileWriter=new FileWriter("tableData.txt");


        for(int i=1;i<=rows;i++){
           for(int j=1;j<=cols;j++){
               String text=Driver.getDriver().findElement(By.xpath("//table[@id='table1']//tbody//tr["+i+"]//td["+j+"]")).getText();
               System.out.print(text+" ");
               fileWriter.write(text+" ");
           }
           System.out.println();
           fileWriter.write(System.lineSeparator());
       }
        fileWriter.close();
       Driver.quitDriver();

    }
}

package com.evy.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.HashMap;

/**
 * How to download word files in chrome,firefox
 */
public class Session25 {
    static String location=System.getProperty("user.dir")+"/download";
    public static void main(String[] args) {
        downloadWithChromeDriver(); //for edge driver same setting
        downloadWithFirefoxDriver();


    }

    public  static void downloadWithFirefoxDriver() {
        FirefoxProfile profile=new FirefoxProfile();
        profile.setPreference("browser.helper.neverAsk.saveToDisk","application/msword");
        profile.setPreference("browser.download.folderLost",2);//0 desktop ,1 ->downlaod ,2 desired location
        profile.setPreference("browser.download.dir",location);
        FirefoxOptions options=new FirefoxOptions();
        options.setProfile(profile);
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver(options);
        driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("table>tbody>tr:first-of-type>td>a")).click();
        try{
            Thread.sleep(2500);
        }catch (Exception e){
            e.getMessage();
        }
        driver.quit();

    }

    public static void downloadWithChromeDriver(){
        HashMap pref=new HashMap();
        pref.put("download.default_directory",location);
        ChromeOptions options=new ChromeOptions();
        options.setExperimentalOption("prefs",pref);
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver(options);
        driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("table>tbody>tr:first-of-type>td>a")).click();
        try{
            Thread.sleep(2500);
        }catch (Exception e){
            e.getMessage();
        }
        driver.quit();

    }
}

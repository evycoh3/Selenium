package com.evy.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;
import java.util.function.Function;

/**
 * Synchronization problems in selenium
 * pageLoadTime-wait amount of time till the page completely load
 * 3 type of wait:
 * implicitWait-creating once after driver instance created and wait constant static  time for all elements (ex:10)
 * ExplicitWait-WebDriverWait Object ->flexible on elements
 * FluentWait
 */
public class Session15 {
    static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://itera-qa.azurewebsites.net/home/automation");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        Objects.requireNonNull(performExplicitWait(WaitStrategy.VISIBLE, By.id("name"), 6)).sendKeys("Hello");
        Objects.requireNonNull(performExplicitWait(WaitStrategy.PRESENCE, By.id("phone"), 10)).sendKeys("123456789");
        Objects.requireNonNull(performFluentWait(By.id("email"),10)).sendKeys("Halo@gmail.com");


        driver.quit();


    }

    public static WebElement performExplicitWait(WaitStrategy waitStrategy, By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        switch (waitStrategy) {
            case CLICKABLE:
                return wait.until(ExpectedConditions.elementToBeClickable(by));
            case PRESENCE:
                return wait.until(ExpectedConditions.presenceOfElementLocated(by));
            case VISIBLE:
                return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            case NONE:
                return driver.findElement(by);
        }
        return null;
    }

    public static WebElement performFluentWait(By by, int time) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofMillis(700))
                .ignoring(StaleElementReferenceException.class);
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(by);
            }
        });

        return element;
    }

}
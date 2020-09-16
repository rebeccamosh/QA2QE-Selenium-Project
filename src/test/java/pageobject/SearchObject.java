package pageobject;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchObject {

   // private WebElement search;
    private WebDriver driver;

    By SearchLocator = By.id("search");

    public SearchObject(WebDriver driver) { this.driver = driver; }

    @Test
    public void SearchProducts(String Products) {
        driver.findElement(SearchLocator).clear();
        driver.findElement(SearchLocator).sendKeys(Products);
        driver.findElement(SearchLocator).sendKeys(Keys.ENTER);
    }


}
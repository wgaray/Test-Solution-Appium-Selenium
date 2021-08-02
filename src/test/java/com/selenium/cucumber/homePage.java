package com.selenium.cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homePage {

    WebDriver driver;

    @FindBy(xpath="//input")
    private WebElement inputSearch;

    @FindBy(xpath="//button")
    private WebElement searchButton;

    public homePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements( driver, this);
    }

    public void searchElement(String tvShow){
        WebDriverWait wait = new WebDriverWait(driver, 10000);
        wait.until(driver -> (inputSearch));
        inputSearch.sendKeys(tvShow);
        searchButton.click();
    }

    public String getTextSearched(){
        WebDriverWait wait = new WebDriverWait(driver, 10000);
        wait.until(driver -> (inputSearch));
        return inputSearch.getText();
    }
}

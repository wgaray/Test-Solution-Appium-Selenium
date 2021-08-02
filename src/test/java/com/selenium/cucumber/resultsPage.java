package com.selenium.cucumber;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class resultsPage {

    WebDriver driver;

    @FindBy(xpath="//a[@class='btn btn-primary']")
    private WebElement backButton;

    @FindBy(xpath="//a[text()='URL']")
    private List<WebElement> URLs;

    public resultsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements( driver, this);
    }

    public void clickBackButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10000);
        wait.until(driver -> (backButton));
        backButton.click();
    }

    public void accessURL(int number){
        WebDriverWait wait = new WebDriverWait(driver, 10000);
        wait.until(driver -> (backButton));
        URLs.get(number).click();
    }

    public void changeBackgroundColor(String color){
        WebDriverWait wait = new WebDriverWait(driver, 10000);
        wait.until(driver -> (backButton));
        ((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('card-content white-text')[1].style.backgroundColor = '"+color+"';");
    }
}

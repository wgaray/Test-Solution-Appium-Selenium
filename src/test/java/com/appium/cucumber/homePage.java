package com.appium.cucumber;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homePage {

    AppiumDriver driver;

    @FindBy(id="io.grainchain.logintest:id/textview_first")
    private WebElement welcomeMssg;

    public homePage(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements( driver, this);
    }

    public String getWelcomeMssg(){
        WebDriverWait wait = new WebDriverWait(driver, 10000);
        wait.until(driver -> (welcomeMssg));
        return welcomeMssg.getText();
    }
}

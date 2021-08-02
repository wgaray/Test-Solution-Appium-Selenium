package com.appium.cucumber;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class loginPage {

    AppiumDriver driver;

    @FindBy(id="io.grainchain.logintest:id/username")
    private WebElement userBox;

    @FindBy(id="io.grainchain.logintest:id/password")
    private WebElement passBox;

    @FindBy(id="io.grainchain.logintest:id/login")
    private WebElement signInButton;

    public loginPage(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements( driver, this);
    }

    public void setUserName(String strUserName){
        userBox.sendKeys(strUserName);
    }

    public void setPassword(String strPassword){
        passBox.sendKeys(strPassword);
    }

    public void clickSignIn(){
        signInButton.click();
    }

    public boolean checkButtonIsEnabled(){
        return signInButton.isEnabled();
    }
}

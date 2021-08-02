package com.appium.cucumber;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.remote.MobileCapabilityType;
import static org.junit.Assert.*;
import java.net.MalformedURLException;
import java.net.URL;

public class loginSteps {

    private AppiumDriver driver;
    private loginPage login;
    private homePage home;

    private final static String APP_PLATFORM = "Android";
    private final static String APP_AUTOMATION_NAME = "Appium";
    private final static String APP_PLATFORM_VERSION = "9.0";
    private final static String APP_DEVICE_NAME = "Android Emulator";
    private final static String APP_LOCATION = "C:/Users/wgaray/StudioProjects/appium-test/app/build/outputs/apk/debug/app-debug.apk";

    private final static String SERVER_URL = "http://localhost:4723/wd/hub";

    @Given("open the app")
    public void openApp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, APP_PLATFORM);
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, APP_AUTOMATION_NAME);
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, APP_PLATFORM_VERSION);
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, APP_DEVICE_NAME);
        caps.setCapability(MobileCapabilityType.APP, APP_LOCATION);
        driver = new AppiumDriver(new URL(SERVER_URL), caps);

        login = new loginPage(driver);
        home = new homePage(driver);
    }

    @When("enter the user {string}")
    public void enterUsername(String username){
        login.setUserName(username);
    }

    @When("enter the password {string}")
    public void enterPassword(String password){
        login.setPassword(password);
    }

    @When("click the sign in button")
    public void clickSignIn(){
        login.clickSignIn();
    }

    @Then("the name {string} is in the screen")
    public void checkUserInScreen(String username){
        assertEquals(home.getWelcomeMssg(), "Hello " + username);
    }

    @Then("the sign in button is disabled")
    public void signInButtonDisabled(){
        assertFalse(login.checkButtonIsEnabled());
    }
}

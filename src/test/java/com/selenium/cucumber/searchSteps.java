package com.selenium.cucumber;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

import com.selenium.cucumber.homePage;

import java.util.concurrent.TimeUnit;

public class searchSteps {

    private final static String PAGE_URL = "http://localhost:3000/shows";

    private WebDriver driver;
    private homePage home;
    private resultsPage searchResults;

    @Given("open browser")
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver","C:\\Proyectos\\chromedriver92.exe" );
        driver = new ChromeDriver();
        driver.get(PAGE_URL);

        home = new homePage(driver);
        searchResults = new resultsPage(driver);
    }

    @When("search the tv show {string}")
    public void searchTVShow(String tvShow) {
        home.searchElement(tvShow);
    }

    @When("click the second URL")
    public void clickSecondURL() {
        searchResults.accessURL(1);
    }

    @When("go back with browser features")
    public void goBackWithBrowser() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        assertNotNull(driver.findElement(By.xpath("//h1[text()='Batman Beyond']")));
        driver.navigate().back();
    }

    @When("change background color")
    public void changeBackgroundColor() throws InterruptedException {
        searchResults.changeBackgroundColor("#4a148c");
        Thread.sleep(5000);
    }

    @When("click the back button")
    public void clickBackButton() {
        searchResults.clickBackButton();
    }

    @Then("the url is the same")
    public void checkURL() {
        assertEquals(driver.getCurrentUrl(),PAGE_URL);
    }

    @Then("the input search is empty")
    public void checkInputSearch() {
        assertEquals(home.getTextSearched(),"");
    }
}

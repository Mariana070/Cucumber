package com.test.google.stepdefinitions;

import com.test.google.pages.GoogleMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class SearchStepParameterDef {
    WebDriver driver = DriverHelper.getDriver();
    GoogleMainPage googleMainPage = new GoogleMainPage(driver);
    @Given("User navigates to the {string}")
    public void user_navigates_to_the(String website) {
        driver.get(website);

    }
    @When("User searches for {string}")
    public void user_searches_for(String searchItem) {
        googleMainPage.searchItem(searchItem);

    }
    @Then("User validates first page returns more than {int} links")
    public void user_validates_first_page_returns_more_than_links(Integer expectedLink) throws InterruptedException {
        Assert.assertTrue(googleMainPage.linkCount(expectedLink));
    }

    @Then("User validate the result is less than {int}")
    public void user_validate_the_result_is_less_than(Integer expectedResults) throws InterruptedException {
       Assert.assertTrue(googleMainPage.resultFromSearch(expectedResults));
    }
    @Then("User validate it loads less than {double} sec")
    public void user_validate_it_loads_less_than_sec(Double expectedTime) {
        Assert.assertTrue(googleMainPage.resultSearchTurkishBaklava(expectedTime));

    }
}

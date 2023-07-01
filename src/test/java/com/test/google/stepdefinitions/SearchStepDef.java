package com.test.google.stepdefinitions;

import com.test.google.pages.GoogleMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class SearchStepDef {

WebDriver driver= DriverHelper.getDriver();
GoogleMainPage googleMainPage = new GoogleMainPage(driver);
    @Given("User navigates to the google")
    public void user_navigates_to_the_google() {
        // Write code here that turns the phrase above into concrete actions
     driver.get("https://www.google.com/");
    }
    @When("User searches for CodeFish")
    public void user_searches_for_code_fish() {
        googleMainPage.searchItem("CodeFish");

    }
    @Then("User validates first page returns more than ten links")
    public void user_validates_first_page_returns_more_than_ten_links() throws InterruptedException {
        googleMainPage.linkCount(10);

    }
    @When("User searches for Kyrgez Food in USA")
    public void user_searches_for_kyrgez_food_in_usa() {
        googleMainPage.searchItem("Kyrgez Food in USA");

    }
    @Then("User validate the result is less than three hundred million")
    public void user_validate_the_result_is_less_than_three_hundred_million() throws InterruptedException {
               Assert.assertTrue(googleMainPage.resultFromSearch(300000000));

    }
    @When("User searches for Turkish baklava")
    public void user_searches_for_turkish_baklava() {
       googleMainPage.searchItem("turkish_baklava");
    }
    @Then("User validate it loads less than one sec")
    public void user_validate_it_loads_less_than_one_sec() {
        Assert.assertTrue(googleMainPage.resultSearchTurkishBaklava(1.0));
    }


}

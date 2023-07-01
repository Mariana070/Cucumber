package com.test.etsy.stepdefinitions;

import com.test.etsy.pages.EtsyMainPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class EtsySearchStepDef {
    WebDriver driver= DriverHelper.getDriver();
    EtsyMainPage etsyMainPage=new EtsyMainPage(driver);
    @When("User search for {string} for Etsy")
    public void user_search_for_for_etsy(String itemName) {
etsyMainPage.searchItem(itemName);
    }

    @Then("User validate the title {string} from Etsy")
    public void user_validate_the_title_from_etsy(String string) {

    }

}

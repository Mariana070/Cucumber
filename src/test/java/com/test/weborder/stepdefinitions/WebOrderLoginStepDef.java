package com.test.weborder.stepdefinitions;

import com.test.weborder.pages.WebOrderLoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class WebOrderLoginStepDef {
    WebDriver driver= DriverHelper.getDriver();
    WebOrderLoginPage webOrderLoginPage= new WebOrderLoginPage(driver);
    @When("User provides {string},{string},click sign in")
    public void user_provides_click_sign_in(String username, String password) {
        webOrderLoginPage.login(username,password);

    }
    @Then("User validate the {string}")
    public void user_validate_the(String expectedTitle) {
       Assert.assertEquals(expectedTitle,driver.getTitle().trim());

    }
    @Then("User validate the message {string}")
    public void user_validate_the_message(String expectedMessage) {
        Assert.assertEquals(expectedMessage,webOrderLoginPage.errorMessage());
    }
}

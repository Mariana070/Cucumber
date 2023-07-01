package com.test.weborder.stepdefinitions;

import com.test.weborder.pages.WebOrderLoginPage;
import com.test.weborder.pages.WebOrderPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

import javax.sql.rowset.BaseRowSet;

public class WeborderOrderStepDef {
    WebDriver driver = DriverHelper.getDriver();
    WebOrderLoginPage webOrderLoginPage = new WebOrderLoginPage(driver);
    WebOrderPage webOrderPage = new WebOrderPage(driver);


    @When("User provides userName and password and click Sign in")
    public void user_provides_user_name_and_password_and_click_sign_in() {
        webOrderLoginPage.login(ConfigReader.readProperty("Qa_weborder_username"),ConfigReader.readProperty("Qa_weborder_password"));
    }
    @When("User click GroupOrder button and click Next button")
    public void user_click_group_order_button_and_click_next_button() throws InterruptedException {
        webOrderPage.clickGroupOrderBox();
    }
    @When("User provides  InviteNote {string}, InviteesList {string}")
    public void user_provides_invite_note_invitees_list(String messageNote, String messageList) {
webOrderPage.fillInInviteBoxes(messageNote,messageList);
    }
    @When("User select delivery {string} and validate address contains {string}")
    public void user_select_delivery_my_house_and_validate_address_contains(String location,String containsAddress) {
        webOrderPage.chooseLocation(location,containsAddress);
    }
    @Then("User click GroupOrder button and validate header {string} and description contains {string}")
    public void user_click_group_order_button_and_validate_header_and_description_contains(String expectedHeader, String expectedDescription) throws InterruptedException {
        webOrderPage.clickCreateGroupOrderButton();
       webOrderPage.validateHeader(expectedHeader);
      webOrderPage.validateDescriptions(expectedDescription);
    }

}


package com.test.saucedemo.stepdefinitions;

import com.test.saucedemo.pages.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

import java.util.Map;

public class SaucedemoStepdefinition {
    WebDriver driver= DriverHelper.getDriver();
    SaucedemoLoginPage saucedemoLoginPage=new SaucedemoLoginPage(driver);
    SaucedemoCartPage saucedemoCartPage = new SaucedemoCartPage(driver);
    SaucedemoCheckOutPage saucedemoCheckOutPage = new SaucedemoCheckOutPage(driver);
    SaucedemoCheckOutStepTwo saucedemoCheckOutStepTwo = new SaucedemoCheckOutStepTwo(driver);
    SaucedemoMainPage saucedemoMainPage = new SaucedemoMainPage(driver);
    SaucedemoCompletePage saucedemoCompletePage = new SaucedemoCompletePage(driver);



    @Given("User provides userName and password and click Login")
    public void user_provides_user_name_and_password_and_click_login() throws InterruptedException {
        saucedemoLoginPage.login();
    }
    @When ("User chooses {string} and click Add to Cart button")
    public void user_chooses_and_click_add_to_cart_button(String productName) {
        saucedemoMainPage.clickAddButton(productName);

    }
    @And ("Click Cart sign on the top right")
    public void click_cart_sign_on_the_top_right() {
        saucedemoMainPage.clickCartSing();
    }
    @And ("Click checkout button")
    public void click_checkout_button() {
        saucedemoCartPage.clickCheckOutButton();
    }
    @And ("fill in all the box {string},{string},{string}  and click continue button")
    public void fill_in_all_the_box_and_click_continue_button(String firstName, String lastName, String zipcode) {
saucedemoCheckOutPage.fillInCheckOutInfo(firstName,lastName,zipcode);
    }

    @Then("Validate the {string}, item total, and tax amount should be % eight of the product and validate total amount is matching with tax+item total")
    public void validate_the_item_total_and_tax_amount_should_be_eight_of_the_product_and_validate_total_amount_is_matching_with_tax_item_total(String validateProductName) {
        saucedemoCheckOutStepTwo.validateNameOfProduct(validateProductName);
        saucedemoCheckOutStepTwo.validateTax();
        saucedemoCheckOutStepTwo.validateTotalAmount();
    }


    @And ("Click Finish Button and validate {string}")
    public void click_finish_button_and_validate(String message) {
        saucedemoCheckOutStepTwo.clickFinishButton();
        saucedemoCompletePage.validateMessage(message);
    }

    @When("User chooses productName and click Add to Cart button")
    public void user_chooses_product_name_and_click_add_to_cart_button(DataTable dataTable) {
        Map<String,String> productNameInfo=dataTable.asMap();
        saucedemoMainPage.clickAddButton(productNameInfo.get("productName"));

    }
    @When("fill in all the box firstname,lastname,zipCode  and click continue button")
    public void fill_in_all_the_box_firstname_lastname_zip_code_and_click_continue_button(DataTable dataTable) {
        Map<String,String> personalInfo=dataTable.asMap();
        saucedemoCheckOutPage.fillInCheckOutInfo(personalInfo.get("firstname"),personalInfo.get("lastname"),personalInfo.get("zipCode"));

    }
    @Then("Validate the productName, item total, and tax amount should be % eight of the product and validate total amount is matching with tax+item total")
    public void validate_the_product_name_item_total_and_tax_amount_should_be_eight_of_the_product_and_validate_total_amount_is_matching_with_tax_item_total(DataTable dataTable) {
Map<String, String> validateProduct=dataTable.asMap();
        saucedemoCheckOutStepTwo.validateNameOfProduct(validateProduct.get("ProductName"));
        saucedemoCheckOutStepTwo.validateTax();
        saucedemoCheckOutStepTwo.validateTotalAmount();

    }
    @Then("Click Finish Button and validate message")
    public void click_finish_button_and_validate_message(DataTable dataTable) {
        Map<String,String>validateMessage=dataTable.asMap();
        saucedemoCheckOutStepTwo.clickFinishButton();
        saucedemoCompletePage.validateMessage(validateMessage.get("message"));
    }



}

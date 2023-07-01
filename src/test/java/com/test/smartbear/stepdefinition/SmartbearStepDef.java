package com.test.smartbear.stepdefinition;

import com.test.smartbear.pages.SmartbearLoginPage;
import com.test.smartbear.pages.SmartbearMainPage;
import com.test.smartbear.pages.SmartbearOrderPage;
import com.test.smartbear.pages.SmartbearviewOrderPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

import java.util.List;
import java.util.Map;

public class SmartbearStepDef {
    WebDriver driver= DriverHelper.getDriver();
    SmartbearLoginPage smartbearLoginPage = new SmartbearLoginPage( driver);
    SmartbearMainPage smartbearMainPage = new SmartbearMainPage(driver);
    SmartbearOrderPage smartbearOrderPage = new SmartbearOrderPage(driver);
    SmartbearviewOrderPage smartbearviewOrderPage = new SmartbearviewOrderPage(driver);
    @Given("User provides {string} and {string} and click Login button")
    public void user_provides_and_and_click_login_button(String userName, String password) {
smartbearLoginPage.login(ConfigReader.readProperty("QA_smartbear_userName"),ConfigReader.readProperty("QA_smartbear_password"));
    }
    @When("User click Order button and select {string} and f provide {string} for product information")
    public void user_click_order_button_and_select_and_f_provide_for_product_information(String selectProduct, String selectQuantity) {
       smartbearMainPage.clickOrderButton();
       smartbearOrderPage.productInformation(selectProduct,selectQuantity);
    }
    @And("User provide {string},{string},{string},{string},{string} for address information")
    public void user_provide_for_address_information(String name, String street, String city, String state, String zipcode) {
        smartbearOrderPage.addressInformation(name,street,city,state,zipcode);
    }
    @And ("User provide {string},{string},{string}")
    public void user_provide(String card, String cardNr, String expireDate) {
        smartbearOrderPage.paymentInformation(driver,  card,cardNr,expireDate);
    }
    @Then("User click Process button and validate {string} and click View order button")
    public void user_click_process_button_and_validate_and_click_view_order_button(String expectedMessage) {
        smartbearOrderPage.clickProcessButton();
        smartbearOrderPage.validateAddedMessage(expectedMessage);

    }
//    @And ("User validate allInformation {string}, {string},{string},{string},{string},{string},{string},{string},{string} from tabele")
//    public void user_validate_all_information_from_tabele(String customerName, String productName, String quantity, String date, String street, String city, String state, String zipCode, String card,String cardNR,String expireDate) {
//       smartbearviewOrderPage.validationInfo(customerName,productName,quantity,date,street,city,state,zipCode,card,cardNR,expireDate);
//    }

    @And ("User validate allInformation {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string} from table")
    public void user_validate_all_information_from_tabele(String customerName, String productName, String quantity, String date, String street, String city, String state,String zipCode, String card,String cardNR,String expireDate) {
        smartbearviewOrderPage.validationInfo(customerName,productName,quantity,street,city,state,zipCode,card,cardNR,expireDate);


    }


    @When("User clicks OrderButton and provides the product and quantity for product information")
    public void user_clicks_order_button_and_provides_the_product_and_quantity_for_product_information(DataTable dataTable) {
       Map<String,String> productInformation=dataTable.asMap();
       smartbearMainPage.clickOrderButton();
       smartbearOrderPage.productInformation(productInformation.get("product"),productInformation.get("quantity"));

    }
    @When("User provides customerName, street,city,state,zipCode,for address information")
    public void user_provides_customer_name_street_city_state_zip_code_for_address_information(DataTable dataTable) {
        Map<String,String> addressInformation=dataTable.asMap();
        smartbearOrderPage.addressInformation(addressInformation.get("customerName"),addressInformation.get("street"),addressInformation.get("city"),
                addressInformation.get("state"),addressInformation.get("zipCode"));

    }
    @When("User provides card,cardNR,expireDate")
    public void user_provides_card_card_nr_expire_date(DataTable dataTable) {
        Map<String,String> paymentInformation=dataTable.asMap();
        smartbearOrderPage.paymentInformation(driver ,paymentInformation.get("card"),paymentInformation.get("cardNR"),paymentInformation.get("expireDate"));
    }
    @Then("Click Finish Button and validate {string}")
    public void click_finish_button_and_validate(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}

package com.test.smartbear.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class SmartbearOrderPage {
    public SmartbearOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//select")
    WebElement selectProductConsole;
    @FindBy(xpath = "//input[contains(@id,'txtQuantity')]")
    WebElement quantity;
    @FindBy(xpath = "//input[contains(@id,'txtName')]")
    WebElement selectName;
    @FindBy(xpath = "//input[contains(@id,'TextBox2')]")
    WebElement selectStreet;
    @FindBy(xpath = "//input[contains(@id,'TextBox3')]")
    WebElement selectCity;
    @FindBy(xpath = "//input[contains(@id,'TextBox4')]")
    WebElement selectState;
    @FindBy(xpath = "//input[contains(@id,'TextBox5')]")
    WebElement selectZipCode;
    @FindBy(xpath = "//input[@type='radio']")
    List<WebElement> selectCard;
    @FindBy(xpath = "//input[contains(@id,'TextBox6')]")
    WebElement selectCardNr;
    @FindBy(xpath = "//input[contains(@id,'TextBox1')]")
    WebElement selectExpireDate;
    @FindBy(xpath = "//a[.='Process']")
    WebElement  processButton;
    @FindBy(xpath = "//strong")
    WebElement message;
    @FindBy(xpath = "//a[.='View all orders']")
    WebElement viewAllOrderButton;

    public void productInformation(String selectProduct,String selectQuantity){
        BrowserUtils.selectBy(selectProductConsole,selectProduct,"text");
        quantity.sendKeys(selectQuantity);
    }
    public void addressInformation(String name,String street,String city,String state, String zipcode){
        selectName.sendKeys(name);
        selectStreet.sendKeys(street);
        selectCity.sendKeys(city);
        selectState.sendKeys(state);
        selectZipCode.sendKeys(zipcode);
    }
    public void paymentInformation( WebDriver driver, String card, String cardNr,String expireDate){
      for(WebElement element:selectCard){
          if(element.getAttribute("value").equals(card)){
             BrowserUtils.clickWithJS(driver,element);
          }
      }
        selectCardNr.sendKeys(cardNr);
        selectExpireDate.sendKeys(expireDate);
    }
    public void clickProcessButton(){
        processButton.click();

    }
    public void validateAddedMessage(String expectedMessage){
        Assert.assertEquals(expectedMessage,BrowserUtils.getText(message));
        viewAllOrderButton.click();

    }
    public String getMessage(){
        return BrowserUtils.getText(message);
    }

}

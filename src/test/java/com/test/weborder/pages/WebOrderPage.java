package com.test.weborder.pages;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.BrowserUtils;

public class WebOrderPage {
    public WebOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "//label[@class='custom-control-label']")
    WebElement groupOrderBox;
    @FindBy(xpath = "//button[.='Next']")
    WebElement nextButton;
    @FindBy(css = "#ConfirmAddressID")
    WebElement deliveryConsole;
    @FindBy(css = "#InviteNote")
    WebElement inviteNote;
    @FindBy(css = "#InviteList")
    WebElement inviteeList;
    @FindBy(css = "#createGroupOrder")
    WebElement createGroupOrderButton;
    @FindBy(xpath = "//h1")
    WebElement header;
    @FindBy(xpath = "//p[contains(text(),'Your participants')]")
    WebElement description;
    @FindBy(css = "#addressPreview")
    WebElement deliveryAddress;

    @FindBy(css = "#ConfirmAddressID")
    WebElement location;

public void clickGroupOrderBox() throws InterruptedException {
    Thread.sleep(3000);
 groupOrderBox.click();
    nextButton.click();
}
public void fillInInviteBoxes(String messageNote,String messageList){
    inviteNote.sendKeys(messageNote);
    inviteeList.sendKeys(messageList);
    }
//    public void getAddress(String containsAddress){
//    Select select = new Select(deliveryConsole);
//    select.getFirstSelectedOption();
//    Assert.assertTrue(BrowserUtils.getText(deliveryAddress).contains(containsAddress));
//
//    }

    public void chooseLocation(String location,String containsAddress){
    BrowserUtils.selectBy(this.location,location,"text");
        Assert.assertTrue(BrowserUtils.getText(deliveryAddress).contains(containsAddress));

    }
    public void clickCreateGroupOrderButton() throws InterruptedException {
    createGroupOrderButton.click();
    Thread.sleep(3000);
    }


public void validateHeader(String expectedHeader){

    Assert.assertEquals(expectedHeader, BrowserUtils.getText(header));
}
public void validateDescriptions(String expectedDescription){
    Assert.assertTrue(BrowserUtils.getText(description).contains(expectedDescription));
}


}

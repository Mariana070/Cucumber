package com.test.saucedemo.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class SaucedemoCompletePage {
  public SaucedemoCompletePage(WebDriver driver){
      PageFactory.initElements(driver,this);
  }
  @FindBy(xpath = "//h2")
    WebElement actualMessage;
  public void validateMessage(String expectedMessage){
      Assert.assertEquals(expectedMessage, BrowserUtils.getText(actualMessage));
  }
}

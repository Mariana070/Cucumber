package com.test.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaucedemoCartPage {
    public SaucedemoCartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy (css = "#checkout")
    WebElement checkOutButton;
    public void clickCheckOutButton(){
        checkOutButton.click();
    }
}

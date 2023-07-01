package com.test.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class SaucedemoMainPage {
    public SaucedemoMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[contains(@class,'item_name')]")
    List<WebElement> allItemsName;
    @FindBy(xpath = "//button[.='Add to cart']")
    List<WebElement> allAddButtons;
    @FindBy(xpath = "//span[contains(@class,'badge')]")
    WebElement cartSing;
    public void clickAddButton( String itemName){
        for (int i = 0; i < allItemsName.size(); i++) {
            if (BrowserUtils.getText(allItemsName.get(i)).equals(itemName)) {
                allAddButtons.get(i).click();
                break;
            }
        }
    }

public void clickCartSing(){
        cartSing.click();
}

}

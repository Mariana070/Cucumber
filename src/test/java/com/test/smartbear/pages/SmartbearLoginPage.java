package com.test.smartbear.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.webaudio.model.AudioListenerWillBeDestroyed;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class SmartbearLoginPage {
    public SmartbearLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    /*
1-First Create your hook class and your @Before and @After annotation(io.cucumber)
2-Read username,password,url from configuration.properties
3-Start writing your test case in feature file
4-Start creating your Page object model(pages,step definitions,runners)
  tips:You should have :LoginPage,MainPage,OrderPage,ViewOrderPage(validation part)
  tips:You should have :OrderCreationStepDef
5-Create your runner class and get the all snips from Runner class(DryRun=True)
6-Put the snips in step def class
7-Start implementing your page classes(WebElements and Methods)
8-Convert the logic of Scenario to Scenario Outline
  -->Check it for MyMoney,FamilyAlbum,ScreenSaver
  -->Check it for Visa,MasterCard,AmericanExpress
TIPS:Validation part:You can do Arrays.asList logic we did before
but start from 1 and end lenght-1.
 */

    @FindBy(css = "#ctl00_MainContent_username")
    WebElement userNameConsole;
    @FindBy(css = "#ctl00_MainContent_password")
    WebElement passwordConsole;
    @FindBy(css = "#ctl00_MainContent_login_button")
    WebElement loginButton;
    public void login(String userName,String password){
        userNameConsole.sendKeys(userName);
        passwordConsole.sendKeys(password);
        loginButton.click();
    }

}


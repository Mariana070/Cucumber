package com.test.smartbear.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class SmartbearviewOrderPage {
    public SmartbearviewOrderPage (WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//tr[2]//td")
    List<WebElement> currentInfo;

//'Liza','MyMoney','4','06/25/2023','Ballantrae Pl','Mundelein','IL','60069','visa','2345876523498','09/24'
    public void validationInfo(String customerName,String productName, String quantity,String street,String city,String state, String zipCode,String card,String cardNr,String expireDate){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now().plusDays(1);
        String currentDate=dtf.format(now);
        List<String> expectedInfo= Arrays.asList(customerName,productName, quantity, currentDate,street,city,state,zipCode,card,cardNr,expireDate);
        for (int i = 1,k=0; i <currentInfo.size()-1 ; i++,k++) {
            Assert.assertEquals(expectedInfo.get(k), BrowserUtils.getText(currentInfo.get(i)));
        }
    }



}

package com.test.saucedemo.pages;

import io.cucumber.java.eo.Do;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.text.DecimalFormat;

public class SaucedemoCheckOutStepTwo {
    public SaucedemoCheckOutStepTwo(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class='inventory_item_name']")
    WebElement itemName;
    @FindBy(xpath = "//div[contains(text(),'Item total')]")
    WebElement itemTotal;
    @FindBy(css = ".summary_total_label")
    WebElement total;
    @FindBy(css = "#finish")
    WebElement finishButton;
    @FindBy (css = ".summary_tax_label")
    WebElement tax;
    public void validateNameOfProduct(String itemValidateName){
        Assert.assertEquals(itemValidateName, BrowserUtils.getText(itemName));
    }
//    double itemTotalDouble= Double.parseDouble((BrowserUtils.getText(itemTotal).replace("Item total: $","")));
//    double taxDouble=Double.parseDouble(BrowserUtils.getText(tax).replace("Tax: $",""));
//    double totalAmountDouble=Double.parseDouble(BrowserUtils.getText(total).replace("Total: $",""));
//    double sum = itemTotalDouble+taxDouble;
//    double getTaxDouble=itemTotalDouble*0.08;
    public void validateTax(){

  String[]itemPrice = BrowserUtils.getText(itemTotal).split(" ");
  double itemTotalPrice=Double.parseDouble(itemPrice[2].replace("$",""));
  String[] taxPrice=BrowserUtils.getText(tax).split(" ");
  double taxAmount = Double.parseDouble(taxPrice[1].replace("$",""));// TAX
        DecimalFormat df = new DecimalFormat("#.00");
        String formattedTaxAmount = df.format(taxAmount);//2.40 tax
      //double taxAmountFinal=Double.parseDouble(formattedTaxAmount);
        double taxAmountPercentage = itemTotalPrice*0.08;
        String formattedTaxAmountPercentage = df.format(taxAmountPercentage);//2.40 / 29.99*0.08/ tax
        //double taxAmountPercentageFinal= Double.parseDouble(formattedTaxAmountPercentage);
      Assert.assertEquals(formattedTaxAmountPercentage,formattedTaxAmount);


    }
    public void validateTotalAmount(){
        String[]itemPrice = BrowserUtils.getText(itemTotal).split(" ");
        double itemTotalPrice=Double.parseDouble(itemPrice[2].replace("$",""));//item total price
        double taxAmountPercentage = itemTotalPrice*0.08;
        double sumPriceTax = itemTotalPrice+taxAmountPercentage;//item total +tax
        DecimalFormat df = new DecimalFormat("#.00");
        String formattedSumPriceTax = df.format(sumPriceTax);//item total +tax formatted
        String[] totalString = BrowserUtils.getText(total).split(" ");
        String totalFinal=totalString[1].replace("$","");// String total final
        Assert.assertEquals(totalFinal,formattedSumPriceTax);


    }
    public void clickFinishButton(){
        finishButton.click();
    }

    }


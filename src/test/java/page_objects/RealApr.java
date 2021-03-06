package page_objects;

import command_providers.ActOn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RealApr extends NavigationBar{
    private final By RatesLink = By.linkText("Rates");
    private final By RealAprLink = By.linkText("Real APR");
    private final By CalculatorTab = By.xpath("//*[@id='CalcForm']/div[2]/label[1]");
    private final By HomePrice= By.name("HomeValue");
    private final By DownPayment = By.name("DownPayment");
    private final By DownPaymentInDollar = By.id("DownPaymentSel0");
    private final By InterestRate = By.name("Interest");
    private final By CalculateButton = By.name("calculate");
    private final By ActualAprValue = By.xpath("//*[@id='analysisDiv']/table/tbody/tr/td/strong[contains(text(),'Actual APR')]/../../td[2]/strong");

    //create realApr constructor
    public RealApr (WebDriver driver){
    super(driver);
   }

   public RealApr waitForPageLoad(){
        ActOn.wait(driver,CalculatorTab).waitForElementToBeVisible();
        return this; //If it is in the same page then we use "return this"
   }
   //Enter home price
   public RealApr typeHomePrice(String value){
       ActOn.element(driver,HomePrice).setValue(value);
       return this;
   }
   //Click on $ radio button
    public RealApr clickDownPaymentInDollar(){
        ActOn.element(driver,DownPaymentInDollar).click();
        return this;
    }
    //Enter down payment
    public RealApr typeDownPayment(String value){
        ActOn.element(driver,DownPayment).setValue(value);
        return this;
    }
    public RealApr typeInterestRate(String value){
        ActOn.element(driver,InterestRate).setValue(value);
        return this;
    }
    public RealApr clickOnCalculateButton(){
        ActOn.element(driver,CalculateButton).click();
        return this;
    }
    //Validate the APR
    public RealApr validateRealAprRate(String expectedValue){
        String aprRate = ActOn.element(driver, ActualAprValue).getTextValue();
        Assert.assertEquals(aprRate,expectedValue);
        return this;

    }

   }

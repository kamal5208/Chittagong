package testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculateRealAprRate {
    private final By RatesLink=By.linkText("Rates");
    private final By RealAprLink= By.linkText("Real APR");
    private final By CalculateTab = By.xpath("//*[@id='CalcForm']//label[text()='Calculator']");
    private final By HomePrice = By.name("HomeValue");
    private final By DownPayment = By.name("DownPayment");
    private final By DownPaymentInDollar = By.id("DownPaymentSel0");
    private final By InterestRate = By.name("Interest");
    private final By CalculateButton = By.name("calculate");
    private final By ActualApr=By.xpath("//*[@id='analysisDiv']/table/tbody/tr/td/strong[contains(text(),'Actual APR')]/../../td[2]/strong");


    WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.mortgagecalculator.org/");
        driver.manage().window().maximize();
    }

    public void navigateToRealAprPage(){
        //Mouse hover to rates link
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(RatesLink)).perform();

        driver.findElement(RealAprLink).click();

    }
    public void enterData(){
        driver.findElement(HomePrice).clear();
        driver.findElement(HomePrice).sendKeys("200000");

        driver.findElement(DownPayment).clear();
        driver.findElement(DownPayment).sendKeys("15000");

        driver.findElement(DownPaymentInDollar).click();

        driver.findElement(InterestRate).clear();
        driver.findElement(InterestRate).sendKeys("3");


    }
    @Test
    public void calculate(){

        navigateToRealAprPage();
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(CalculateTab));

        enterData();
        driver.findElement(CalculateButton).click();

       String actapr = driver.findElement(ActualApr).getText();
       Assert.assertEquals(actapr,"3.130%");






    }
    public void closeBrowser(){
        driver.quit();
    }
}

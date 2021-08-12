package testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MonthlyMortgageRateCalculation {
    private final By HomeValue=By.id("homeval");
    private final By DownPayment = By.id("downpayment");
    private final By RadioButtonDollar=By.xpath("//*[@id='calc']//input[@name='param[downpayment_type]'][@value='money']");
    private final By LoanAmount= By.id("loanamt");
    private final By InterestRate =By.id("intrstsrate");
    private final By LoanTerm = By.id("loanterm");
    private final By SelectMonth = By.name("param[start_month]");
    private final By SelectYear =By.id("start_year");
    private final By PropertyTax=By.id("pptytax");
    private final By Pmi = By.id("pmi");
    private final By HomeIns = By.id("hoi");
    private final By Hoa = By.id("hoa");
    private final By LoanType=By.name("param[milserve]");
    private final By BuyOrRefi = By.name("param[refiorbuy]");
    private final By CalculateButton = By.name("cal");
    private final By MonthlyPayemnt=By.xpath("//*[@id='calc']//h3[text()='$1,611.85']");


    WebDriver driver;


        @BeforeMethod
        public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.mortgagecalculator.org/");
        driver.manage().window().maximize();
    }

    public void enterData(){
            driver.findElement(HomeValue).clear();
            driver.findElement(HomeValue).sendKeys("300000");

            driver.findElement(DownPayment).clear();
            driver.findElement(DownPayment).sendKeys("60000");

            driver.findElement(RadioButtonDollar).click();

            driver.findElement(LoanAmount).clear();
            driver.findElement(LoanAmount).sendKeys("240000");

            driver.findElement(InterestRate).clear();
            driver.findElement(InterestRate).sendKeys("3");

            driver.findElement(LoanTerm).clear();
            driver.findElement(LoanTerm).sendKeys("30");

            Select select = new Select(driver.findElement(SelectMonth));
            select.selectByVisibleText("Nov");

            driver.findElement(SelectYear).clear();
            driver.findElement(SelectYear).sendKeys("2021");

            driver.findElement(PropertyTax).clear();
            driver.findElement(PropertyTax).sendKeys("5000");

            driver.findElement(Pmi).clear();
            driver.findElement(Pmi).sendKeys("0.5");

            driver.findElement(HomeIns).clear();
            driver.findElement(HomeIns).sendKeys("1000");

            driver.findElement(Hoa).clear();
            driver.findElement(Hoa).sendKeys("100");

            select = new Select(driver.findElement(LoanType));
            select.selectByVisibleText("FHA");

            select = new Select(driver.findElement(BuyOrRefi));
            select.selectByVisibleText("Buy");


        }
        @Test
    public void MonthlyRate(){
            enterData();
            driver.findElement(CalculateButton).click();

            boolean mothlyPaymentExits =driver.findElements(MonthlyPayemnt).size()>0;
            Assert.assertTrue(mothlyPaymentExits, "Total payment is wrong");

        }
}

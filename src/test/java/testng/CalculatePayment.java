package testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatePayment {
    WebDriver driver;
    Select select;

    @BeforeMethod

    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.mortgagecalculator.org/");
        driver.manage().window().maximize();
    }

    public void enterMortgageData(){
        //Enter Home value "300000"
        driver.findElement(By.id("homeval")).clear();
        driver.findElement(By.id("homeval")).sendKeys("300000");

        //Enter down Payment "60000"
        driver.findElement(By.id("downpayment")).clear();
        driver.findElement(By.id("downpayment")).sendKeys("60000");

        //Click on radio button $ for down payment option

        driver.findElement(By.xpath("//*[@id='calc']//input[@name='param[downpayment_type]'][@value='money']")).click();

        //Enter loan amount "240000"
        driver.findElement(By.id("loanamt")).clear();
        driver.findElement(By.id("loanamt")).sendKeys("240000");

        //Enter interest rate 3%

        driver.findElement(By.id("intrstsrate")).clear();
        driver.findElement(By.id("intrstsrate")).sendKeys("3");

        //Enter loan term 30 years

        driver.findElement(By.id("loanterm")).clear();
        driver.findElement(By.id("loanterm")).sendKeys("30");

        //Selecting the month
        select = new Select(driver.findElement(By.name("param[start_month]")));
        select.selectByVisibleText("Nov");

        //Select year 2021
        driver.findElement(By.id("start_year")).clear();
        driver.findElement(By.id("start_year")).sendKeys("2021");

        //Enter property tax 5000

        driver.findElement(By.id("pptytax")).clear();
        driver.findElement(By.id("pptytax")).sendKeys("1000");

        //Enter pmi 0.5
        driver.findElement(By.id("pmi")).clear();
        driver.findElement(By.id("pmi")).sendKeys("0.5");

        //Enter homeowner insurance 1000
        driver.findElement(By.id("hoi")).clear();
        driver.findElement(By.id("hoi")).sendKeys("5000");

        //Enter monthly hoa 100
        driver.findElement(By.id("hoa")).clear();
        driver.findElement((By.id("hoa"))).sendKeys("100");

        //Enter loan type FHA
        select= new Select(driver.findElement(By.name("param[milserve]")));
        select.selectByVisibleText("FHA");

        //Select Buy from Buy or Refi

        select = new Select(driver.findElement(By.name("param[refiorbuy]")));
        select.selectByVisibleText("Buy");

    }
    @Test
    public void monthlyPayment(){
        enterMortgageData();
        //Click on the Calculator
        driver.findElement(By.name("cal")).click();

        boolean monthlyPaymentExits = driver.findElements(By.xpath("//*[@id='calc']//h3[text()='$1,611.85']")).size() >0;
        Assert.assertTrue(monthlyPaymentExits,"Total monthly payment is wrong");
    }

        @Test
        public void verifyHomePageTitle(){
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://phptravels.com/demo/");
            driver.manage().window().maximize();

            String expectedTitle = "Demo Script Test drive - PHPTRAVELS";
            String actualTitle = driver.getTitle();
            Assert.assertEquals(actualTitle, expectedTitle);
        }
    }


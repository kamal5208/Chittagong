package automation_test;

import command_providers.ActOn;
import command_providers.BrowserActions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.Home;
import utilities.DateUtils;
import utilities.ReadConfigFiles;

public class CalculateMonthlyPayment {
            private static final Logger LOGGER = LogManager.getLogger(CalculateMonthlyPayment.class);

            WebDriver driver;
            Select select;


            @BeforeMethod
            public void openBrowser(){
                WebDriverManager.chromedriver().setup();
                driver= new ChromeDriver();
                String url = ReadConfigFiles.getPropertyValues("MortgageCalculatorUrl");
                ActOn.browser(driver).openBrowser(url);
                LOGGER.info("Browser is successfully initiated with the URL:"  + url);


            }
            @Test
            public void calculateMonthlyPayment() {
                String Date = DateUtils.returnNextMonth();
                String[] dateArray = Date.split("-");
                String month = dateArray[0];
                String year = dateArray[1];
               Home home = new Home(driver)
               // or we can use new Home (driver)
                       .typeHomePrice("300000")
                       .typeDownPayment("60000")
                       .clickDownPaymentByDollar()
                       .typeLoanAmount("240000")
                       .typeInterestRate("3")
                       .typeLoanTermInYear("30")
                       .selectMonth(month)
                       .selectYear(year)
                       .typePropertyTax("5000")
                       .typePmi("0.5")
                       .typeHoi("1000")
                       .typeHOA("100")
                       .selectLoanType("FHA")
                       .selectBuyOrRefi("Buy")
                       .clickCalculateButton()
                       .validateMonthlyPayment("$1,611.85");

            }
           @AfterMethod
           public void testCleanup(){
              ActOn.browser(driver).closeBrowser();
              LOGGER.info("Browser successfully close");
            }
       }



package automation_test.mortgage_calculator_parameterized;

import automation_test.CalculateRealApr;
import command_providers.ActOn;
import data_provider.DataProviderClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_objects.Home;
import utilities.ReadConfigFiles;

public class CalculatesRates_parameterized {
    private static final Logger LOGGER = LogManager.getLogger(CalculatesRates_parameterized.class);

    WebDriver driver;

    @BeforeMethod
    public void browserInitialization() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String url = ReadConfigFiles.getPropertyValues("MortgageCalculatorUrl");
        ActOn.browser(driver).openBrowser(url);
        LOGGER.info("Browser is successfully initiated with the URL:" + url);

    }


    @Test(dataProvider ="RealAprRates",dataProviderClass = DataProviderClass.class)
    public void calculateRealApr(String HomePrice,String DownPayment,String InterestRate,String AprRates) {
        new Home(driver)
                .mouseHoverToRates()
                .navigateToRealApr()
                .waitForPageLoad()
                .typeHomePrice(HomePrice)
                .clickDownPaymentInDollar()
                .typeDownPayment(DownPayment)
                .typeInterestRate(InterestRate)
                .clickOnCalculateButton()
                .validateRealAprRate(AprRates);


    }

    @AfterMethod
    public void testCleanUp() {
        ActOn.browser(driver).closeBrowser();
        LOGGER.info("Browser close successfully");

    }
}

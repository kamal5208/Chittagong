package automation_test.mortgage_calculator_parameterized;

import automation_test.CalculateMonthlyPayment;
import command_providers.ActOn;
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
import utilities.SqlConnector;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CalculateMonthlyPaymentParameterized {
    private static final Logger LOGGER = LogManager.getLogger(CalculateMonthlyPaymentParameterized.class);

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
        ResultSet rs = SqlConnector.readData("select * from monthly_mortgage");
       try {
           while (rs.next()) {
               LOGGER.info("--------Start of " +rs.getRow()+ "   Iteration----------");
               Home home = new Home(driver)

                       // or we can use new Home (driver)
                       .typeHomePrice(rs.getString("homevalue"))
                       .typeDownPayment(rs.getString("downpayment"))
                       .clickDownPaymentByDollar()
                       .typeLoanAmount(rs.getString("loanamount"))
                       .typeInterestRate(rs.getString("interestrate"))
                       .typeLoanTermInYear(rs.getString("loanterm"))
                       .selectMonth(month)
                       .selectYear(year)
                       .typePropertyTax(rs.getString("propertytax"))
                       .typePmi(rs.getString("pmi"))
                       .typeHoi(rs.getString("homeownerinsurance"))
                       .typeHOA(rs.getString("monthlyhoa"))
                       .selectLoanType(rs.getString("loantype"))
                       .selectBuyOrRefi(rs.getString("buyorrefi"))
                       .clickCalculateButton()
                       .validateMonthlyPayment(rs.getString("totalmonthlypayment"));

           }
       }catch (SQLException e) {
           LOGGER.error("SQL Query Error: " + e.getMessage());
       }

    }

    @AfterMethod
   public void testCleanup(){
      ActOn.browser(driver).closeBrowser();
        LOGGER.info("Browser successfully close");
        LOGGER.info("==End Test (CalculateMonthlyPayment)==");
    }
}



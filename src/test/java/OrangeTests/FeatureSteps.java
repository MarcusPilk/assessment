package OrangeTests;

import WebPages.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class FeatureSteps {

    WebDriver driver = null;
    static ExtentReports reports;
    ExtentTest test;
    LogInPage logInPage;
    DashboardPage dashboardPage;
    EmployeesPage employeesPage;
    PersonalDetailsPage personalDetailsPage;

    @Before
    public void setUp(){
        reports = new ExtentReports(Constants.REPORT_PATH,true);
        System.setProperty("webdriver.chrome.driver",Constants.DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();
        reports.flush();

    }


    @Given("^the login page$")
    public void the_login_page() throws Throwable {
        test = reports.startTest("Testing add user");
        driver.get(Constants.ORANGE_URL);
        test.log(LogStatus.INFO,"Login page loaded");
    }

    @When("^I login$")
    public void i_login() throws Throwable {
        LogInPage logInPage = PageFactory.initElements(driver, LogInPage.class);
        logInPage.loginProcess();
        test.log(LogStatus.INFO,"Log in successful");
    }

    @When("^I click the PIM tab$")
    public void i_click_the_PIM_tab() throws Throwable {
        dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        dashboardPage.clickPIM();
        test.log(LogStatus.INFO, "PIM tab clicked");
    }

    @When("^then the Add Employee Tab$")
    public void then_the_Add_Employee_Tab() throws Throwable {
        dashboardPage.clickAddUser(driver);
        test.log(LogStatus.INFO, "Add Employee tab clicked");

    }

    @When("^I fill out the Add Employee Details correctly$")
    public void i_fill_out_the_Add_Employee_Details_correctly() throws Throwable {

        employeesPage = PageFactory.initElements(driver,EmployeesPage.class);
        employeesPage.fillEmployeeDetails(driver);
        test.log(LogStatus.INFO, "Employer details filled in correctly");
    }

    @When("^I choose to create Login Details by clicking the appropriate button$")
    public void i_choose_to_create_Login_Details_by_clicking_the_appropriate_button() throws Throwable {
        employeesPage.clickLoginCheckBox();
        test.log(LogStatus.INFO,"Login Box checked");
    }

    @When("^I fill out the Login Details correctly$")
    public void i_fill_out_the_Login_Details_correctly() throws Throwable {
        employeesPage.fillLoginDetails();
        test.log(LogStatus.INFO,"Login details filled in");
    }

    @When("^I click the Save button$")
    public void i_click_the_Save_button() throws Throwable {
        employeesPage.saveUser();
        test.log(LogStatus.INFO,"Employee details and login data saved");
    }

    @Then("^I can search for the Employee I have just created$")
    public void i_can_search_for_the_Employee_I_have_just_created() throws Throwable {
        employeesPage.searchUser(driver);
        test.log(LogStatus.INFO,"I have searched for the newly created user");
    }

    @Then("^select them for inspection$")
    public void select_them_for_inspection() throws Throwable {
        employeesPage.clickUser(driver);
        personalDetailsPage = PageFactory.initElements(driver,PersonalDetailsPage.class);
        if(personalDetailsPage.isSelected(driver)){
            test.log(LogStatus.PASS,"New User has been selected");
        }else{
            test.log(LogStatus.FAIL,"New user has not been selected");
        }
        reports.endTest(test);
        assertTrue(personalDetailsPage.isSelected(driver));
    }
}

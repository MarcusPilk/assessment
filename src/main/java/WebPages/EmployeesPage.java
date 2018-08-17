package WebPages;

import gherkin.lexer.He;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class EmployeesPage {

    @FindBy (id="pimAddEmployeeForm")
    WebElement employeeModal;

    @FindBy (xpath = "//*[@id=\"menu_pim_addEmployee\"]/span[2]")
    WebElement addUser;

    @FindBy (xpath = "//*[@id=\"employeeListTable\"]/tbody")
    WebElement tableData;

    @FindBy (id="firstName")
    WebElement fName;

    @FindBy (id="lastName")
    WebElement lName;

    @FindBy (id="employeeId")
    WebElement empId;

    @FindBy (xpath = "//*[@id=\"location_inputfileddiv\"]/div/input")
    WebElement locationDropDown;

    @FindBy (id="select-options-ecf31b92-0c83-3ebf-1a96-324e24b84ebe")
    WebElement dropDownList;

    @FindBy (xpath = "//*[@id=\"select-options-ecf31b92-0c83-3ebf-1a96-324e24b84ebe\"]/li[3]/span")
    WebElement locationSelection;

    @FindBy (xpath = "//*[@id=\"pimAddEmployeeForm\"]/div[1]/div/materializecss-decorator[3]/div/sf-decorator/div/label")
    WebElement createLoginCheck;

    @FindBy (id="username")
    WebElement usrNameTxt;

    @FindBy (id="password")
    WebElement pwdTxt;

    @FindBy (id="confirmPassword")
    WebElement cnfrmPwdTxt;

    @FindBy (xpath = "//*[@id=\"pimAddEmployeeForm\"]/div[2]/a[2]")
    WebElement cancelButton;

    @FindBy (id="systemUserSaveBtn")
    WebElement sveUsrBtn;

    @FindBy (xpath = "//*[@id=\"menu_pim_viewEmployeeList\"]/span[2]")
    WebElement viewEmployees;

    @FindBy (id="employee_name_quick_filter_employee_list_value")
    WebElement searchEmployees;

    @FindBy (xpath = "//*[@id=\"employeeListTable\"]/tbody/tr[1]")
    WebElement employeeResult;

    @FindBy (xpath = "//*[@id=\"right-side\"]/header/div/nav/div/div/ul[2]/li[2]/a")
    WebElement searchIcon;

    public static String employeeID = "";

    public void fillEmployeeDetails(WebDriver driver){
        Actions action = new Actions(driver);
        HelperMethods.waitUntilVisible(driver,fName,30);
        fName.sendKeys("Test");
        lName.sendKeys("User1");
        employeeID = empId.getAttribute("value");
        locationDropDown.click();
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER);
    }


    public void clickLoginCheckBox(){
        createLoginCheck.click();
    }

    public void fillLoginDetails(){
        usrNameTxt.sendKeys("username");
        pwdTxt.sendKeys("password");
        cnfrmPwdTxt.sendKeys("password");
    }

    public void saveUser(){
        sveUsrBtn.click();

    }

    public void searchUser(WebDriver driver){
        HelperMethods.waitUntilHidden(driver,employeeModal,6);
        viewEmployees.click();
        HelperMethods.waitUntilClickable(driver,searchEmployees,2);
        HelperMethods.waitUntilVisible(driver,tableData,10);
        searchEmployees.sendKeys("Test User1");

        HelperMethods.sleep(5000);

        searchIcon.click();

    }

    public void clickUser(WebDriver driver){
        HelperMethods.waitUntilVisible(driver, employeeResult, 10);
        employeeResult.click();
    }
}

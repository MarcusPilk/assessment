package WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalDetailsPage {
    @FindBy (id="employee_id")
    WebElement empId;

    @FindBy (xpath = "//*[@id=\"menu_pim_viewEmployeeList\"]/span[2]")
    WebElement viewEmployeeList;

    public Boolean isSelected(WebDriver driver){
        HelperMethods.waitUntilVisible(driver,empId,10);
        if(empId.getAttribute("value").equals(EmployeesPage.employeeID)){
            System.out.println(empId.getAttribute("value"));
            return true;
        }else{
            System.out.println(empId.getAttribute("value"));

            return false;
        }
    }
}

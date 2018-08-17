package WebPages;

import gherkin.lexer.He;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {
    @FindBy (xpath = "//*[@id=\"menu_pim_viewPimModule\"]/a/span[2]")
    WebElement pimLink;

    @FindBy (id="menu_pim_addEmployee")
    WebElement addUserLink;


    public void clickPIM(){
        pimLink.click();
    }

    public void clickAddUser(WebDriver driver){
        HelperMethods.waitUntilClickable(driver,addUserLink,2);
        addUserLink.click();
    }

}

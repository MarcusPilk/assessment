package WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage {

    @FindBy (id="txtUsername")
    WebElement txtUsername;

    @FindBy (id="txtPassword")
    WebElement txtPassword;

    @FindBy (id="btnLogin")
    WebElement btnLogin;

    public void loginProcess(){
        txtUsername.sendKeys("Admin");
        txtPassword.sendKeys("AdminAdmin");
        btnLogin.click();
    }
}

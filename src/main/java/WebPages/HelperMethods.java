package WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

public class HelperMethods {

    public static void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitUntilVisible(WebDriver driver, WebElement element, int waitTime){
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilHidden(WebDriver driver, WebElement element, int waitTime){
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitUntilClickable(WebDriver driver, WebElement element, int waitTime){
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }



}

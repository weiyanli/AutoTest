package pages;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
    protected AndroidDriver driver;
    protected WebDriverWait wait;
    protected BasePage(){

    }
    public BasePage(AndroidDriver driver){
        this.driver=driver;

    }

    protected WebElement getElem(By by){
        WebElement ele= driver.findElement(by);
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(ele));
        return ele;
    }

}

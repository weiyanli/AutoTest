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

    protected WebElement getElement(String mode, String attr){
        WebElement ele=null;
        if(mode.equals("id")){
            ele= driver.findElement(By.id(attr));
        }else if(mode.equals("xpath")){
            ele=  driver.findElement(By.xpath(attr));
        }else if(mode.equals("findElementByAndroidUIAutomator")){
            ele= driver.findElementByAndroidUIAutomator(attr);
        }

        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(ele));
        return ele;
    }

}

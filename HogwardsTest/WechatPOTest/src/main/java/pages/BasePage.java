package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
    protected AndroidDriver driver;
    protected WebDriverWait wait;

    protected WebElement getElement(String mode, String attr){
        if(mode.equals("id")){
            return driver.findElement(By.id(attr));
        }else if(mode.equals("xpath")){
            return driver.findElement(By.xpath(attr));
        }else if(mode.equals("findElementByAndroidUIAutomator")){
            return driver.findElementByAndroidUIAutomator(attr);
        }
        return null;
    }
}

package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasePage{

    By searchET= By.id("com.tencent.wework:id/ecq");
    private MobileElement searchResult(String name){
        MobileElement result=(MobileElement) getElement("xpath","//android.widget.TextView[contains(@text,'"+name+"')]");
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(result));
        return result;
    }
    By searchResults= By.id("com.tencent.wework:id/bcw");

    public SearchPage(AndroidDriver driver){
        super(driver);
    }


    private void search(String name){
        driver.findElement(searchET).sendKeys(name);
    }
    public MobileElement vertifyHaveName(String name){
        search(name);
        MobileElement element=searchResult(name);
        return element;
    }
    public MembInfoPage searchAndClick(String name){
        search(name);
        searchResult(name).click();
        return new MembInfoPage(driver);
    }
    public String getSearchResults(){
        return driver.findElement(searchResults).getText();
    }

}

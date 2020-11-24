package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class SearchPage extends BasePage{

    By searchET= By.id("com.tencent.wework:id/ecq");
    private MobileElement searchResult(String name){
        return (MobileElement) getElement("xpath","//android.widget.TextView[@text='"+name+"']");
    }
    By searchResults= By.id("com.tencent.wework:id/bcw");




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
        return new MembInfoPage();
    }
    public String getSearchResults(){
        return driver.findElement(searchResults).getText();
    }

}

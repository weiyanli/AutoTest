package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SearchPage extends BasePage{

    private MobileElement searchET(){
        return (MobileElement) getElement("id","com.tencent.wework:id/ecq");
    }
    private MobileElement searchResult(String name){
        return (MobileElement) getElement("xpath","//android.widget.TextView[@text='"+name+"']");
    }
    public MobileElement searchResults(){
        return (MobileElement) getElement("id","com.tencent.wework:id/bcw");
    }



    private void search(String name){
        searchET().sendKeys(name);
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

}

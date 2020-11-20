package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

//添加成员 选择添加方式页面
public class AddMenuPage extends BasePage{
    private MobileElement getAddManu(){
        return (MobileElement) getElement("id","com.tencent.wework:id/blm");
    }
    private MobileElement backIcon(){
        return (MobileElement) getElement("id","com.tencent.wework:id/f_c");
    }

    public AddMembPage addAsManu(){
        //手动输入添加
        getAddManu().click();
        return new AddMembPage();
    }
    public void back(){
        if(getAddManu().isDisplayed()){
            backIcon().click();
        }
    }

}

package pages;

import io.appium.java_client.MobileElement;

//添加成员 详细信息页面
public class AddMembPage extends BasePage{
    private MobileElement name(){
        return (MobileElement) getElement("id","com.tencent.wework:id/ag2");
    }
    private MobileElement sex(){
        return (MobileElement) getElement("id","com.tencent.wework:id/ah2");
    }
    private MobileElement woman(){
        return (MobileElement) getElement("xpath","//*[@text='女']");
    }
    private MobileElement mobile(){
        return (MobileElement) getElement("id","com.tencent.wework:id/doq");
    }
    private MobileElement save(){
        return (MobileElement) getElement("id","com.tencent.wework:id/f_u");
    }

    public void addMember(String name,String mobile){
        //编辑成员信息
        name().sendKeys(name);;
        sex().click();
        woman().click();
        mobile().sendKeys("15112341234");
        save().click();

    }
}

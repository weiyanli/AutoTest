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
    private MobileElement selectSex(String sex){
        return (MobileElement) getElement("xpath","//*[@text='"+sex+"']");
    }
    private MobileElement mobile(){
        return (MobileElement) getElement("id","com.tencent.wework:id/doq");
    }
    private MobileElement save(){
        return (MobileElement) getElement("id","com.tencent.wework:id/f_u");
    }

    public void addMember(String name,String mobile,String sex){
        //编辑成员信息
        name().sendKeys(name);;
        sex().click();
        selectSex(sex).click();
        mobile().sendKeys(mobile);
        save().click();

    }
}

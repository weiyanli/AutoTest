package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditMembPage extends BasePage{
    private MobileElement nick(){
        return (MobileElement)  getElement("xpath","//*[@resource-id='"+"com.tencent.wework:id/cz5"+"']//android.widget.EditText");
    }
    private MobileElement sex(){
        return (MobileElement)  getElement("id","com.tencent.wework:id/ah2");
    }
    private MobileElement man(){
        return (MobileElement)  getElement("xpath","//*[@text='男']");
    }
    private MobileElement save(){
        return (MobileElement)  getElement("id","com.tencent.wework:id/f_u");
    }
    private MobileElement delete(){
        return (MobileElement)  getElement("findElementByAndroidUIAutomator","new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"删除成员\"))");
    }
    private MobileElement deleteConform(){
        return (MobileElement)  getElement("id","com.tencent.wework:id/at8");
    }



    public void updateMember(String nickName){
        //编辑别名
        nick().sendKeys(nickName);
        //修改性别
        sex().click();
        man().click();
        //保存
        MobileElement save=save();
        wait.until(ExpectedConditions.visibilityOf(save));
        save.click();
    }

    public void deleteMember(){
        //滑动至“删除成员”
        delete().click();
        //删除确认
        deleteConform().click();
    }
}

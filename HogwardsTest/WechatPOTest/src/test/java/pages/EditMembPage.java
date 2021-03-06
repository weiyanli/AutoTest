package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditMembPage extends BasePage{
    By nick= By.xpath("//*[@resource-id='"+"com.tencent.wework:id/cz5"+"']//android.widget.EditText");
    By sexBtn=By.id("com.tencent.wework:id/ah2");

    private By selectSex(String sex){
        return By.xpath("//*[@text='"+sex+"']");
    }
    By saveBtn=By.id("com.tencent.wework:id/f_u");
    private MobileElement delete(){
        return (MobileElement) driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"删除成员\"))");
    }
    By deleteConform=By.id("com.tencent.wework:id/at8");


    public EditMembPage(AndroidDriver driver){
        super(driver);
    }

    public void updateMember(String nickName,String sex){
        //编辑别名
        getElem(nick).sendKeys(nickName);
        //修改性别
        getElem(sexBtn).click();
        getElem(selectSex(sex)).click();
        //保存
        getElem(saveBtn).click();
    }

    public void deleteMember(){
        //滑动至“删除成员”
        delete().click();
        //删除确认
        driver.findElement(deleteConform).click();
    }
}

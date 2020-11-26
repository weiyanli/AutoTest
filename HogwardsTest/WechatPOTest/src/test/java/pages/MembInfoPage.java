package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

//个人信息页
public class MembInfoPage extends BasePage{

    By menu= By.id("com.tencent.wework:id/f_n");
    By editMemb= By.id("com.tencent.wework:id/akp");
    By nick= By.id("com.tencent.wework:id/exe");

    public MembInfoPage(AndroidDriver driver){
        super(driver);
    }

    public EditMembPage gotoEditMember(){
        //编辑菜单
        getElem(menu).click();
        //编辑成员
        getElem(editMemb).click();
        return new EditMembPage(driver);
    }
    public String getNickName(){
        return  getElem(nick).getText();
    }


}

package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

//个人信息页
public class MembInfoPage extends BasePage{

    By menu= By.id("com.tencent.wework:id/f_n");
    By editMemb= By.id("com.tencent.wework:id/akp");
    By nick= By.id("com.tencent.wework:id/exe");

    public EditMembPage gotoEditMember(){
        //编辑菜单
        driver.findElement(menu).click();
        //编辑成员
        driver.findElement(editMemb).click();
        return new EditMembPage();
    }
    public String getNickName(){
        return  driver.findElement(nick).getText();
    }


}

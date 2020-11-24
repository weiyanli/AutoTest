package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

//添加成员 详细信息页面
public class AddMembPage extends BasePage{
    private By nameET=By.id("com.tencent.wework:id/ag2");
    private By sexBtn=By.id("com.tencent.wework:id/ah2");
    private MobileElement selectSex(String sex){
        return (MobileElement) getElement("xpath","//*[@text='"+sex+"']");
    }
    private By mobileET=By.id("com.tencent.wework:id/doq");
    private By save=By.id("com.tencent.wework:id/f_u");


    public void addMember(String name,String mobile,String sex){
        //编辑成员信息
        driver.findElement(nameET).sendKeys(name);;
        driver.findElement(sexBtn).click();
        selectSex(sex).click();
        driver.findElement(mobileET).sendKeys(mobile);
        driver.findElement(save).click();

    }
}

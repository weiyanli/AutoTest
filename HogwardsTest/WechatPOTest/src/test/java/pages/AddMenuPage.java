package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

//添加成员 选择添加方式页面
public class AddMenuPage extends BasePage{

    private By addManu=By.id("com.tencent.wework:id/blm");
    private By backIcon=By.id("com.tencent.wework:id/f_c");

    public AddMenuPage(AndroidDriver driver){
        super(driver);
    }

    public AddMembPage addAsManu(){
        //手动输入添加
        getElem(addManu).click();
        return new AddMembPage(driver);
    }
    public void back(){
        if( getElem(addManu).isDisplayed()){
            getElem(backIcon).click();
        }
    }

}

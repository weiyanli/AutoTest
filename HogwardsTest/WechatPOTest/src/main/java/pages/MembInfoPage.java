package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

//个人信息页
public class MembInfoPage extends BasePage{

    private MobileElement menu(){
        return (MobileElement) getElement("id","com.tencent.wework:id/f_n");
    }
    private MobileElement editMemb(){
        return  (MobileElement) getElement("id","com.tencent.wework:id/akp");
    }
    public MobileElement nick(){
        return  (MobileElement) getElement("id","com.tencent.wework:id/exe");
    }
    public EditMembPage gotoEditMember(){
        //编辑菜单
        menu().click();
        //编辑成员
        editMemb().click();
        return new EditMembPage();
    }


}

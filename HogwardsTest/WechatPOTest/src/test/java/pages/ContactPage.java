package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

//通讯录页面
public class ContactPage extends BasePage{
    public ContactPage(AndroidDriver driver){
        super(driver);
    }
    public ContactPage() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "xx");
        desiredCapabilities.setCapability("noReset", "true");
        desiredCapabilities.setCapability("appPackage", "com.tencent.wework");
        desiredCapabilities.setCapability("appActivity", ".launch.LaunchSplashActivity");
        desiredCapabilities.setCapability("ensureWebviewsHavePages", true);

        try {
            URL remoteUrl = new URL("http://localhost:4723/wd/hub");
            driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        }catch (MalformedURLException e){}

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait=new WebDriverWait(driver,3);
    }

    //导航菜单的通讯录按钮
    By nav_contact= By.xpath("//*[@text='通讯录']");
    //右上搜索按钮
    By seachIcon=By.id("com.tencent.wework:id/f_x");
    //底部添加成员按钮
    private WebElement addBtn(){
        return getElement("findElementByAndroidUIAutomator",
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"添加成员\"))");
    }

    //进入添加成员页
    public AddMenuPage goToAddPage(){
        //点击通讯录
        driver.findElement(nav_contact).click();
        //滑动至“添加成员”并点击
        addBtn().click();
        return (new AddMenuPage(driver));
    }
    //进入搜索页面
    public SearchPage gotoSearch(){
        driver.findElement(seachIcon).click();
        return (new SearchPage(driver));
    }
    public void back(){
        driver.navigate().back();
        driver.navigate().back();
    }

}

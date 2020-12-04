package testrunner;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.BasePage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class PagesTestRunner extends TestRunnerBase{
    private AndroidDriver driver;
    public WebElement ele;
    private DesiredCapabilities desiredCapabilities;
    private URL remoteUrl;

    public void run(){
        steps.forEach(step->{
            if(step.keySet().contains("cap")){
                desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setCapability("platformName", "android");
                desiredCapabilities.setCapability("deviceName", "xx");
                desiredCapabilities.setCapability("noReset", "true");
                desiredCapabilities.setCapability("appPackage", "com.tencent.wework");
                desiredCapabilities.setCapability("appActivity", ".launch.LaunchSplashActivity");
                desiredCapabilities.setCapability("ensureWebviewsHavePages", true);

            }else if(step.keySet().contains("url")){
                try {
                    remoteUrl = new URL("http://localhost:4723/wd/hub");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }else if(step.keySet().contains("driver")){
                driver = new AndroidDriver(remoteUrl, desiredCapabilities);
            }else if(step.keySet().contains("implicitlyWait")){
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            }else if (step.keySet().contains("find")) {
                By by = null;
                HashMap<String, Object> map = (HashMap<String, Object>) getValue(step,"find");
                if (map.keySet().contains("id")) {
                    by = By.id(map.get("id").toString());
                    ele = driver.findElement(by);
                } else if (map.keySet().contains("xpath")) {
                    by = By.xpath(map.get("xpath").toString());
                    ele = driver.findElement(by);
                } else if(map.keySet().contains("AndroidUIAutomator")){
                    ele=driver.findElementByAndroidUIAutomator(map.get("AndroidUIAutomator").toString());
                }

            } else if (step.keySet().contains("click")) {
                ele.click();

            }
        });
    }
}

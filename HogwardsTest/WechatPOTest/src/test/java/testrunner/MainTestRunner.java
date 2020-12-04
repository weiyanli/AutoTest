package testrunner;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.*;

public class MainTestRunner extends  TestRunnerBase{
    private AndroidDriver driver;
    public WebElement ele;

    public void run(){
        steps.forEach(step->{
            if(step.keySet().contains("init")){
                ArrayList list=(ArrayList) getValue(step,"init");
                String className=(String) list.get(1);
                String classObject=(String) list.get(0);
                BasePage.getInstance().poInit(classObject,className);
            }else if(step.keySet().toString().contains("_")){
                String key=step.keySet().iterator().next();
                String[] keys=key.split("_");
                BasePage.getInstance().getPO(keys[0]).stepRun(keys[1]);

            }
        });
    }

}

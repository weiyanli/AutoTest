import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCaseRunner {
    public List<String> data;
    public List<HashMap<String,Object>> steps;
    public ChromeDriver driver;
    public WebElement ele;
    private int index=-1;

    public void caseGengenerate(){
        List<TestCaseRunner> list=new ArrayList<TestCaseRunner>();
        for(int i=0;i<data.size();i++){
            TestCaseRunner testCaseRunner=new TestCaseRunner();
            testCaseRunner.index=i;
            testCaseRunner.steps=steps;
            testCaseRunner.data=data;
            list.add(testCaseRunner);
            testCaseRunner.run();
        }
    }
    private Object getValue(HashMap<String,Object> step,String key){
        Object value=step.get(key);
        if(value instanceof String){
            value=((String) value).replace("${data}",data.get(index));
        }
        return value;

    }

    private void run(){
        steps.forEach(step-> {
            if (step.keySet().contains("setProperty")) {
                System.setProperty("webdriver.chrome.driver", getValue(step,"setProperty").toString());
            } else if (step.keySet().contains("driver")) {
                driver = new ChromeDriver();
            } else if (step.keySet().contains("implicitlyWait")) {
                driver.manage().timeouts().implicitlyWait((int)(getValue(step,"implicitlyWait")), TimeUnit.MINUTES);
            } else if (step.keySet().contains("get")) {
                driver.get(step.get("get").toString());
            } else if (step.keySet().contains("find")) {
                By by = null;
                HashMap<String, Object> map = (HashMap<String, Object>) getValue(step,"find");
                if (map.keySet().contains("id")) {
                    by = By.id(map.get("id").toString());
                } else if (map.keySet().contains("xpath")) {
                    by = By.id(map.get("xpath").toString());
                }
                ele = driver.findElement(by);

            } else if (step.keySet().contains("click")) {
                ele.click();

            } else if (step.keySet().contains("sendKeys")) {
                ele.sendKeys(getValue(step,"sendKeys").toString());
            }
        });


    }
}

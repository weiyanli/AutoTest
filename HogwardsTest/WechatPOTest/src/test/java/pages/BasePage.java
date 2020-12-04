package pages;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Stream;


public class BasePage {
    protected AndroidDriver driver;
    protected WebDriverWait wait;
    public static BasePage instance=null;
    public static HashMap<String,BasePage> pages= new HashMap<>();
    public BasePage(){

    }
    public BasePage(AndroidDriver driver){
        this.driver=driver;

    }
    public static BasePage getInstance(){
        if(instance==null){
            instance=new BasePage();
        }
        return instance;
    }

    protected WebElement getElem(By by){
        WebElement ele= driver.findElement(by);
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(ele));
        return ele;
    }

    public void stepRun(String methodName) {
        Method method= Arrays.stream(this.getClass().getMethods()).filter(m->m.getName().equals(methodName)).findFirst().get();
        try {
            method.invoke(this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    public void poInit(String name,String className)  {
        BasePage page= null;
        try {
            page = (BasePage)Class.forName(className).getDeclaredConstructor().newInstance();
            pages.put(name ,page);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }
    public BasePage getPO(String name){
        return pages.get(name);
    }

}

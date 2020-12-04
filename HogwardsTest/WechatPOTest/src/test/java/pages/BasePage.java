package pages;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testcases.MainTest;
import testrunner.PagesTestRunner;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;


public class BasePage {
    protected AndroidDriver driver;
    protected WebDriverWait wait;
    public static BasePage instance=null;
    public static HashMap<String,BasePage> pages= new HashMap<>();
    protected HashMap<String,List<HashMap<String,Object>>> yamlSource=new HashMap<>();
    public PagesTestRunner runner=null;
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
//    //反射方式2/3
//    public void stepRun(String methodName) {
//        Method method= Arrays.stream(this.getClass().getMethods()).filter(m->m.getName().equals(methodName)).findFirst().get();
//        try {
//            method.invoke(this);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//    }
//    public void poInit(String name,String className)  {
//        BasePage page= null;
//        try {
//            page = (BasePage)Class.forName(className).getDeclaredConstructor().newInstance();
//            pages.put(name ,page);
//        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
//            e.printStackTrace();
//        }
//
//    }
//
    public BasePage getPO(String name){
        return pages.get(name);
    }

    public BasePage poInit(String name,String yaml)  {
        BasePage page=new BasePage();

        ObjectMapper om=new ObjectMapper(new YAMLFactory());
        TypeReference tr=new TypeReference<HashMap<String,List<HashMap<String,Object>>>>(){};
        HashMap<String,List<HashMap<String,Object>>> values= null;
        try {
            values = om.readValue(MainTest.class.getResourceAsStream("contactPagePO.yaml"),tr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        page.yamlSource=values;
        pages.put(name,page);
        return page;
    }
    public void stepRun(String methodName) {
        if(runner==null){
            runner=new PagesTestRunner();
        }
        runner.steps=this.yamlSource.get(methodName);
        runner.data=new ArrayList<>();
        runner.run();
    }

}

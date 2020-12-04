

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import junit.framework.TestCase;
import org.aspectj.runtime.internal.PerObjectMap;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class MainTest {


    @ParameterizedTest
//    @ValueSource(strings = { "xx"})
    @MethodSource()
    public void search(TestCaseRunner values){
//        System.setProperty("webdriver.chrome.driver","C:\\Users\\yanli\\Downloads\\chromedriver_87\\chromedriver.exe");
//        ChromeDriver driver=new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
//        driver.get("https://ceshiren.com/");
//        driver.findElement(By.id("search-button")).click();
//        driver.findElement(By.id("search-term")).sendKeys(values);

        System.out.println(values);
        values.run();
    }
    static List<TestCaseRunner> search() throws IOException {
//        return Stream.of("xx1","xx2");
        ObjectMapper om=new ObjectMapper(new YAMLFactory());
        TypeReference tr=new TypeReference<TestCaseRunner>(){};
        TestCaseRunner values= om.readValue(MainTest.class.getResourceAsStream("xx.yaml"),tr);
        return values.caseGengenerate();
    }



}

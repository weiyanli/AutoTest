import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleTest {
    static WebDriver driver;
    @BeforeAll
    public static void init(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yanli\\Downloads\\chromedriver.exe");
        driver  = new ChromeDriver();
        driver.get("https://www.baidu.com");
    }
    @Test
    public void search() throws InterruptedException {
        driver.findElement(By.id("kw")).sendKeys("xx");
        Thread.sleep(1000);
    }
    @AfterAll
    public static void close(){
        driver.close();
    }

}

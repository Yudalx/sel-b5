import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EasyTest {

    private static WebDriver driver;

    @BeforeAll
    static void setUp(){
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
     void easyTest(){
        driver.get("https://github.com/AlexeyCode/sel-b5");
        driver.findElement(By.xpath("//a[text()=\"Find File\"]")).click();
        assertEquals("GitHub - AlexeyCode/sel-b5", driver.getTitle());

    }

    @AfterAll
    static void tearDown(){
        driver.quit();
    }
}

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task_8 {
    private static WebDriver driver;

    @BeforeAll
    static void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    void task_8Test(){
        driver.get("http://localhost:85/litecart");//порт 85, 80 занят на рабочем пк

        List<WebElement> productList = driver.findElements(By.xpath("//li[contains(@class, \"product\")]"));
        for(WebElement element : productList){
            assertEquals(1, element.findElements(By.xpath(".//div[contains(@class, \"sticker\")]")).size());
        }
    }

    @AfterAll
    static void tearDown(){
        driver.quit();
    }
}

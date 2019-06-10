import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task_9 {
    private static WebDriver driver;

    @BeforeAll
    static void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    void task_8Test() {
        driver.get("http://localhost:85/litecart/admin");//порт 85, 80 занят на рабочем пк
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@name=\"login\"]")).click();
        assertEquals("My Store", driver.getTitle());
        driver.get("http://localhost:85/litecart/admin/?app=countries&doc=countries");

        WebElement table = driver.findElement(By.xpath("//table[@class = \"dataTable\"]"));

        List<WebElement> tableRows = driver.findElements(By.xpath("//tr[@class = \"row\"]"));
    }


    @AfterAll
    static void tearDown(){
        //driver.quit();
    }
}

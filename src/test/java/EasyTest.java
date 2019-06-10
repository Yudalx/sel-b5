import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EasyTest {

    private static WebDriver driver;

    @BeforeAll
    static void setUp(){
        driver = new ChromeDriver();
    }

    @Test
     void easyTest(){
        driver.get("http://localhost:85/litecart/admin");//порт 85, 80 занят на рабочем пк
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@name=\"login\"]")).click();
        assertEquals("My Store", driver.getTitle());

        List<WebElement> elementList = driver.findElements(By.xpath("//li[@id=\"app-\"]"));
        List<WebElement> listSubElement;

        for(int i = 0; i < elementList.size(); i++){
            elementList = driver.findElements(By.xpath("//li[@id=\"app-\"]"));
            elementList.get(i).click();
            listSubElement =  driver.findElements(By.xpath("//ul[@class = \"docs\"]/li"));

            for(int l = 0; l < listSubElement.size(); l ++){
                listSubElement =  driver.findElements(By.xpath("//ul[@class = \"docs\"]/li"));
                listSubElement.get(l).click();
            }
        }
    }

    @AfterAll
    static void tearDown(){
        driver.quit();
    }
}

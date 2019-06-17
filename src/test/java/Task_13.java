import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task_13 {
    private static WebDriver driver;

    @BeforeAll
    static void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    void task_13() {
        WebDriverWait wait = new WebDriverWait(driver, 10/*seconds*/);
        driver.get("http://localhost:85/litecart");//порт 85, 80 занят на рабочем пк
        driver.findElement(By.xpath("//li[contains(@class, \"product\")]")).click();
        WebElement basket = driver.findElement(By.xpath("//span[@class=\"quantity\"]"));
        int productQuantity = 0;
        assertEquals(productQuantity, Integer.parseInt(basket.getText()));
        driver.findElement(By.xpath("//button[@name=\"add_cart_product\"]")).click();
        wait.until((WebDriver d) -> d.switchTo().alert()).accept();





        //driver.findElement(By.xpath("//div[@id=\"cart\"]/a[text() =\"Checkout »\"]")).click();


    }


    @AfterAll
    static void tearDown(){
        driver.quit();
    }
}

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task_12 {
    private static WebDriver driver;

    @BeforeAll
    static void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:85/litecart/admin");//порт 85, 80 занят на рабочем пк
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@name=\"login\"]")).click();
        assertEquals("My Store", driver.getTitle());
        driver.findElement(By.xpath("//span[text()=\"Catalog\"]")).click();
    }

    @Test
    void task_12() {
        String productName = "someProduct"+Math.random();
        driver.findElement(By.xpath("//a[text()=\" Add New Product\"]")).click();
        driver.findElement(By.xpath("//input[@name=\"name[en]\"]")).sendKeys(productName);
        driver.findElement(By.xpath("//input[@type=\"radio\" and @value=\"1\"]")).click();
        driver.findElement(By.xpath("//input[@name=\"code\"]")).sendKeys("789456");
        driver.findElement(By.xpath("//input[@name=\"quantity\"]")).sendKeys("10");
        driver.findElement(By.xpath("//input[@name=\"product_groups[]\" and @value=\"1-3\"]")).click();
        File file = new File("src\\main\\resources\\images\\ArcheAge_sample.jpg");
        String fileDest = file.getAbsolutePath();
        WebElement fileUploader = driver.findElement(By.xpath("//input[@type=\"file\"]"));
        fileUploader.sendKeys(fileDest);
        driver.findElement(By.xpath("//input[@name=\"date_valid_from\"]")).sendKeys("16.06.2019");
        driver.findElement(By.xpath("//input[@name=\"date_valid_to\"]")).sendKeys("16.07.2019");


        driver.findElement(By.xpath("//a[@href=\"#tab-information\"]")).click();
        Select select = new Select(driver.findElement(By.xpath("//select[@name=\"manufacturer_id\"]")));
        select.selectByVisibleText("ACME Corp.");
        driver.findElement(By.xpath("//input[@name=\"keywords\"]")).sendKeys("keyWord");
        driver.findElement(By.xpath("//input[@name=\"short_description[en]\"]")).sendKeys("someDescription");
        driver.findElement(By.xpath("//div[@class=\"trumbowyg-editor\"]")).sendKeys("someLongDescription");
        driver.findElement(By.xpath("//input[@name=\"head_title[en]\"]")).sendKeys("gr8Product");
        driver.findElement(By.xpath("//input[@name=\"meta_description[en]\"]")).sendKeys("Meta Description");

        driver.findElement(By.xpath("//a[@href=\"#tab-prices\"]")).click();
        WebElement price =  driver.findElement(By.xpath("//input[@name=\"purchase_price\"]"));
        price.clear();
        price.sendKeys("100");
        select = new Select(driver.findElement(By.xpath("//select[@name=\"purchase_price_currency_code\"]")));
        select.selectByVisibleText("US Dollars");

        driver.findElement(By.xpath("//button[@name=\"save\"]")).click();
        List<WebElement> elements = driver.findElements(By.xpath("//td/a[text()=\""+ productName +"\"]"));
        assertEquals(1, elements.size());
    }


    @AfterAll
    static void tearDown(){
        driver.quit();
    }

}

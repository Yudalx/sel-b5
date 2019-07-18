//package tests;
//
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class Task_11 {
//    private static WebDriver driver;
//
//    @BeforeAll
//    static void setUp(){
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    }
//
//    @Test
//    void task_11() {
//        //регистрация
//        String email = Math.random()+"@mail.ru";
//        String password = "123qwe";
//        driver.get("http://litecart.stqa.ru");//порт 85, 80 занят на рабочем пк
//        driver.findElement(By.xpath("//a[text() = \"New customers click here\"]")).click();
//        driver.findElement(By.xpath("//input[@name=\"firstname\"]")).sendKeys("someFirstName");
//        driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("someLastName");
//        driver.findElement(By.xpath("//input[@name=\"address1\"]")).sendKeys("someAddress");
//        driver.findElement(By.xpath("//input[@name=\"address1\"]")).sendKeys("someAddress");
//        driver.findElement(By.xpath("//input[@name=\"postcode\"]")).sendKeys("45678");
//        driver.findElement(By.xpath("//input[@name=\"city\"]")).sendKeys("MyCity");
//        driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys(email);
//        driver.findElement(By.xpath("//input[@name=\"phone\"]")).sendKeys("789456123");
//        WebElement selectCountry =  driver.findElement(By.xpath("//select[@name=\"country_code\"]"));
//        Select select = new Select(selectCountry);
//        select.selectByVisibleText("United States");
//        WebElement selectState = driver.findElement(By.xpath("//select[@name=\"zone_code\"]"));
//        select = new Select(selectState);
//        select.selectByVisibleText("Arizona");
//        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(password);
//        driver.findElement(By.xpath("//input[@name=\"confirmed_password\"]")).sendKeys(password);
//        driver.findElement(By.xpath("//button[@name=\"create_account\"]")).click();
//
//        //логаут
//        driver.findElement(By.xpath("//a[text()=\"Logout\"]")).click();
//
//        //логин
//        driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys(email);
//        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(password);
//        driver.findElement(By.xpath("//button[@name=\"login\"]")).click();
//        driver.findElement(By.xpath("//a[text()=\"Logout\"]")).click();
//    }
//
//
//    @AfterAll
//    static void tearDown(){
//       driver.quit();
//    }
//}

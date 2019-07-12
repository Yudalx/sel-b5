//import helpers.TestBase;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.parallel.Execution;
//import org.junit.jupiter.api.parallel.ExecutionMode;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import java.util.List;
//
//import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//@Execution(ExecutionMode.CONCURRENT)
//public class Task_17 extends TestBase {
//
//
//    @Test
//    void task_17() {
//        driver.get("http://localhost:85/litecart/admin");//порт 85, 80 занят на рабочем пк
//        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("admin");
//        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin");
//        driver.findElement(By.xpath("//button[@name=\"login\"]")).click();
//        assertEquals("My Store", driver.getTitle());
//
//        driver.findElement(By.xpath("//span[text()=\"Catalog\"]")).click();
//        driver.findElement(By.xpath("//td/a[text()=\"Rubber Ducks\"]")).click();
//        List<WebElement> productList = driver.findElements(By.xpath("//tr[@class=\"row\"]/td/img/following-sibling::a"));
//
//        for(int i =0; i < productList.size(); i++){
//
//            productList.get(i).click();
//            assertEquals(0, driver.manage().logs().get("browser").getAll().size());
//            WebElement table = webDriverWait.until((WebDriver d) -> d.findElement(By.xpath("//table[@id=\"table-images\"]")));
//            driver.navigate().back();
//            webDriverWait.until(stalenessOf(table));
//            productList = driver.findElements(By.xpath("//tr[@class=\"row\"]/td/img/following-sibling::a"));
//        }
//    }
//
//
//
//
//}

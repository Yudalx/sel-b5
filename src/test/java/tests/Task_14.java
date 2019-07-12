//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import java.util.List;
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class Task_14 {
//    private static WebDriver driver;
//    private static WebDriverWait wait;
//
//    @BeforeAll
//    static void setUp(){
//        driver = new ChromeDriver();
//        wait = new WebDriverWait(driver, 20);
//        driver.get("http://localhost:85/litecart/admin");//порт 85, 80 занят на рабочем пк
//        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("admin");
//        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin");
//        driver.findElement(By.xpath("//button[@name=\"login\"]")).click();
//        assertEquals("My Store", driver.getTitle());
//
//    }
//
//    @Test
//    void task_14() {
//        String oldWindow = driver.getWindowHandle();
//        driver.findElement(By.xpath("//span[text()=\"Countries\"]")).click();
//        driver.findElement(By.xpath("//a[text()=\" Add New Country\"]")).click();
//        List<WebElement> elementList = driver.findElements(By.xpath("//td/a[@target=\"_blank\"]"));
//        for(int i = 0; i < elementList.size(); i++){
//            elementList.get(i).click();
//            wait.until((WebDriver d) -> d.findElement(By.xpath("//title")));
//            driver.switchTo().window(getNewWindowHandle(driver, oldWindow));
//            wait.until((WebDriver d) -> d.findElement(By.xpath("//title")));
//            driver.close();
//            driver.switchTo().window(oldWindow);
//            elementList = driver.findElements(By.xpath("//td/a[@target=\"_blank\"]"));
//        }
//
//    }
//
//    @AfterAll
//    static void tearDown(){
//        driver.quit();
//    }
//
//    private String getNewWindowHandle(WebDriver driver,String oldHandle){
//        Set<String> windowHandlers = driver.getWindowHandles();
//        windowHandlers.remove(oldHandle);
//        return windowHandlers.size() > 0 ? windowHandlers.iterator().next() : null;
//    }
//}

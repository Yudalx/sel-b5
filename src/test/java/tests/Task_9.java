//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class Task_9 {
//    private static WebDriver driver;
//
//    @BeforeAll
//    static void setUp(){
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get("http://localhost:85/litecart/admin");//порт 85, 80 занят на рабочем пк
//        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("admin");
//        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin");
//        driver.findElement(By.xpath("//button[@name=\"login\"]")).click();
//        assertEquals("My Store", driver.getTitle());
//
//    }
//
//    @Test
//    void task_9_1_a() {
//        driver.get("http://localhost:85/litecart/admin/?app=countries&doc=countries");
//        WebElement table = driver.findElement(By.xpath("//table[@class = \"dataTable\"]"));
//
//        List<WebElement> nameColumn = table.findElements(By.xpath(".//tr[@class = \"row\"]/td[5]"));
//
//        List<String> countryName = new ArrayList<>();
//
//        for(WebElement element : nameColumn){
//            countryName.add(element.getText());
//        }
//
//        List<String> countryNameSorted = new ArrayList<>(countryName);
//        Collections.sort(countryNameSorted);
//
//        for(int i = 0; i < countryName.size(); i++){
//            assertEquals(countryNameSorted.get(i), countryName.get(i));
//        }
//    }
//
//    @Test
//    void task_9_1_b() {
//        driver.get("http://localhost:85/litecart/admin/?app=countries&doc=countries");
//        WebElement table = driver.findElement(By.xpath("//table[@class = \"dataTable\"]"));
//
//        List<WebElement> nameColumn = table.findElements(By.xpath(".//tr[@class = \"row\"]/td[6]"));
//
//        List<String> zoneLinks = new ArrayList<>();
//
//        for (WebElement element : nameColumn) {
//
//            if (Integer.parseInt(element.getText()) > 0) {
//                zoneLinks.add(element.findElement(By.xpath(".//following-sibling::td/a")).getAttribute("href"));
//            }
//        }
//        for(String s : zoneLinks){
//            driver.get(s);
//            List<WebElement> elementList = driver.findElements(By.xpath("//input[@type = \"hidden\" and contains(@name, \"name\")]"));
//
//            List<String> zoneName = new ArrayList<>();
//
//            for(WebElement element : elementList){
//                zoneName.add(element.getAttribute("value"));
//            }
//
//        List<String> zoneNameSorted = new ArrayList<>(zoneName);
//        Collections.sort(zoneNameSorted);
//
//        for(int i = 0; i < zoneName.size(); i++){
//            assertEquals(zoneNameSorted.get(i), zoneName.get(i));
//        }
//        }
//    }
//
//    @Test
//    void task_9_2(){
//        driver.get("http://localhost:85/litecart/admin/?app=geo_zones&doc=geo_zones");
//        List<WebElement> elementList = driver.findElements(By.xpath("//tr[@class=\"row\"]/td/a[@title=\"Edit\"]"));
//        List<String> linkList = new ArrayList<>();
//
//        for(WebElement element : elementList){
//           linkList.add(element.getAttribute("href"));
//        }
//
//        for(String s : linkList){
//            driver.get(s);
//
//            List<String> zoneNames = new ArrayList<>();
//            List<WebElement> zoneList = driver.findElements(By.xpath("" +
//                    "//select[contains(@name, \"zone_code\")]/option[@selected = \"selected\"]"));
//
//            assertTrue(zoneList.size() > 0);
//
//            for(WebElement element : zoneList){
//                zoneNames.add(element.getAttribute("textContent"));
//            }
//
//            List<String> zoneNamesSorted = new ArrayList<>(zoneNames);
//            Collections.sort(zoneNamesSorted);
//
//            for(int i = 0; i < zoneNames.size(); i++){
//                assertEquals(zoneNamesSorted.get(i), zoneNames.get(i));
//            }
//        }
//    }
//
//    @AfterAll
//    static void tearDown(){
//        driver.quit();
//    }
//}

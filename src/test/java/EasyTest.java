import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EasyTest {

    private static WebDriver driver;

    @BeforeAll
    static void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
     void easyTest(){
        driver.get("http://localhost:85/litecart/admin");//порт 85, 80 занят на рабочем пк
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@name=\"login\"]")).click();
        assertEquals("My Store", driver.getTitle());

        driver.findElement(By.xpath("//a/span[text() = \"Appearence\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Template\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id=\"doc-template\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Template\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id=\"doc-logotype\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Logotype\"]"))).isDisplayed());


        driver.findElement(By.xpath("//a/span[text() = \"Catalog\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Catalog\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-catalog\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Catalog\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-product_groups\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Product Groups\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-option_groups\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Option Groups\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-manufacturers\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Manufacturers\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-suppliers\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Suppliers\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-delivery_statuses\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Delivery Statuses\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-sold_out_statuses\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Sold Out Statuses\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-quantity_units\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Quantity Units\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-csv\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" CSV Import/Export\"]"))).isDisplayed());


        driver.findElement(By.xpath("//a/span[text() = \"Countries\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Countries\"]"))).isDisplayed());

        driver.findElement(By.xpath("//a/span[text() = \"Currencies\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Currencies\"]"))).isDisplayed());


        driver.findElement(By.xpath("//a/span[text() = \"Customers\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Customers\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-customers\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Customers\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-csv\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" CSV Import/Export\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-newsletter\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Newsletter\"]"))).isDisplayed());


        driver.findElement(By.xpath("//a/span[text() = \"Geo Zones\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Geo Zones\"]"))).isDisplayed());


        driver.findElement(By.xpath("//a/span[text() = \"Languages\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Languages\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-languages\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Languages\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-storage_encoding\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Storage Encoding\"]"))).isDisplayed());


        driver.findElement(By.xpath("//a/span[text() = \"Modules\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Job Modules\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-jobs\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Job Modules\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-customer\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Customer Modules\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-shipping\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Shipping Modules\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-payment\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Payment Modules\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-order_total\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Order Total Modules\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-order_success\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Order Success Modules\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-order_action\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Order Action Modules\"]"))).isDisplayed());


        driver.findElement(By.xpath("//a/span[text() = \"Orders\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Orders\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-orders\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Orders\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-order_statuses\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Order Statuses\"]"))).isDisplayed());


        driver.findElement(By.xpath("//a/span[text() = \"Pages\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Pages\"]"))).isDisplayed());


        driver.findElement(By.xpath("//a/span[text() = \"Reports\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Monthly Sales\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-monthly_sales\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Monthly Sales\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-most_sold_products\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Most Sold Products\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-most_shopping_customers\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Most Shopping Customers\"]"))).isDisplayed());


        driver.findElement(By.xpath("//a/span[text() = \"Settings\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Settings\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-store_info\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Settings\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-defaults\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Settings\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-general\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Settings\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-listings\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Settings\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-images\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Settings\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-checkout\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Settings\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-advanced\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Settings\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-security\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Settings\"]"))).isDisplayed());


        driver.findElement(By.xpath("//a/span[text() = \"Slides\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Slides\"]"))).isDisplayed());


        driver.findElement(By.xpath("//a/span[text() = \"Tax\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Tax Classes\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-tax_classes\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Tax Classes\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-tax_rates\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Tax Rates\"]"))).isDisplayed());


        driver.findElement(By.xpath("//a/span[text() = \"Translations\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Search Translations\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-search\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Search Translations\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-scan\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Scan Files For Translations\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-csv\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" CSV Import/Export\"]"))).isDisplayed());


        driver.findElement(By.xpath("//a/span[text() = \"Users\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" Users\"]"))).isDisplayed());

        driver.findElement(By.xpath("//a/span[text() = \"vQmods\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" vQmods\"]"))).isDisplayed());

        driver.findElement(By.xpath("//li[@id= \"doc-vqmods\"]")).click();
        assertTrue(driver.findElement((By.xpath("//h1[text() = \" vQmods\"]"))).isDisplayed());

    }

    @AfterAll
    static void tearDown(){
        driver.quit();
    }
}

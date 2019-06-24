import helpers.TestBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task_19 extends TestBase {

    @Test
    void task_19() {

        app.addProductsToBasket();
        app.removeProductsFromBasket();
        //driver.get("http://litecart.stqa.ru");//порт 85, 80 занят на рабочем пк
//        driver.findElement(By.xpath("//li[contains(@class, \"product\")]")).click();
//        WebElement basket = driver.findElement(By.xpath("//span[@class=\"quantity\"]"));
//        int productQuantity = 0;
//        assertEquals(productQuantity, Integer.parseInt(basket.getText()));
//
//        useSelectSizeIfPresent("//select[@name=\"options[Size]\"]");
//        driver.findElement(By.xpath("//button[@name=\"add_cart_product\"]")).click();
//        webDriverWait.until(ExpectedConditions.attributeContains(basket, "textContent", "1"));
//
//        driver.navigate().back();
//        webDriverWait.until(stalenessOf(basket));
//
//        driver.findElement(By.xpath("//li[contains(@class, \"product\")]")).click();
//        useSelectSizeIfPresent("//select[@name=\"options[Size]\"]");
//        driver.findElement(By.xpath("//button[@name=\"add_cart_product\"]")).click();
//        basket = driver.findElement(By.xpath("//span[@class=\"quantity\"]"));
//        webDriverWait.until(ExpectedConditions.attributeContains(basket, "textContent", "2"));
//
//        driver.navigate().back();
//        webDriverWait.until(stalenessOf(basket));
//
//        driver.findElement(By.xpath("//li[contains(@class, \"product\")]")).click();
//        useSelectSizeIfPresent("//select[@name=\"options[Size]\"]");
//        basket = driver.findElement(By.xpath("//span[@class=\"quantity\"]"));
//        driver.findElement(By.xpath("//button[@name=\"add_cart_product\"]")).click();
//        webDriverWait.until(ExpectedConditions.attributeContains(basket, "textContent", "3"));
//
//        driver.findElement(By.xpath("//div[@id=\"cart\"]/a[text() =\"Checkout »\"]")).click();
//        List<WebElement> products = driver.findElements(By.xpath("//li[@class=\"item\"]"));
//        List<WebElement> productList = driver.findElements(By.xpath("//td[@class=\"item\"]"));
//
//        while(products.size() > 0){
//            assertEquals(products.size(), productList.size());
//            webDriverWait.until(ExpectedConditions.visibilityOf(products.get(0)));
//            products.get(0).findElement(By.xpath(".//button[@name=\"remove_cart_item\"]")).click();
//            webDriverWait.until(stalenessOf(products.get(0)));
//            webDriverWait.until(stalenessOf(productList.get(0)));
//            products = driver.findElements(By.xpath("//li[@class=\"item\"]"));
//            productList = driver.findElements(By.xpath("//td[@class=\"item\"]"));
//        }
//
//        assertEquals(products.size(), productList.size());
//    }
////
////    @AfterAll
////    static void tearDown(){
////        driver.quit();
////    }
//
//    void useSelectSizeIfPresent(String locator){
//        try {
//            if (driver.findElement(By.xpath(locator)).isDisplayed()) {
//                Select select = new Select(driver.findElement(By.xpath(locator)));
//                select.selectByVisibleText("Small");
//            }
//        }catch (Exception e){}
    }
}

package apps;

import helpers.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasketPage;
import pages.MainPage;
import pages.ProductPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

public class Application {

    EventFiringWebDriver driver;
    WebDriverWait wait;
    private MainPage mainPage;
    private ProductPage productPage;
    private BasketPage basketPage;

    public Application(){
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("w3c", false);
        driver = new EventFiringWebDriver(new ChromeDriver(options));
        wait = new WebDriverWait(driver, 10);
        driver.register(new TestBase.EventListener());
        mainPage = new MainPage(driver);
        productPage = new ProductPage(driver);
        basketPage = new BasketPage(driver);
    }


    public void addProductsToBasket(){
        mainPage.openMainPage();
        mainPage.selectProduct();
        assertEquals(0,mainPage.getBasketProductQuantity());
        productPage.useSelectSizeIfPresent("Small");
        productPage.addToBasket();
        mainPage.waitUntilBasketQuantityChanged(1);
        mainPage.returnToPreviousPage();
        mainPage.selectProduct();
        assertEquals(1,mainPage.getBasketProductQuantity());
        productPage.useSelectSizeIfPresent("Small");
        productPage.addToBasket();
        mainPage.waitUntilBasketQuantityChanged(2);
        mainPage.returnToPreviousPage();
        mainPage.selectProduct();
        productPage.useSelectSizeIfPresent("Small");
        productPage.addToBasket();
        mainPage.waitUntilBasketQuantityChanged(3);
        mainPage.returnToPreviousPage();
    }

    public void removeProductsFromBasket(){
        mainPage.checkoutClick();

        List<WebElement> products = basketPage.getProducts();
        List<WebElement> productList = basketPage.getProductList();

        while(products.size() > 0){
            assertEquals(products.size(), productList.size());
            wait.until(ExpectedConditions.visibilityOf(products.get(0)));
            basketPage.removeButton(products.get(0)).click();
            wait.until(stalenessOf(products.get(0)));
            wait.until(stalenessOf(productList.get(0)));
            products = basketPage.getProducts();
            productList = basketPage.getProductList();
        }

        assertEquals(products.size(), productList.size());
    }

    public void quit(){
        driver.quit();
    }

}
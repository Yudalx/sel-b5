package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

public class MainPage {

    WebDriver driver;
    WebDriverWait wait;

    public MainPage (WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[contains(@class, \"product\")]")
    WebElement product;

    @FindBy(xpath = "//span[@class=\"quantity\"]")
    WebElement basket;

    void openMainPage(){
        driver.get("http://litecart.stqa.ru");//порт 85, 80 занят на рабочем пк
    }

    void selectProduct(){
        product.click();
    }

    int getBasketProductQuantity(){

        try {
           return Integer.parseInt(basket.getText());
        }catch (Exception e) {
            System.out.println("Cant parse basket quantity");}
        return 0;
    }

    void waitUntilBasketQuantityChanged(int value){
        wait.until(ExpectedConditions.attributeContains(basket, "textContent", String.valueOf(value)));
    }

    void returntToPreviousPage(){
        driver.navigate().back();
        wait.until(stalenessOf(basket));
    }



}

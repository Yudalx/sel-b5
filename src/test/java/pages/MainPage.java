package pages;

import helpers.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

public class MainPage extends Page{

    public MainPage ( EventFiringWebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//li[contains(@class, \"product\")]")
    private WebElement product;

    @FindBy(xpath = "//span[@class=\"quantity\"]")
    private WebElement basket;

    @FindBy(xpath = "//div[@id=\"cart\"]/a[text() =\"Checkout »\"]")
    private WebElement checkout;


    public void openMainPage(){
        driver.navigate().to("http://litecart.stqa.ru");
    }

    public void selectProduct(){
        product.click();

    }

    public void checkoutClick(){
        checkout.click();
    }

    public int getBasketProductQuantity(){

        try {
           return Integer.parseInt(basket.getText());
        }catch (Exception e) {
            System.out.println("Cant parse basket quantity");}
        return 0;
    }

    public void waitUntilBasketQuantityChanged(int value){
        wait.until(ExpectedConditions.attributeContains(basket, "textContent", String.valueOf(value)));
    }

    public void returnToPreviousPage(){
        driver.navigate().back();
    }
}

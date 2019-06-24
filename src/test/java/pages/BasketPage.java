package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BasketPage extends Page{

    public BasketPage( EventFiringWebDriver driver ){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getProducts(){
        return driver.findElements(By.xpath("//li[@class=\"item\"]"));
    }

    public List<WebElement> getProductList(){
        return driver.findElements(By.xpath("//td[@class=\"item\"]"));
    }

    public WebElement removeButton(WebElement element){
        return element.findElement(By.xpath(".//button[@name=\"remove_cart_item\"]"));
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends Page{

    public ProductPage( EventFiringWebDriver driver ){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@name=\"add_cart_product\"]")
    private WebElement addToCartButton;

    public void useSelectSizeIfPresent(String selectValue) {
        try {
            if (driver.findElement(By.xpath("//select[@name=\"options[Size]\"]")).isDisplayed()) {
                Select select = new Select(driver.findElement(By.xpath("//select[@name=\"options[Size]\"]")));
                select.selectByVisibleText(selectValue);
            }
        } catch (Exception e) {}
    }

    public void addToBasket(){
        addToCartButton.click();
    }


}

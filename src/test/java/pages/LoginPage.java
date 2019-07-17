package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;

public class LoginPage extends Page {

    public LoginPage(EventFiringWebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private String login;

    @FindBy(xpath = "//a[text() = \"New customers click here\"]")
    public WebElement registrationButton;

    @FindBy(xpath ="//input[@name=\"firstname\"]")
    public WebElement firstNameField;

    @FindBy(xpath = "//input[@name=\"lastname\"]")
    public WebElement lastNameField;

    @FindBy(xpath = "//input[@name=\"address1\"]")
    public WebElement addressField;

    @FindBy(xpath = "//input[@name=\"postcode\"]")
    public WebElement postCodeFiled;

    @FindBy(xpath = "//input[@name=\"city\"]")
    public WebElement cityField;

    @FindBy(xpath = "//input[@name=\"email\"]")
    public WebElement emailField;

    @FindBy(xpath = "//input[@name=\"phone\"]")
    public WebElement phoneFiled;

    @FindBy(xpath = "//select[@name=\"country_code\"]")
    public WebElement contryCode;

    @FindBy(xpath = "//select[@name=\"zone_code\"]")
    public WebElement zoneCode;

    @FindBy(xpath = "//input[@name=\"password\"]")
    public WebElement passwdField;

    @FindBy(xpath = "//input[@name=\"confirmed_password\"]")
    public WebElement confirmPasswdFiled;

    @FindBy(xpath = "//button[@name=\"create_account\"]")
    public WebElement createAccountButtun;

    public void selectCountry(String country){
        new Select(contryCode).selectByVisibleText(country);
    }

    public void selectZone(String zone){
        new Select(zoneCode).selectByVisibleText(zone);
    }

//
//    public void createLogin(){
//        login = System.currentTimeMillis() + "@mail.ru";
//    }
//
//    public String getLogin(){
//        return login;
//    }


//
//            driver.get("http://litecart.stqa.ru");//порт 85, 80 занят на рабочем пк
//        driver.findElement(By.xpath("//a[text() = \"New customers click here\"]")).click();
//        driver.findElement(By.xpath("//input[@name=\"firstname\"]")).sendKeys("someFirstName");
//        driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("someLastName");
//        driver.findElement(By.xpath("//input[@name=\"address1\"]")).sendKeys("someAddress");
//        driver.findElement(By.xpath("//input[@name=\"address1\"]")).sendKeys("someAddress");
//        driver.findElement(By.xpath("//input[@name=\"postcode\"]")).sendKeys("45678");
//        driver.findElement(By.xpath("//input[@name=\"city\"]")).sendKeys("MyCity");
//        driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys(email);
//        driver.findElement(By.xpath("//input[@name=\"phone\"]")).sendKeys("789456123");
//    WebElement selectCountry =  driver.findElement(By.xpath("//select[@name=\"country_code\"]"));
//    Select select = new Select(selectCountry);
//        select.selectByVisibleText("United States");
//    WebElement selectState = driver.findElement(By.xpath("//select[@name=\"zone_code\"]"));
//    select = new Select(selectState);
//        select.selectByVisibleText("Arizona");
//        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(password);
//        driver.findElement(By.xpath("//input[@name=\"confirmed_password\"]")).sendKeys(password);
//        driver.findElement(By.xpath("//button[@name=\"create_account\"]")).click();
//
//    //логаут
//        driver.findElement(By.xpath("//a[text()=\"Logout\"]")).click();
//
//    //логин
//        driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys(email);
//        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(password);
//        driver.findElement(By.xpath("//button[@name=\"login\"]")).click();
//        driver.findElement(By.xpath("//a[text()=\"Logout\"]")).click();
}

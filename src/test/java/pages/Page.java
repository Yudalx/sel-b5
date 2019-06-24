package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
    protected EventFiringWebDriver driver;
    protected WebDriverWait wait;

    public Page(EventFiringWebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }
}

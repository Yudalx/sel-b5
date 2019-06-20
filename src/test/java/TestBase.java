import groovy.json.internal.Chr;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
    public static ThreadLocal<EventFiringWebDriver> tlDriver = new ThreadLocal<>();

    public EventFiringWebDriver driver;
    public WebDriverWait webDriverWait;

    public static class EventListener extends AbstractWebDriverEventListener {


        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {
            super.beforeFindBy(by, element, driver);
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
            super.afterFindBy(by, element, driver);
        }

        @Override
        public void beforeClickOn(WebElement element, WebDriver driver) {
            super.beforeClickOn(element, driver);

        }

        @Override
        public void afterClickOn(WebElement element, WebDriver driver) {
            super.afterClickOn(element, driver);
            System.out.println(driver.manage().logs().get("browser").getAll());
        }

        @Override
        public void onException(Throwable throwable, WebDriver driver) {
            super.onException(throwable, driver);
        }
    }
        @BeforeEach
        void start (){
            if(tlDriver.get() != null){
                driver = tlDriver.get();
                webDriverWait = new WebDriverWait(driver, 10);
                return;
            }
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("w3c", false);
            driver = new EventFiringWebDriver(new ChromeDriver(options));
            driver.register(new EventListener());
            tlDriver.set(driver);
            webDriverWait = new WebDriverWait(driver, 10);

            Runtime.getRuntime().addShutdownHook(
                    new Thread(() -> { driver.quit(); driver = null;}));
        }

        @AfterEach
        void tearDown(){
//            driver.quit();
//            driver = null;
        }

}

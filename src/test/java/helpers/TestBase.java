package helpers;

import apps.Application;
import groovy.json.internal.Chr;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
    private static ThreadLocal<Application> tlApp = new ThreadLocal<>();

    protected Application app;

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
           // System.out.println(driver.manage().logs().get("browser").getAll());
        }

        @Override
        public void onException(Throwable throwable, WebDriver driver) {
            super.onException(throwable, driver);
        }
    }
        @BeforeEach
        void start (){
            if(tlApp.get() != null){
                app = tlApp.get();
                return;
            }

            app = new Application();
            tlApp.set(app);

            Runtime.getRuntime().addShutdownHook(
                    new Thread(() -> { app.quit(); app = null;}));
        }
}

import net.lightbody.bmp.core.har.Har;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
@Execution(ExecutionMode.CONCURRENT)
public class Task_17 extends TestBase{


    @Test
    void task_17() {
        proxy.newHar();
        driver.get("http://litecart.stqa.ru");
        driver.findElement(By.xpath("//li[contains(@class, \"product\")]")).click();
        Har har = proxy.endHar();
        har.getLog().getEntries().forEach(l -> System.out.println("Requst :"+l.getRequest().getUrl() + " StatusCode: "+l.getResponse().getStatus()));
        System.out.println(driver.manage().logs().getAvailableLogTypes());
        System.out.println(driver.manage().logs().get("browser").getAll());

        System.out.println("passed");
    }




}

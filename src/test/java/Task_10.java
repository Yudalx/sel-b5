import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task_10 {
    private static WebDriver driver;

    @BeforeAll
    static void setUp(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    void task_10Test(){
        driver.get("http://localhost:85/litecart");//порт 85, 80 занят на рабочем пк
        WebElement firstProduct = driver.findElement(By.xpath(
                "//div[@id = \"box-campaigns\"]/div/ul/li[contains(@class, \"product\")]"));
        String productNameMP = firstProduct.findElement(By.xpath(".//a/div[@class = \"name\"]")).getText();
        WebElement regularPriceMP = firstProduct.findElement(By.xpath(".//div[@class = \"price-wrapper\"]/s"));
        WebElement campaignPriceMP = firstProduct.findElement(By.xpath(".//div[@class = \"price-wrapper\"]/strong"));
        String regularPriceValMP = regularPriceMP.getText();
        String campaignPriceValMP = campaignPriceMP.getText();
        String colorRegularPriceMP = regularPriceMP.getCssValue("color");
        String colorCampaignPriceMP = campaignPriceMP.getCssValue("color");
        String styleRegularPriceMP = regularPriceMP.getCssValue("text-decoration-line");
        String styleRegularPriceMPIE = regularPriceMP.getCssValue("text-decoration");
        String regularPriceFontSizeMP = regularPriceMP.getCssValue("font-size");
        String campaignPriceFontSizeMP = campaignPriceMP.getCssValue("font-size");
        int boldCampaignPriceMP = Integer.parseInt(campaignPriceMP.getCssValue("font-weight"));

        isColorGray(colorRegularPriceMP);
        isColorRed(colorCampaignPriceMP);
        //проверяем что обычная цена зачеркнута, для IE добавлена проверка
        assertTrue(styleRegularPriceMP.equals("line-through") || styleRegularPriceMPIE.equals("line-through"));
        //проверяем что цена со скидкой bold
        assertTrue(boldCampaignPriceMP >= 600 && boldCampaignPriceMP <=900);
        checkFontIsBigger(regularPriceFontSizeMP, campaignPriceFontSizeMP);

        firstProduct.click();

        String productNamePP = driver.findElement(By.xpath("//h1[@class = \"title\"]")).getText();
        WebElement regularPricePP = driver.findElement(By.xpath("//div[@class = \"price-wrapper\"]/s"));
        WebElement campaignPricePP = driver.findElement(By.xpath("//div[@class = \"price-wrapper\"]/strong"));
        String regularPriceValPP = driver.findElement(By.xpath("//div[@class = \"price-wrapper\"]/s")).getText();
        String campaignPriceValPP = driver.findElement(By.xpath("//div[@class = \"price-wrapper\"]/strong")).getText();

        String styleRegularPricePP = regularPricePP.getCssValue("text-decoration-line");
        String styleRegularPricePPIE = regularPricePP.getCssValue("text-decoration");
        String colorRegularPricePP = regularPricePP.getCssValue("color");
        String colorCampaignPricePP = campaignPricePP.getCssValue("color");
        String boldCampaignPricePP = campaignPricePP.getCssValue("font-weight");
        String regularPriceFontSizePP = regularPricePP.getCssValue("font-size");
        String campaignPriceFontSizePP = campaignPricePP.getCssValue("font-size");

        //проверяем название товара
        assertEquals(productNameMP, productNamePP);
        //проверяем обычную цену
        assertEquals(regularPriceValMP, regularPriceValPP);
        //проверяем цену со скидкой
        assertEquals(campaignPriceValMP, campaignPriceValPP);

        isColorGray(colorRegularPricePP);
        isColorRed(colorCampaignPricePP);
        checkFontIsBigger(regularPriceFontSizePP, campaignPriceFontSizePP);
        //проверяем что обычная цена зачеркнута, для IE добаблена проверка
        assertTrue(styleRegularPricePP.equals("line-through") || styleRegularPricePPIE.equals("line-through"));
        //проверяем что цена со скидкой bold
        assertEquals("700", boldCampaignPricePP);

    }

    @AfterAll
    static void tearDown(){
        driver.quit();
    }
    //проверяем что цвет обычной цены серый
    private void isColorGray(String color){
        String [] array = color.split("\\D+");
        assertTrue(array[1].equals(array[2]) && array[2].equals(array[3]));
    }
    //проверяем что цвет цены со скидкой красный
    private void isColorRed(String color){
        String [] array = color.split("\\D+");
        assertTrue(array[2].equals("0") && array[3].equals("0"));
    }
    //проверяем что шрифт цены со скидкой больше
    private void checkFontIsBigger( String regular, String campaign){
        float regFont = Float.parseFloat(regular.substring(0,regular.length()-2));
        float campFont = Float.parseFloat(campaign.substring(0,campaign.length()-2));
        assertTrue(regFont < campFont);
    }
}

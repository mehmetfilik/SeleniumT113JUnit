package day06_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_BestBuyAssertions {
    //1) Bir class oluşturun: BestBuyAssertions
    //2) https://www.bestbuy.com/ Adresine gidin
    // farkli test method’lari olusturarak asagidaki testleri yapin

    // ○ Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin
    // ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    // ○ logoTest => BestBuy logosunun görüntülendigini test edin
    // ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
    //BestBuy.comBestBuy.com
    //Best Buy | Official Online Store | Shop Now & Save
    //Shop Best Buy for electronics, computers, appliances, cell phones, video games & more new tech. In-store pickup & free 2-day shipping on thousands of items.

    WebDriver driver;

    public void mahserin4Atlisi(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com");
    }

    @Test
    public void test01(){

    // ○ Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin
        mahserin4Atlisi();
        String expectedUrl = "https://www.bestbuy.com";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

    }

    @Test
    public void test02(){
        // ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        mahserin4Atlisi();
        String unExpectedIcerik = "Rest";
        String actualTitle = driver.getTitle();

        Assert.assertFalse(actualTitle.contains(unExpectedIcerik));

    }

}

package testCase12;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

public class TestCase12 extends TestBase {


    //https://www.selenium.dev/downloads/ adresine gidelim
    //Sayfanın resmini alalım
    //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
    //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
    //Documentation webelementinin resmini alalım
    //All versions available in Downloads altında Latest stable release olan linki tıklayalım

    //Açılan pencerede chromedriver'i indirelim
    //ChromeDriver'ı indirebilmem için kontrolüm dışında açılan sayfaya driver'ımı geçirmem gerekiyor.
    //Driver'in indiğini doğrulayalım
    //İndirmiş olduğumuz dosyayı silelim

    //Silindiğini doğrulayalım

    //Not: Bu task'in her adımı için Html rapor oluşturalım(Extent Report)

    @Test
    public void TestCase12() throws IOException {

        //https://www.selenium.dev/downloads/ adresine gidelim
        driver.get("https://www.selenium.dev/downloads/");

        //Sayfanın resmini alalım
        String dosyayolu = "TestOutput/ScreenShot/test12.png";

        TakesScreenshot ts = (TakesScreenshot) driver;

        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyayolu));

        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim

        Actions actions= new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        bekle(2);

        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        driver.findElement(By.xpath("//button[@class='btn btn-dark btn-lg btn-block rounded-0 text-left']")).click();
        bekle(2);
        driver.findElement(By.xpath("(//a[text()='documentation'])[5]")).click();

        //Documentation webelementinin resmini alalım

        WebElement documantation = driver.findElement(By.xpath("//*[text()='ChromeDriver Documentation']"));

        String dosyayolu01 ="TestOutput/ScreenShot/test12a.png";

        FileUtils.copyFile(documantation.getScreenshotAs(OutputType.FILE),new File(dosyayolu01));
        bekle(2);

        //All versions available in Downloads altında Latest stable release olan linki tıklayalım
        driver.findElement(By.xpath("//*[text()='ChromeDriver 112.0.5615.49']")).click();

        //Açılan pencerede chromedriver'i indirelim
        //ChromeDriver'ı indirebilmem için kontrolüm dışında açılan sayfaya driver'ımı geçirmem gerekiyor.
        Set<String> sayfalar  =driver.getWindowHandles();
        String sayfa02= driver.getWindowHandle();
        for (String w: sayfalar){
            if (!w.equals(sayfa02)){
                driver.switchTo().window(w);
            }
        }
        WebElement chrome = driver.findElement(By.xpath("//a[text()='chromedriver_win32.zip']"));
        chrome.click();
        bekle(2);

        //Driver'in indiğini doğrulayalım
        String yukleme =System.getProperty("user.home");
        String dosyayeri = "C:\\Users\\ihsan\\Downloads\\chromedriver_win32 (3).zip";
        String dosyaindimi= yukleme + dosyayeri;

        Assert.assertTrue(Files.exists(Paths.get(dosyaindimi)));

    }
}

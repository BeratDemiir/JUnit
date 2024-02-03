package day14_screenshotextentreports;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ScreenShot extends TestBase {

    /*
     Selenium tum ekran goruntusu nasil alinir?
      --> Tum ekran goruntusu seleniumdan gelen getScreenshotAs methodu ile alinir.
      --> getScreenShotAs method u seleniumdaki TakesScreenShot api indan gelir.
     */

    @Test
    public void screenShot01() throws IOException {

//        1.Techpro education a git ve Sayfanin goruntusunu al
        driver.get("https://www.techproeducation.com");

        //1.) Bu method ile ekran goruntusu alindi
        File goruntu = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        //2.) Almis oldugum ekran goruntusunu belirledigim bir path'e kaydet
        // Note: kayit ismini dinamik yapmak icin date objesi kullandim
        String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir") + "/test-output/EkranGoruntuleri/" + currentDate + "image.png";

        //3.) Goruntum ile dosyayi birlestirip kaydet
        File hedef = new File(path);
        FileUtils.copyFile(goruntu, hedef);

//        2.-“QA” aramasi yap
        driver.findElement(By.id("searchHeaderInput")).sendKeys("Mobile Developer" + Keys.ENTER);

//        3.Acilen sayfanin metnini test et ve ekran goruntusu al: “Search Results for:"qa”
        String expected = "Programs";
        String text = driver.findElement(By.xpath("//*[contains(text(),'Programs')]")).getText();
        Assert.assertTrue(expected.contains(text));

        // Reusable method yardimiyla ekran goruntusunu alalim.
        takeScreenShotOfPage();
    }
}

package day14_screenshotextentreports;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_ScreenShot extends TestBase {

    @Test
    public void screenShots() throws IOException {

//        1.Techpro education a git
        driver.get("https://www.techproeducation.com");

//        2.Sosyal medya elemanlarını goruntusunu al
     WebElement sosyalMedyaIconlari = driver.findElement(By.xpath("//ul[@class='social-links kuculunce-yok']"));
    File image = sosyalMedyaIconlari.getScreenshotAs(OutputType.FILE);
        String currenTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        // ekran görüntüsü kaydetme klasörünün yolu
        String path = System.getProperty("user.dir")+ "/test-output/Screenshots/"+currenTime+"image.png";
        FileUtils.copyFile(image,new File(path));

        WebElement logo = driver.findElement(By.xpath("//img[@src='/logo/headerlogo.svg']"));

        takeScreenshotOfElement(logo);

    }
}

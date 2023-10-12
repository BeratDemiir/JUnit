package day11_javafakerfiles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_FileUpload extends TestBase {

    // Note:  Selenium masaustu aplicationlarini otamasyon edemez
    @Test
    public void fileUploadTest() {

//        https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get(" https://the-internet.herokuapp.com/upload");

//        chooseFile butonuna basalim
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));

//        Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu = System.getProperty("user.home")+ "/OneDrive/Masaüstü/logo.jpeg.png";

        chooseFileButton.sendKeys(dosyaYolu);
        waitFor(3);

//        Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

//        “File Uploaded!” textinin goruntulendigini test edelim.
        String fileUpload = driver.findElement(By.xpath("//h3[.='File Uploaded!']")).getText();
        Assert.assertTrue(fileUpload.contains("File Uploaded!"));
    }
}

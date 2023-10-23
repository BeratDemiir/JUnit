package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Example1_FileDownload extends TestBase {

    @Test
    public void test1() {

        // https://the-internet.herokuapp.com/download adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");

        // some-file.txt dosyasini indirelim
        driver.findElement(By.xpath("//a[.='some-file.txt']")).click();

        // dosyanin basariyla indirilip indirilmedigini test edelim
        String filePath = System.getProperty("user.home")+"/Downloads/some-file.txt";
        boolean indirildimi = Files.exists(Paths.get(filePath));
        Assert.assertTrue(indirildimi);
    }
}

package day13_seleniumexceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementReferenceException extends TestBase {

    // STALE ELEMENT REFERENCE EXCEPTİON
    //   Eski, kullanılamaz durumda, kullanım artık elverişli degil
    //  -Sayfayi yenilediğinizde (refresh())
    //  -Sayfada ileri geri gittimizde

    // COZUM:
    // Elementi tekrar bulmak


    @Test
    public void sERE() {
        driver.get("https://lms.techproeducation.com/");

        // LMS login linkine tikla ve o sayfanin URL inin lms icerdigini test et
        WebElement lmsLogin = driver.findElement(By.xpath("//a[.='Login']"));
        lmsLogin.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("lms"));

        // Tekrar ana sayfaya gel ve LMS
        driver.navigate().back(); // org.openqa.selenium.StaleElementReferenceException

        lmsLogin.click();
        // lmsLoginLink linkini sayfa yenilendikten(back()) sonra kullandigim icin  StaleElementReferenceException aldim
    }

    @Test
    public void sERE1() {
        driver.get("https://lms.techproeducation.com/");

        // LMS login linkine tikla ve o sayfanin URL inin lms icerdigini test et
        WebElement lmsLogin = driver.findElement(By.xpath("//a[.='Login']"));

        driver.navigate().refresh();
        lmsLogin.click();

        // Cozum eski elementi tekrar locate et
        //  driver.findElement(By.xpath("//a[.='Login']"));

    }
}

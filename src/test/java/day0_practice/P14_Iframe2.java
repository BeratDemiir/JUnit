package day0_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P14_Iframe2 extends TestBase {

    @Test
    public void test01() {

        // https://the-internet.herokuapp.com/iframe sayfasina gidin
        driver.get("https://the-internet.herokuapp.com/iframe");

        // An iFrame containing the TinyMCE WYSIWYG Editor basliginin erisilebilir oldugunu test edin ve konsolda yazdirin
        WebElement editorYazisi = driver.findElement(By.xpath("//h3[.='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(editorYazisi.isEnabled());
        System.out.println(editorYazisi.getText());

        // TextBox'A "Merhaba Dunya" yazin
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);
        WebElement textBox = driver.findElement(By.xpath("//body[@id='tinymce']"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya");
        waitFor(2);

        // TextBox'in altinda bulunan 'Elemental Selenium' linkinin gorunur oldugunu test edin ve konsolda yazdirin.
        driver.switchTo().defaultContent();
        WebElement elementalSelenium = driver.findElement(By.xpath("//a[.='Elemental Selenium']"));
        Assert.assertTrue(elementalSelenium.isDisplayed());
        System.out.println(elementalSelenium.getText());
    }
}

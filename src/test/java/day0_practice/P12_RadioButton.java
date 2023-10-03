package day0_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P12_RadioButton extends TestBase {

    // NOTE: RadioButton daki elemanlari en fazla bir defa secebilirsin.


    @Test
    public void test1() {

        // https://demo.guru99.com/test/radic.html adresine gidin
        driver.get("https://demo.guru99.com/test/radic.html");

        // RadioButton elementlerini locate edin
        WebElement Option1 = driver.findElement(By.id("xxx"));
        WebElement Option2 = driver.findElement(By.id("xxx"));
        WebElement Option3 = driver.findElement(By.id("xxx"));

        // Option2'yi secin
       Option2.click();

        // Option2 elementinin secili oldugunu test edelim
        Assert.assertTrue(Option2.isSelected());

        // Option1 ve Option3 elementinin secili olmadigini test edin
        Assert.assertFalse(Option1.isSelected());
        Assert.assertFalse(Option3.isSelected());

    }
}

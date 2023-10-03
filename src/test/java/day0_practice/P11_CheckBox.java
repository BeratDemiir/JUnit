package day0_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P11_CheckBox extends TestBase {

    // NOTE: Check Box daki optionslardan birden fazla secilebilir.

    @Test
    public void test1() {

        // https://demo.guru99.com/test/radic.html adresine gidin
        driver.get("https://demo.guru99.com/test/radic.html");

        // CheckBox elementlerini locate edin
        WebElement checkbox1 = driver.findElement(By.id("xxx"));
        WebElement checkbox2 = driver.findElement(By.id("xxx"));
        WebElement checkbox3 = driver.findElement(By.id("xxx"));

        // checkbox1 ve checkbox3 secili degil ise secin
        if (!checkbox1.isSelected()){
            checkbox1.click();
        } else if (!checkbox3.isSelected()) {
            checkbox3.click();
        }

        // checkbox1 ve checkbox3 elementlerinin secili oldugunu test edelim
        Assert.assertTrue(checkbox1.isSelected());
        Assert.assertTrue(checkbox3.isSelected());

        // checkbox2 elementinin secili olmadigini test edin
        Assert.assertFalse(checkbox2.isSelected());


    }
}

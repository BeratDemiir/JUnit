package day0_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P13_Alerts extends TestBase {

    @Test
    public void test1() {

        driver.get("https://demo.automationtesting.in/Alerts.html");

        WebElement alert = driver.findElement(By.xpath("//*[@onclick='alertbox()']")); // Alert with ok bolumunu locate ettim
        alert.click(); // cıkan yaziya tikladim.
        System.out.println(driver.switchTo().alert().getText());// gelen bildirimi yazdirdim
        driver.switchTo().alert().accept(); // Alerte tamam a bastik

        driver.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
        WebElement alert2 = driver.findElement(By.xpath("//*[@class='btn btn-primary']"));
        alert2.click();
//        System.out.println(driver.switchTo().alert().getText());
//        driver.switchTo().alert().accept();
        waitFor(3);
        driver.switchTo().alert().dismiss();

        driver.findElement(By.xpath("//a[.='Alert with Textbox ']")).click();
        driver.findElement(By.xpath("//*[@onclick='promptbox()']")).click();

        driver.switchTo().alert().sendKeys("TechProEducation");
        waitFor(3);
        driver.switchTo().alert().accept();
        waitFor(3);

        System.out.println(driver.findElement(By.id("demo1")).getText());
        Assert.assertEquals("Hello TechProEducation How are you today",
                driver.findElement(By.id("demo1")).getText());

    }
}

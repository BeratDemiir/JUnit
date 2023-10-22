package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class Example3_WindowHandle extends TestBase {

    @Test
    public void test01() {

        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        driver.findElement(By.xpath("(//img[@class='s-image'])[2]")).click();
        waitFor(3);
        System.out.println(driver.findElement(By.xpath("//span[@id='productTitle']")).getText());
        switchToWindow(0);
        waitFor(3);
        System.out.println(driver.getCurrentUrl());


    }

    @Test
    public void test02() {
        driver.get("https://www.amazon.com");
        waitFor(3);
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        Assert.assertTrue(driver.getTitle().contains("Best Buy"));
        switchToWindow(0);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);
        String java = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]")).getText();
        Assert.assertTrue(java.contains("Java"));
        switchToWindow(1);

        WebElement logo = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
       Assert.assertTrue(logo.isDisplayed());

    }

    @Test
    public void test03() {

        driver.get("https://www.n11.com");
        driver.findElement(By.id("searchData")).sendKeys("oppo"+ Keys.ENTER);
        driver.findElement(By.xpath("(//img[@class='lazy cardImage'])[1]")).click();
        Assert.assertTrue(driver.getTitle().contains("Oppo"));
        System.out.println(driver.getTitle());

    }
}

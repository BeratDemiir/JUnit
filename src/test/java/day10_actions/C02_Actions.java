package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {

    @Test
    public void test1() {

        //  Amazon a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //  Sag ust bolumde bulunan “Account & Lists” menüsüne git “Account” secenegine tikka
        Actions actions = new Actions(driver);
        WebElement accountList = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        actions.moveToElement(accountList).perform();

        driver.findElement(By.linkText("Account")).click();

        //  Acilan sayfanin Title in “Your Account” icerdigini dogrula
        Assert.assertTrue(driver.getTitle().contains("Your Account"));
    }
}

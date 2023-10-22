package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Example1_Actions extends TestBase {

    @Test
    public void test01() {

        driver.get("https://www.amazon.com");
        Actions actions = new Actions(driver);
        WebElement language = driver.findElement(By.xpath("(//span[@class='nav-line-2'])[1]"));

        actions.moveToElement(language).perform();
        driver.findElement(By.xpath("(//div[.='Change country/region.'])[1]")).click();

       WebElement ddm = driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        Select select =new Select(ddm);
        select.selectByVisibleText("Turkey (Türkiye)");

        driver.findElement(By.xpath("(//span[@class='a-text-bold'])[3]")).click();
        waitFor(3);
        driver.findElement(By.xpath("(//span[@class='a-button-inner'])[3]")).click();
        waitFor(3);

        switchToWindow(1);
        Assert.assertTrue(driver.getTitle().contains("Elektronik"));
    }
}

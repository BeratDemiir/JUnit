package day10_actions;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Actions extends TestBase {

    @Test
    public void scrollUpDown() {

        // https://techproeducation.com a git
        driver.get("https://techproeducation.com");

        // Sayfanin altına doğru gidelim
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // ARROW_DOWN PAGE_DOWN dan daha az mesafe aldirir.

        //Sonra sayfanın üstüne doğru gidelim
        actions.sendKeys(Keys.PAGE_UP).perform();
        actions.sendKeys(Keys.PAGE_UP).perform();
        actions.sendKeys(Keys.PAGE_UP).perform();
    }
}

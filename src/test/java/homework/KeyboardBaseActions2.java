package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class KeyboardBaseActions2 extends TestBase {

    @Test
    public void test1() {

        //  https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //  video’yu gorecek kadar asagi inin
        driver.switchTo().frame(0);
        WebElement video = driver.findElement(By.xpath("(//div[@class='render'])[1]"));
        waitFor(10);
        new Actions(driver).clickAndHold(video).moveByOffset(560,315).release().build().perform();
        //  videoyu izlemek icin Play tusuna basin
        //  videoyu calistirdiginizi test edin
    }
}

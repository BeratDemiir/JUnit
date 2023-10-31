package day0_practice;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P25_JSExcutors extends TestBase {


    @Test
    public void test1() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Amazon sayfasina gidin
        driver.get("https://www.amazon.com");

        // Arama bolumnunde selenium aratin
        WebElement searchBox = (WebElement) js.executeScript("return document.querySelector('input[id=twotabsearchtextbox');");
        js.executeScript("arguments[0].value='selenium'",searchBox);

        // Back to top bolumune kadar scroll yapiniz
        WebElement backToTop = (WebElement) js.executeScript("return document.getElementsByClassName('navFooterBackToTopText')[0];");
        js.executeScript("arguments[0].scrollIntoView(true);",backToTop);

        // Back to top bolumune tiklayiniz
        waitFor(2);
        js.executeScript("arguments[0].click();",backToTop);
        waitFor(2);
    }
}

package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_BAExample01 {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        //  Verilen web sayfasına gidin.
        //  https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //  Checkbox1 ve checkbox2 elementlerini locate edin
        WebElement checkbbox1 = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        WebElement checkbbox2 = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));

        //  Checkbox1 seçili değilse onay kutusunu tıklayın
        Thread.sleep(3000);
        if (!checkbbox1.isSelected()) {  //Eger secili degilse
            checkbbox1.click();
        }
        //  Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!checkbbox2.isSelected()) {  //Eger secili degilse
            checkbbox2.click();
        }
    }
}

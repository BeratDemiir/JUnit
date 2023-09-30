package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class TestBase {

    // TestBase i abstract yapmamizin sebebi bu sinifin objesini olusturmak istemiyorum
   //  TestBase testBase = new TestBase(); -> YAPILMAZ
   // Amacim bu sinifi extend etmek ve icindeki hazir methodlari kullanmak
    // driver objesini olustur. Driver ya public yada protected olmali. Sebebi child class larda gorulebilmesi
    protected static WebDriver driver;

    // setUp
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    // tearDown
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}

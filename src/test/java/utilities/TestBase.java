package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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

    //    MULTIPLE WINDOW
    // Bu method 1 parametre alir: Gecis yapmak istedigim sayfanin Title
    // Ornek:
    //   driver.get("https://the-internet.herokuapp.com/windows");
    //   switchToWindow("Nem Window");
    public static void switchToWindow(String targetTitle){
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()){
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)){
                return; // Cik  break;
            }
        }
        driver.switchTo().window(origin);
    }

    // windowNumber sifir dan basliyor.
    // index numarasini parametre olarak alir ve o indexli pencereye gecis yapar.
    public static void switchToWindow(int windowNumber){
        List<String> list = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(windowNumber));
    }

    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

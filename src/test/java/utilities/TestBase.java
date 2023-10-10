package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        // ustteki method yerine asagidakini kullanabiliriz.
        driver=WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    // tearDown
    @After
    public void tearDown() throws Exception {
        waitFor(3);
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
            Thread.sleep(seconds* 1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    //  ACTIONS RIGHT CLICK
    public static void rightClickOnElementActions(WebElement element){
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    //  ACTIONS DOUBLE CLICK
    public static void doubleClick(WebElement element){
        new Actions(driver).doubleClick(element).build().perform();
    }
    // ACTIONS HOVER OVER
    public static void hoverOverOnElementActions(WebElement element){
        // Actions actions = new Actions(driver);
        new Actions(driver).moveToElement(element).perform();
    }
    // ACTIONS SCROLL DOWN
    public static void scrollDownActions(){
        // Actions actions = new Actions(driver);
        new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
    }
    // ACTIONS SCROLL UP
    public static void scrollUpActions(){
        // Actions actions = new Actions(driver);
        new Actions(driver).sendKeys(Keys.PAGE_UP).perform();
    }
   // ACTIONS SCROLL RIGHT
    public static void scrollRightActions(){
        new Actions(driver).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).perform();
    }
    // ACTIONS SCROLL LEFT
    public static void scrollLeftActions(){
        new Actions(driver).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT).perform();
    }
    // ACTIONS DRAG AND DROP
    public static void dragAndDropActions(WebElement source, WebElement target){
        // Actions actions = new Actions(driver);
        new Actions(driver).dragAndDrop(source, target).perform();
    }
    // ACTIONS DRAG AND DROP BY
    public static void dragAndDropByActions(WebElement source, int x, int y){
        // Actions actions = new Actions(driver);
        new Actions(driver).dragAndDropBy(source, x, y).perform();
    }
}

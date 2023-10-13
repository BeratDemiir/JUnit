package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    //         DYNAMIC SELENIUM WAITS:
 // ----------------EXPLİCİT WAİT----------------
    public static WebElement waitForVisibility(WebElement element,int timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(By locator, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static WebElement waitForClickAblility(WebElement element, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForClickAblility(By locator, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void clickWithTimeOut(WebElement element, int timeout){
        for (int i =0; i< timeout; i++){
            try {
                element.click();
                return;
            }catch (WebDriverException e){
                waitFor(1);
            }
        }
    }
    // This can be used when a new page opens
    public static void waitForPageToload(long timeout){
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
           public Boolean apply(WebDriver driver){
               return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
           }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(expectation);
        }catch (Throwable error){
            System.out.println("Timeout waiting for page Load Request to complete after" + timeout + " seconds");
        }
    }
    // -----------FLUENT WAIT--------------
    // params: öğenin xpath'i, saniye cinsinden maksimum zaman aşımı, saniye cinsinden yoklama
    public static WebElement fluentWait(String xpath, int withTimeOut, int pollingEvery){
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(withTimeOut))// her defasinda 3 saniye bekleyin
                .pollingEvery(Duration.ofSeconds(pollingEvery))// her 1 saniyede bir elemani kontrol edin
                .withMessage("Ignoring No Such Element Expection")
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return element;
    }
}

package day0_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.exec.launcher.CommandLauncher;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P04 {

    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Before
    public void setUp() throws Exception {
        driver.get("https://google.com");
    }

    @Test
    public void test01() {
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("The God Father", Keys.ENTER);
    }

    @Test
    public void test02() {
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("Lord of the Rings", Keys.ENTER);
    }
    @Test
    public void test03() {
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("Galatasaray", Keys.ENTER);
    }

    @After
    public void tearDown() throws Exception {
        String[] sonuc = driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");
        System.out.println(sonuc[1]);
    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();
    }
}

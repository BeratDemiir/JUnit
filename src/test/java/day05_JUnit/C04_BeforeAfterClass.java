package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforeAfterClass {

    static WebDriver driver;

    /*
         @BeforeClass ve @AfterClass notasyonlari sadece static method'lar icin calisir.
         @BeforeClass ve @AfterClass kullanirsak olusturdugumuz @Test methodlarin hepsini ayni anda calistirip en son @AfterClass'i calistiririz.
         Ama sadece @Before ve @After kullanirsak her test icin @before ve @after'i kullanilir.
     */
    @BeforeClass
    public static void setUp() {
        System.out.println("Butun test'ler den once calisti.");

    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Butun test'ler den sonra calisti.");
    }

    @Before
    public void setUp01() {
        System.out.println("Her testen once calisir");
    }

    @After
    public void tearDown01() {
        System.out.println("Her testen sonra calisir");
    }

    @Test
    public void test01() {
        System.out.println("Ilk test");
    }

    @Test
    public void test02() {
        System.out.println("Ikinci test");
    }

    @Test
    @Ignore // Bir testi calistirmak istemedigimiz zaman kullanilir.
    public void test03() {
        System.out.println("Ucuncu test");
    }
}

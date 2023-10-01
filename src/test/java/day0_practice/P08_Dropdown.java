package day0_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class P08_Dropdown {

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void testDropdown() throws InterruptedException {

        driver.get("https://www.amazon.com");
        Thread.sleep(3000);
       WebElement dropdown = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select dropdownclick = new Select(dropdown);
        Thread.sleep(3000);
        dropdownclick.selectByVisibleText("Books");
       WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
       search.sendKeys("Java", Keys.ENTER);
       String actualTitle = driver.getTitle();
       String title ="Java";
        Assert.assertTrue(actualTitle.contains(title));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}

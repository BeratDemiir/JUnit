package day0_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class P09_Dropdown {

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test1() {
        driver.get("https://www.amazon.com");
        WebElement dropdown = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select dropdownclick = new Select(dropdown);
        dropdownclick.selectByVisibleText("Baby");
        String varsayilanText = dropdownclick.getFirstSelectedOption().getText();
        System.out.println("varsayilanText = " + varsayilanText);
        Assert.assertEquals("Baby", varsayilanText);

        List<WebElement> tumoptions = dropdownclick.getOptions();
        int sayi = 28;
        int sayi2 = tumoptions.size();
        Assert.assertEquals(sayi, sayi2);
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}

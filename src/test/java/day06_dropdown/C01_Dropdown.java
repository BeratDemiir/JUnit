package day06_dropdown;

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

public class C01_Dropdown {

    WebDriver driver;
// Eger test sinifinda birden fazla method olusturulmussa @Before kullanilir.
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void selectByIndexTest() {

                //   Dogum yilini, ayini, ve gununu su sekilde secer:  2000, january, 10
        //  1. Adim: dropdown elementini locate etmek.
        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));

        // 2. Adim: select objesi olusturun
        Select yearDropdown = new Select(year);
        // 3. Adim: Select object'i kullanarak 3 farkli sekilde secim yapabilirim
                //   select.selectByIndex();  Secenek sirasi 0 dan baslar
                //   select.selectByValue();   option in value degeri ile secim yapilabilir.
                //   select.selectByVisibleText(); Case sensitive buyuk kucuk harfe duyarli
        yearDropdown.selectByIndex(23);

        // Ay secimi
        WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
        Select monthDropdown = new Select(month);
        monthDropdown.selectByValue("0");

        // Gun secimi
        WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
        Select dayDropdown = new Select(day);
        dayDropdown.selectByVisibleText("10");

        /*
           1. Dropdown nedir?
             ==> Dropdown liste olusturmak icin kullanilir. Birden fazla secenegi koyabilecegimiz liste

           2.  Dropdown nasil automate edilir?
             ==> Dropdown i locate ederim
             ==> Select class'i kullaniliarak bir select  object'i olustururum
             ==> Select object'ini uygun method'lar ile istedigim secenegi secerim
         NOT: select object'i olusturma nedenim, dropdownlarin select classi ile olusturulmasi
          3. Tum dropdown seceneklerini nasil print ederiz?

            ==> Tum dropdown elementlerini getOptions() methodu ile listeye koyariz
            ==> Sonra secenekleri loop ile yazdirabiliriz.

          4. Bir secenegin secili oldugunu otomate etmek icin ne yapilir?
          Ornek: Gun olarak 10 u sectik ya secilmedi ise?
          getFirstSelectedOption() secili olan secenegi return eder.
       */
    }

    @Test
    public void printAllTest() {

        // Tum eyalet isimlerini console yazdirin.
        WebElement state = driver.findElement(By.xpath("//select[@id='state']"));
        Select stateDropdown = new Select(state);
       List<WebElement> stateList = stateDropdown.getOptions();
       for (WebElement eachstate : stateList){
           System.out.println(eachstate.getText());
       }
       // Lamda ile cozumu
       //  stateList.stream().forEach(t-> System.out.println(t.getText()));
    }

    @Test
    public void getSelectedOptionsTest() {

        // Select a State nin secilip secilmnedigini kontrol edelim
        WebElement state = driver.findElement(By.xpath("//select[@id='state']"));
        Select stateDropdown = new Select(state);
        String varsayilanText =  stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals("Select a State",  varsayilanText);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}

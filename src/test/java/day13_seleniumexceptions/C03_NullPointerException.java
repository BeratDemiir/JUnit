package day13_seleniumexceptions;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utilities.TestBase;

public class C03_NullPointerException {

    //   NullPointerException
    // Degiskenleri oluşturup instantiate etmediğimizde aliriz(new kelimesini kullanmadigimizda)
    // Ornegin:  WebDriver driver; deyip = new ChromeDriver() demezisek null pointer exception aliriz

    //Solution: COZUM
    // Degiskeni instantiate et

    WebDriver driver ;
    Faker faker;
    @Test
    public void nullPointerTest() {

        driver.get("https://www.techproeducation.com");// java.lang.NullPointerException
    }

    @Test
    public void npe() {
      // Cozumu bu:  faker = new Faker();
        System.out.println(faker.name().fullName());// java.lang.NullPointerException
    }
}

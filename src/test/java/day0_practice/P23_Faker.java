package day0_practice;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P23_Faker extends TestBase {

    @Test
    public void test1() {

        // https://demoqa.com/automation-practice-form sayfasina gidin
        driver.get("https://demoqa.com/automation-practice-form");

        // formu doldurun
        Faker faker = new Faker();
        WebElement form = driver.findElement(By.id("firstName"));
        form.sendKeys(faker.name().firstName()
                ,Keys.TAB
                ,faker.name().lastName()
                ,Keys.TAB
                ,faker.internet().emailAddress()
                ,Keys.TAB
                ,Keys.ARROW_RIGHT
                ,Keys.TAB
                ,faker.number().digits(10)
                ,Keys.TAB
                ,"20 Jul 1980",Keys.ENTER
                ,Keys.TAB
                ,"Maths"
                ,Keys.TAB
                ,Keys.TAB,Keys.TAB,Keys.SPACE
                ,Keys.TAB,Keys.TAB
                ,faker.address().fullAddress());


        waitFor(3);

        // sayfayi kapatin
    }
}

package day0_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class P10_Dropdown extends TestBase {
    @Test
    public void test1() throws InterruptedException {

        // https://the-internet.herokuapp.com/dropdown adresine gidelin.
        driver.get(" https://the-internet.herokuapp.com/dropdown");

        // Index kullanarak option 1 secin ve sectiginiz option'u yazdirin.
      WebElement ddm = driver.findElement(By.id("dropdown"));

        Select select = new Select(ddm);

        select.selectByIndex(1);

       String option1 = select.getFirstSelectedOption().getText();
        System.out.println(option1);

        Thread.sleep(3000);

        // Value kullanarak option 2 secin ve sectiginiz option'u yazdirin.

        select.selectByValue("2");
        Thread.sleep(3000);
       String option2 = select.getFirstSelectedOption().getText();
        System.out.println(option2);

        // Visible text  kullanarak option 1 secin ve sectiginiz option'u yazdirin.

        select.selectByVisibleText("Option 1");
        Thread.sleep(3000);
       String option3 = select.getFirstSelectedOption().getText();
        System.out.println(option3);

        // Tum optionlari yazdirin
       List<WebElement> tumoptionlar = select.getOptions();

       int sayac = 1;
       for (WebElement each : tumoptionlar){
           System.out.println(sayac + ". Option " + each.getText());
           sayac++;
       }

        // dropdown'daki optionlarin toplamsayisinin 3'e esit oldugunu test edin.
        int expected =3;
       int actual = tumoptionlar.size();
        Assert.assertEquals(expected,actual);
    }
}

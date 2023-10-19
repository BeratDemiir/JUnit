package day15_extentreportswebtables;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_WebTables extends TestBase {

    public void ikiParemetreLiTest(int row, int column) {

        //  Task 5 : Iki parametreli bir Java metot oluşturalım: printData
        //   Parameter 1 = row numarasi
        //    Parameter 2 = column numarasi
        //     printData(2,3);  => 2nd satir, 3rd sutun daki datayı print etsin

        driver.get("https://the-internet.herokuapp.com/tables");
        String myXpath = "//table[@id='table1']//tbody//tr["+row+"]//td["+column+"]";
        System.out.println(driver.findElement(By.xpath(myXpath)).getText());
    }

    @Test
    public void printData() {
        ikiParemetreLiTest(2,3);// fbach@yahoo.com
        ikiParemetreLiTest(1,4);// $50.00
    }
}

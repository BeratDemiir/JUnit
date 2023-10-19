package day15_extentreportswebtables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {

    //  https://the-internet.herokuapp.com/tables adresine gidin
    //  Task 1 : Table1’i print edin
    //  Task 2 : 3. Row’ datalarını print edin
    //  Task 3 : Son row daki dataları print edin
    //  Task 4 : 5. Column datalarini print edin

    @Test
    public void table1PrintTest() {

        //  Task 1 : Table1’i print edin

        driver.get("https://the-internet.herokuapp.com/tables");
        String table1 = driver.findElement(By.xpath("//table[@id='table1']")).getText();
        System.out.println("TABLE 1 VERILERI");
        System.out.println(table1);

        List<WebElement> tumVeriler = driver.findElements(By.xpath("//table[@id='table1']//td"));
      //   tumVeriler.forEach(t-> System.out.println(t.getText()));  LAMDA İLE COZUM
        for (WebElement veri : tumVeriler){
            System.out.println(veri.getText());
        }
    }

    @Test
    public void row3Test() {

       // Task 2 : 3. Row’ datalarını print edin

        driver.get("https://the-internet.herokuapp.com/tables");
        String table1 = driver.findElement(By.xpath("//table[@id='table1']//tr[3]")).getText();
        List<WebElement> tumRow3Verileri = driver.findElements(By.xpath("//table[@id='table1']//tr[3]//td"));
        tumRow3Verileri.forEach(t-> System.out.println(t.getText()));
        System.out.println(table1);

    }

    @Test
    public void sonSatirVerileri() {

        //  Task 3 : Son row daki dataları print edin

        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> sonSatirVerileri = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[(last())]//td"));
        sonSatirVerileri.forEach(veri -> System.out.println(veri.getText()));
    }

    @Test
    public void sutun5Test() {

     //   Task 4 : 5. Column datalarini print edin

        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> tumWebSiteler = driver.findElements(By.xpath("//table[@id='table1']//tr//td[5]"));
        tumWebSiteler.forEach(veri -> System.out.println(veri.getText()));
    }
}

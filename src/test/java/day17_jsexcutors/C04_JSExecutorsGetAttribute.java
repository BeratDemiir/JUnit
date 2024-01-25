package day17_jsexcutors;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import utilities.TestBase;

public class C04_JSExecutorsGetAttribute extends TestBase {

    @Test
    public void getValueTest() {

//        https://www.priceline.com/ a git
        driver.get("https://www.priceline.com");

//        Tarih kısmındaki Yazili metinleri al ve yazdır
        getValueByJS("hotelDates");

    }

    @Test
    public void getValueByJSTest() {

        // https://www.priceline.com/ a git
        driver.get("https://www.priceline.com/");

        // 3)Submit butonunu rengini Kirmizi yap

    }
}

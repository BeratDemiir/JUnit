package day07_testbase_alerts_iframes;

import org.junit.Test;
import utilities.TestBase;

public class C05_IFrame extends TestBase {

    @Test
    public void iframeTest() {

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        // Ana sayfadaki "An iframe with a thin black border:" metnindeki black border yazisini oldugunu test edelim
        // Ayrica "Applications lists" yazisinin sayfada oldugunu test edelim
        // Son olarak footer deki "Povered By" yazisinin varligini test edelim
    }
}

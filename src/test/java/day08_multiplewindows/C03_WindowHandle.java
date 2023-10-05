package day08_multiplewindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_WindowHandle extends TestBase {

    @Test
    public void test1() {

        //    1. TechPro education sayfasinin titleinin "Techpro Education" metnini icerdigini test edin
        driver.get("https://www.techproeducation.com");
        Assert.assertTrue(driver.getTitle().contains("TechPro Education"));
        String techProHandle = driver.getWindowHandle();

        //    2. Yeni bir pencerede Amazon sayfasini acip titleinin "Amazon" metnini icerdigini test edin
        waitFor(3);
        driver.switchTo().newWindow(WindowType.WINDOW);// i) yeni pencere olusturur ii) oraya gecis yapar.
        driver.get("https://www.Amazon.com");
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        String amazonHandle = driver.getWindowHandle();

        //    3. Yeni bir pencerede linkedin sayfasini acip titleinin "LinkedIn" metnini icerdigini test edin
        waitFor(3);
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.Linkedin.com");
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));
        String linkedinHandle = driver.getWindowHandle();
        waitFor(3);

        driver.switchTo().window(techProHandle); // TechPro sayfasina geri donmek icin kullanilir.
        waitFor(3);

        driver.switchTo().window(linkedinHandle); // Tekrar linkedin sayfasina gider.
        waitFor(3);
    }
}

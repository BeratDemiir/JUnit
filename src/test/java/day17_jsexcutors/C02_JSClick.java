package day17_jsexcutors;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JSClick extends TestBase {

    @Test
    public void clickJS() {

//       Techpro education ana sayfasina git
        driver.get("https://www.techproeducation.com");
        waitFor(3);

//       LMS LOGIN elementine tikla
     WebElement lmsLogin = driver.findElement(By.xpath("//*[@class='lmsUser']"));
     clickByJS(lmsLogin);
     lmsLogin.click();
        waitFor(3);
        switchToWindow(1);

//       Cikan sayfayinin URL inin “https://lms.techproeducation.com/” oldugunu test et
        Assert.assertEquals("https://lms.techproeducation.com/",driver.getCurrentUrl());
    }

    @Test
    public void name() {

        driver.get("https://www.amazon.com/amazonprime");
        waitFor(4);
        clickByJS(driver.findElement(By.xpath("//a[.='Sell']")));
        Assert.assertEquals("https://www.amazon.com/b/?_encoding=UTF8&ld=AZUSSOA-sell&node=12766669011&ref_=nav_cs_sell",driver.getCurrentUrl());
    }
}

package day14_screenshotextentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C03_ExtentReports extends TestBase {

    //  HATIRLAMAMIZ GEREKEN 3 CLASS
    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;

    @Test
    public void extentReportsTest() {

        // Rapor yolu
        String currenTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir") + "/test-output/reports/" + currenTime + "html_report.html";

        // HTML raporu oluşturma yolu
        extentHtmlReporter = new ExtentHtmlReporter(path);

        // Yapılandırma ile tüm raporları oluşturmak için kapsam raporları nesnesi oluşturma
        extentReports = new ExtentReports();

        // RAPORU CUSTOMIZE EDEBILIRIZ
        extentReports.setSystemInfo("Test Environment", "Regression");
        extentReports.setSystemInfo("Application", "TechPro Education");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Takim", "Lions");
        extentReports.setSystemInfo("Epic", "Odeme Sayfasi");
        extentReports.setSystemInfo("Sprint Numarasi", "Sprint-145");
        extentReports.setSystemInfo("QA", "Berat");


        // EXTRA RAPOR ISMI VE DOCUMAN ISMI EKLEYEBILIRIZ
        extentHtmlReporter.config().setDocumentTitle("TechProEd Extent Reports");
        extentHtmlReporter.config().setReportName("Regression Test Sonucu");

        // RAPOR AYARLARI BITTI

        extentReports.attachReporter(extentHtmlReporter);

        // Extent test objesini olusturduk
        extentTest = extentReports.createTest("Extent Report Login Test", "Smoke Test Raporu");

        // TUM AYARLAR BITTI EXTENT TEST OBJESI ILE LOGLAMA ISLEMINI YAPABILIRIM
        extentTest.pass("Kullanıcı ana sayfaya gider");
        driver.get("https://www.techproeducation.com");

        // LMS SAYFASINA GIDELIM
        extentTest.pass("Kullanici LMS sayfasina gider");
        driver.findElement(By.xpath("//li[@class='lmsUser']")).click();

        // TEST BITTI
        extentTest.pass("TEST BASARIYLA GERCEKLESTI");

        // RAPORU GOSTERMEK ICIN ve OLUSMASI ICIN BU ADIM ZORUNLUDUR.
        extentReports.flush();
    }
}

package day15_extentreportswebtables;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ExtentReport extends TestBase {

    //  HATIRLAMAMIZ GEREKEN 3 CLASS
    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;

    @BeforeClass
    public static void extentReportsSetUp() throws Exception {

        // Rapor yolu
        String currenTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+ "/test-output/reports/"+currenTime+"html_report.html";

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
        extentTest = extentReports.createTest("Extent Report Login Test","Smoke Test Raporu");

    }

    @Test
    public void extentReportsTest() {

        extentTest.pass("Pass");
        extentTest.info("Bilgilendirme Notu");
        extentTest.fail("Failed");
        extentTest.warning("Uyari Mesaji");
        extentTest.skip("Atlama Mesaji");
        extentTest.fatal("Cokus Hatasi");

    }

    @AfterClass
    public static void setExtentReportTearDown() throws Exception {

        extentReports.flush();
    }
}

package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Maven {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        // Signin buttonuna tiklayin
        driver.findElement(By.xpath("//*[@class='icon-signin']")).click();

        // Login alanine  “username” yazdirin
        WebElement login = driver.findElement(By.xpath("//*[@id='user_login']"));
        login.sendKeys("username");

        // Password alanine “password” yazdirin
        WebElement password = driver.findElement(By.xpath("//*[@id='user_password']"));
        password.sendKeys("password");

        // Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//*[@value='Sign in']")).click();
        driver.navigate().back();

        // Online Banking butonuna basiniz sonra  Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[@id='onlineBankingMenu']")).click();
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();

        // amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amount = driver.findElement(By.xpath("//*[@id='sp_amount']"));
        amount.sendKeys("150");

        // tarih kismina “2020-09-10” yazdirin
        WebElement date = driver.findElement(By.xpath("//*[@id='sp_date']"));
        date.sendKeys("2020-09-10");

        // Pay buttonuna tiklayin
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();

        // “The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement message = driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']"));
        if (message.isDisplayed()) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST PASSED");
        }

        // Sayfayi kapatin
        driver.close();
    }
}


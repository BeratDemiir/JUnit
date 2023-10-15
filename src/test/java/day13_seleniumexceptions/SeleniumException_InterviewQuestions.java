package day13_seleniumexceptions;

public class SeleniumException_InterviewQuestions {

    /*
    Interview Questions
Tell me 5 exception that you get.-5 adet selenium da
aldigin exceptions dan bahset.

What type of exceptions do you get in selenium? -
Seleniumda ki align exceptions tiplerinden bahset

What is your solution?-Cozum ne?
What type of waits do you use?- Hangi resit wait kullanirsin?
Which wait do you prefer?- Hangi wait tercih edersin?
Why do you prefer that wait?- Neden onu tercih edersin?
How to you resolve synronization issue?-Senkronizasyon problemini nasil cozersin?

** NoSuchElementException
** TimeOutException
** NullPointerException
InvalidSelectorException
** StaleElementReferenceException
InvalidElementStateException
** WebDriverException
     */

 //          NoSuchElementException:
    //Yanlis locator
    //Popup, yeni pencere, iframe,…
    //Sayfa dolmada problemler ve yavaslamalar
    //Sakli olan elementler

//           Solution: COZUM
    //Locatorin dogrulugunu tekrar kontrol et
    //Manual test ile iframe, yeni pencere, alert,… gibi elementlerin varligini kontrol et.
    //Bekleme problemi olab

//          TimeOutException:
    // Explicit wait kullanildiginda, ve element bulunamadiginda alinir.
    // Explicit wait & yanlis locator-> timeout
    // Explicit wait & doğru locator & sure yeterli degil -> timeout
    // Explicit wait & dogru locator & sure yeterli & iframe var -> time out

//              Solution: COZUM
    // -Sureyi arttirmak
    // -Farkli explicit kullanmak: wait visibilityOfElementLocated YERINE presenceOfElementLocated. Yada javascript executorda ki waiter sayfa geçişlerini beklemek icin kullanabilirim
    // -Locatori tekrar kontrol etmek
    // -Frameworkunde hazir reusable method lar var Bu durumda timeoutexception aldigimda hızlıca o metotlar yardımıyla problemi cozebiliyoruz


//               NullPointerException
    // Degiskenleri oluşturup
    // instantiate etmediğimizde alırız(new kelimesini kullanmadigimizda)
    // Ornegin WebDriver driver;/deyip = new ChromeDriver() demezisek null pointer exception aliriz

 //         Solution: COZUM
    // Degiskeni instantiate et
}

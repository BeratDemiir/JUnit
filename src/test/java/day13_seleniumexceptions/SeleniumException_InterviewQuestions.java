package day13_seleniumexceptions;

public class SeleniumException_InterviewQuestions {

//   Seleniumda aldigin 5 exception?
    // Null pointer, no such element, time out, slale element, reference, web driver

//    Genel olarak exception aldiginda cozum yolun nedir?
    // Hata mesajini oku
    // Genel olarak zamanlama, yanlis locator, iframe hataları olabiliyor
    // Hata mesajina gore exception I cozdukden sonra tekrar kodumu calistirim

//   Selniumda kullandigin waitler nelerdir>
    // Implicit yada explicit yada fluent

//   Hangi waiti tercih edersin?
    // Test Base (Driver sinifinda) implicit wait kullanıyorum.
    // Cogu problemi cozuyor Cozemedigi durumlarda explicit wait kullanıyorum.

//   Neden Explicit wait?
    // Explicit wait element e ozel yazilabilir. Yerel cozum gerektiğinde explicit wait'i kullanmak zorundayiz.

//   Senkronize(bekleme) problemlerini nasıl çözersin?
    // Selenium waitlerini kullanarak. Implicit wait driver im da var, ama yetmedigi durumlarda explicit wait
    // kullanirim. Bu yüzden ReusableMethod sinifimda tekrar tekrar kullanabileceğimiz explicit wait method lari var.
    // Kolaylıkla explicit wait ile bekleme problemlerini cozebuliyoruz.
}

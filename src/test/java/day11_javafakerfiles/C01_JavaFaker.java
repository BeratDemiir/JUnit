package day11_javafakerfiles;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C01_JavaFaker {

    Faker faker;

    @Test
    public void javaFakerTest() {
        // Faker objesi olustur.
        faker = new Faker();

        // Faker objesi ile fake data olustur

        // first name datasi
        String fName = faker.name().firstName();
        System.out.println(fName);

        // last name datasi
        String lName = faker.name().lastName();
        System.out.println(lName);

        // kullanici adi datasi
        String usarname = faker.name().username();
        System.out.println(usarname);

        // meslek isim datasi
        String meslek = faker.name().title();
        System.out.println(meslek);

        // sehir ismi datasi
        String sehir = faker.address().city();
        System.out.println(sehir);

        // eyalet ismi datasi
        String eyalet = faker.address().state();
        System.out.println(eyalet);

        // full adres datasi
        System.out.println(faker.address().fullAddress());

        //  cep telefon numarasi
        System.out.println(faker.phoneNumber().cellPhone());

        // email datasi
        System.out.println(faker.internet().emailAddress());

        // posta kodu
        System.out.println(faker.address().zipCode());

        // rastgele 10 haneli numara
        System.out.println(faker.number().digits(10));

        /*
         TEST DATASI: kullanici adi, sifre, email, sehir, tel no, ...
         Test Datalari kimden alinir?
          -> BA-Business analyst (Acceptance Criteria lari yazar)
          -> Test Lead
          -> Manual Tester
          -> Tech Lead & Team Lead & Dev Lead
          -> Developer
          -> Database
          -> API call lar
          -> Documantasyonlar
          -> Java Faker
          NERDEN GELMEZ?
          -> Kullanicidan
          -> scrum master
         */
    }
}

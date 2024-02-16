package day11_javafakerfiles;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileExist {

    @Test
    public void isExistTest() {
        String userDIR = System.getProperty("user.dir");
        System.out.println(userDIR);

        String userHome = System.getProperty("user.home");
        System.out.println(userHome);

        // logo.jpeg indirip masaustune kaydedin
        String dosyaYolu = userHome + "/OneDrive/Masaüstü/logo.jpeg.png";
        System.out.println(dosyaYolu); //   C:\Users\LENOVO\OneDrive\Masaüstü

        boolean isExist = Files.exists(Paths.get(dosyaYolu));
        System.out.println(isExist); // true
    }
}

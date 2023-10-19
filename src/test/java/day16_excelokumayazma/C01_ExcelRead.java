package day16_excelokumayazma;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ExcelRead {

    @Test
    public void excelReadTest() throws Exception {

        // WorkBook(Excel Dosyasi) > WorkSheet(Sayfa) > Row(Satir) > Cell(Veri Hucresi)

        String path = "./src/test/java/resources/Capitals.xlsx";

        // Dosyayi ac
        FileInputStream fileInputStream = new FileInputStream(path);

        // 1) Excel Dosyasini Ac / WORKBOOK Ac
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        // 2) Sayfayi Ac / Sheet1
      //  Sheet sheet1 = workbook.getSheetAt(0);  index ile gitme
       Sheet sheet1 = workbook.getSheet("Sayfa1");// Sayfa ismi ile gitme

        // Ilk satira git / Row
       Row row1 = sheet1.getRow(0);// Ilk satira git

       //  Ilk satirdaki ilk veriryi al
     Cell cell1 = row1.getCell(0);// ilk hucredeki data yi al

        // O veriyi yazdir
        System.out.println(cell1);// COUNTRY

        // 1. Satir 2. Sutun
      Cell cell12 = sheet1.getRow(0).getCell(1);
        System.out.println(cell12);// CAPITAL

        // 3. Satir 1. Sutun elemani yazdir ve o verinin France oldugunu test et
       String cell31 = sheet1.getRow(2).getCell(0).toString();
        System.out.println(cell31);// France

        Assert.assertEquals("France",cell31);

        // Excel'deki Toplam satir sayisini bul
       int toplamSatirS = sheet1.getLastRowNum()+1;// Son satir numarasi index sifirdan basliyor
        System.out.println(toplamSatirS);// 11

        // kullanilan toplam satir sayisini bul
        int kullanilantoplamSatirS = sheet1.getPhysicalNumberOfRows();
        System.out.println(kullanilantoplamSatirS);

        // Country ve capitals key ve value leri map a al ve print et

        // Variable olusturalim Bu variable exceldeki country,capital verilerini tutacak
        Map<String, String> ulkeBaskentleri = new HashMap<>();
        for (int satirSayisi=1; satirSayisi<kullanilantoplamSatirS; satirSayisi++){
            String country = sheet1.getRow(satirSayisi).getCell(0).toString();
            String capital = sheet1.getRow(satirSayisi).getCell(1).toString();
            ulkeBaskentleri.put(country,capital);
        }
        System.out.println(ulkeBaskentleri);
    }
}

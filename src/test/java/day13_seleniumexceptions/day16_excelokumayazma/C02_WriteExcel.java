package day13_seleniumexceptions.day16_excelokumayazma;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.*;

public class C02_WriteExcel {

    @Test
    public void writeExcelTest() throws IOException {

        //  WorkBook(Excel Dosyasi) > WorkSheet(Sayfa) > Row(Satir) > Cell(Veri Hucresi) > Yaz > Kaydet
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

        // Ilk satir 3. Sutun u create et
      Cell cell3 =  row1.createCell(2);

      // o satira Nufus yaz
        cell3.setCellValue("NUFUS");

        // 2. satir 3. sutuna 450000
        sheet1.getRow(1).createCell(2).setCellValue("450000");

        // 3. satira 3. stuna 35000
        sheet1.getRow(2).createCell(2).setCellValue("350000");

        // yazdigini kaydet
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);
    }
}

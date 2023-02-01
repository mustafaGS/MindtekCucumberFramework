package utilities;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelUtils {

    /**
     * .openExcelFile("TestData", "Sheet1");--> return void
     * .getValue(0,1) --> returns String
     * .setValue(2,6,"Kim") --> returns void
     */

    private static Sheet sheet;
    private static Workbook workbook;
    private static FileInputStream input;
    private static FileOutputStream output;
    private static String path;

    public static void openExcelFile(String fileName, String sheetName) {
        path = System.getProperty("user.dir") + "/src/test/resources/testdata/" + fileName + ".xlsx";

        try {
            input = new FileInputStream(path);  //this object will be  created and will navigate to specific sheet
            workbook = new XSSFWorkbook(input);
            sheet = workbook.getSheet(sheetName);
        } catch (FileNotFoundException e) {
            System.out.println("Excel spreadsheet is invalid" + path);
        } catch (IOException e) {
            System.out.println("Couldn't open Excel");
        }

    }

}

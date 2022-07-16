package utilities;

import configurationFileReader.ConfigReader;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelUtils {

    private static XSSFSheet mSheet;
    private static XSSFSheet mSheet2;
    static ConfigReader configReader;

    public ExcelUtils() {
    }

    public static void readExcelFile() {
        configReader = new ConfigReader();
        if (mSheet != null) {
            return;
        }
        File src = new File(configReader.getExcelFilePath());

        try {
            FileInputStream file = new FileInputStream(src);

            XSSFWorkbook wb = new XSSFWorkbook(file);

            mSheet = wb.getSheetAt(0);
            mSheet2 = wb.getSheetAt(1);

        } catch (Exception ex) {
            System.out.println("You got: " + ex);
        }
    }

    public static String GetCellValueFromSheet2(int row, int column) {
        if (mSheet2 == null) {
            return "";
        }
        XSSFCell cell = mSheet2.getRow(row).getCell(column);
        return cell.getStringCellValue();
    }

    public static String GetCellValue(int row, int column) {
        if (mSheet == null) {
            return "";
        }
        XSSFCell cell = mSheet.getRow(row).getCell(column);
        return cell.getStringCellValue();
    }

    public static String GetRawValue(int row, int column) {
        if (mSheet == null) {
            return "";
        }
        XSSFCell cell = mSheet.getRow(row).getCell(column);
        return cell.getRawValue();
    }
}

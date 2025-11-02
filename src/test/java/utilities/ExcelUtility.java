package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

    public FileInputStream fis;
    public FileOutputStream fos;
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public XSSFRow row;
    public XSSFCell cell;
    public XSSFCellStyle style;
    String path;

    public ExcelUtility(String path) {
        this.path = path;
    }

    // Get number of rows in a sheet
    public int getRowCount(String sheetname) throws IOException {
        fis = new FileInputStream(path);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetname);
        int rowcount = sheet.getLastRowNum();
        workbook.close();
        fis.close();
        return rowcount;
    }

    // Get number of cells in a row
    public int getCellCount(String sheetname, int rownum) throws IOException {
        fis = new FileInputStream(path);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetname);
        row = sheet.getRow(rownum);
        int cellcount = row.getLastCellNum();
        workbook.close();
        fis.close();
        return cellcount;
    }

    // Get data from a specific cell
    public String getCellData(String sheetname, int rownum, int colnum) throws IOException {
        fis = new FileInputStream(path);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetname);
        row = sheet.getRow(rownum);
        cell = row.getCell(colnum);

        String data;

        if (cell == null) {
            data = ""; // Empty cell
        } else if (cell.getCellType() == CellType.STRING) {
            data = cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            data = String.valueOf((int) cell.getNumericCellValue());
        } else if (cell.getCellType() == CellType.BOOLEAN) {
            data = String.valueOf(cell.getBooleanCellValue());
        } else {
            data = ""; // Handle other types or blank
        }

        workbook.close();
        fis.close();
        return data;
    }

    // Write data to a specific cell
    public void setCellData(String sheetname, int rownum, int colnum, String data) throws IOException {
        // Read file
        fis = new FileInputStream(path);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetname);

        if (sheet == null) {
            sheet = workbook.createSheet(sheetname); // Create sheet if not exists
        }

        row = sheet.getRow(rownum);
        if (row == null) {
            row = sheet.createRow(rownum); // Create row if not exists
        }

        cell = row.getCell(colnum);
        if (cell == null) {
            cell = row.createCell(colnum); // Create cell if not exists
        }

        cell.setCellValue(data);

        fis.close(); // Close input before writing

        // Write back to file
        fos = new FileOutputStream(path);
        workbook.write(fos);
        workbook.close();
        fos.close();
    }

    // Check if sheet exists
    public boolean isSheetExist(String sheetname) throws IOException {
        fis = new FileInputStream(path);
        workbook = new XSSFWorkbook(fis);
        int index = workbook.getSheetIndex(sheetname);
        workbook.close();
        fis.close();
        return index != -1;
    }
}

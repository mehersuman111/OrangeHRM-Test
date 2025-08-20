package framework.msOfficeUtility;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelUtility {
    File file;
    public void readDataFromExcel(String fileName, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty(".\\src\\test\\resources\\dataFiles\\excelData\\")+sheetName);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fis);
        XSSFSheet xssfSheet = xssfWorkbook.getSheet(sheetName);
        int totalRows = xssfSheet.getLastRowNum();
        int totalCells = xssfSheet.getRow(1).getLastCellNum();

        for (int r=0; r<totalRows; r++) {
            XSSFRow curRow = xssfSheet.getRow(r);
            for (int c=0; c<totalCells; c++) {
                XSSFCell curCell = curRow.getCell(c);
                System.out.println(curCell.toString()+"\t");
            }
            System.out.println("\n");
        }
        xssfWorkbook.close();
        fis.close();
    }
    public void readDataFromExcel(String fileName, int sheetIndex) throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty(".\\src\\test\\resources\\dataFiles\\excelData\\")+sheetIndex);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fis);
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(sheetIndex);
        int totalRows = xssfSheet.getLastRowNum();
        int totalCells = xssfSheet.getRow(1).getLastCellNum();

        for (int r=0; r<totalRows; r++) {
            XSSFRow curRow = xssfSheet.getRow(r);
            for (int c=0; c<totalCells; c++) {
                XSSFCell curCell = curRow.getCell(c);
                System.out.println(curCell.toString()+"\t");
            }
            System.out.println("\n");
        }
        xssfWorkbook.close();
        fis.close();
    }
    public void writeDataIntoFile(String fileName, String newFileName, String sheetName) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(System.getProperty(".\\src\\test\\resources\\dataFiles\\excelData\\")+newFileName);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        XSSFSheet xssfSheet = xssfWorkbook.createSheet(sheetName);
        XSSFRow row = xssfSheet.createRow(0);
    }
    public void writeDataIntoFile(String testCaseName, boolean testResult, String newFileName, String sheetName) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(System.getProperty(".\\src\\test\\resources\\dataFiles\\excelData\\")+newFileName);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        XSSFSheet xssfSheet = xssfWorkbook.createSheet(sheetName);
        XSSFRow row = xssfSheet.createRow(0);
    }
}
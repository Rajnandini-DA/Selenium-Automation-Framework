package com.comcast.crm.Assignment;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilityforDWS {
	
	public String getDataFromExcelFile(String sheetname , int rowno , int cellno) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\abkmo\\OneDrive\\Documents\\DDt Excel\\TekPyramid_DDT.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetname).getRow(rowno).getCell(cellno).toString();
		wb.close();
		return data;
		
		}

public void setDataFromExcelFile(String sheetname , int rowno , int cellno ,String data) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\abkmo\\OneDrive\\Documents\\DDt Excel\\TekPyramid_DDT.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
	
		Row row = wb.getSheet(sheetname).getRow(rowno);
		Cell cell = row.createCell(cellno);
		cell.setCellType(CellType.STRING);
		cell.setCellValue(data);
		FileOutputStream fos = new FileOutputStream("C:\\Users\\abkmo\\OneDrive\\Documents\\DDt Excel\\TekPyramid_DDT.xlsx");
		wb.write(fos);
		wb.close();
		
		
		
		
		
	}
}

package com.client.ShoppersStack.GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
	String path="";
	String sheetName="";
public String getDataFromExcel(int rowNum,int cellNum) throws EncryptedDocumentException, IOException
{
	FileInputStream fis =new FileInputStream(path);
	Workbook workbook = WorkbookFactory.create(fis);
	Sheet sheet = workbook.getSheet(sheetName);
	Row row = sheet.getRow(rowNum);
	Cell cell = row.getCell(cellNum);
	String value = cell.getStringCellValue();
	workbook.close();
	return value;
}

public void setdataBackInExcel(String data, int rowNum, int cellNum) throws EncryptedDocumentException, IOException
{
	FileInputStream fis =new FileInputStream(path);
	Workbook workbook = WorkbookFactory.create(fis);
	Sheet sheet = workbook.getSheet(sheetName);
	Row row = sheet.getRow(rowNum);
	Cell cell = row.createCell(cellNum,CellType.STRING);
	cell.setCellValue(data);
	FileOutputStream fos=new FileOutputStream(path);
	workbook.write(fos);
	workbook.close();
}
}

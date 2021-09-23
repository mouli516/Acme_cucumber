package com.acme.GenericLibrary;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLibrary {
	
	public String readExcelData(String excelpath,String sheetname,int row,int cell) throws Throwable
	{
		FileInputStream fis = new FileInputStream(excelpath);
		Workbook wb= WorkbookFactory.create(fis);
		String excelvalue = wb.getSheet(sheetname).getRow(row).getCell(cell).toString();
		return excelvalue;
	}
	
	
	public String getpropdata(String key,String propath) throws Throwable
	{
		FileInputStream fis = new FileInputStream(propath);
		Properties pro = new Properties();
		pro.load(fis);
		String propvalue = pro.getProperty(key,"incorret key");
		return propvalue;
		
	}
	
	public int getexcelrowcount(String excelpath,String sheet) throws Throwable
	{
		FileInputStream fis = new FileInputStream(excelpath);
		Workbook wb= WorkbookFactory.create(fis);
		int rownum = wb.getSheet(sheet).getLastRowNum();
		return rownum;
		
	}

}

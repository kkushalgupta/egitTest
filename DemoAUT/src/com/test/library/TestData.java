package com.test.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestData {
	
	private String fileLocation;
	private Workbook workbook=null;
	
	public TestData(String fileLocation){
		this.fileLocation = fileLocation;
	}
	
	private void openDataSheet()
	{
		if(workbook!=null)
			return;
		
		try {
			FileInputStream  excelFile = new FileInputStream(new File(fileLocation));
			workbook = new XSSFWorkbook(excelFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	private ArrayList<String> getHeader(String sheetName)
	{
		ArrayList<String> headerData = new ArrayList<String>(); 
		Sheet givenSheet = workbook.getSheet(sheetName);
		Row header = givenSheet.getRow(0);
		Iterator<Cell> cellIterator = header.iterator();
		//skipping first column
		cellIterator.next();
		
		while(cellIterator.hasNext())
		{
			Cell currentCell = cellIterator.next();
			headerData.add(currentCell.getStringCellValue());
		}
		return headerData;
	}
	
	private ArrayList<String> getRowData(String sheetName, String testCaseID)
	{
		ArrayList<String> rowData = new ArrayList<String>(); 
		Sheet givenSheet = workbook.getSheet(sheetName);
		Iterator<Row> iterator = givenSheet.iterator();

        while (iterator.hasNext()) {
            Row currentRow = iterator.next();
            Iterator<Cell> cellIterator = currentRow.iterator();
            if(cellIterator.next().getStringCellValue().equals(testCaseID))
            {
            	while (cellIterator.hasNext()){
            		Cell currentCell = cellIterator.next();
            		rowData.add(currentCell.getStringCellValue());
            	}
            }
        }
		return rowData;
	}
	
	public HashMap<String,String> getData(String sheetName, String testCaseID)
	{
		openDataSheet();
		ArrayList<String> headerData = getHeader(sheetName);
		ArrayList<String> rowData = getRowData(sheetName,testCaseID);
		HashMap<String,String> data = new HashMap<String,String>();
		for(int i=0;i<headerData.size();i++)
		{
			data.put(headerData.get(i), rowData.get(i));
		}
		
		return data;
		
	}
}
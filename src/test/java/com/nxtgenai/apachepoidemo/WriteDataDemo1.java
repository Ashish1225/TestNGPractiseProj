package com.nxtgenai.apachepoidemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataDemo1 {

	public static void main(String[] args) {

		// create workbook object
		XSSFWorkbook workbook = new XSSFWorkbook();

		// create a sheet inside workbook
		XSSFSheet sheet = workbook.createSheet("MySheet");

		Object[][] data = { { "FirstName", "Location", "Experience" }, { "Ashish", "Firozabad", 3 },
				{ "Mangal", "Delhi", 4 }, { "Praveen", "Banaras", 4 }, { "Sanjay", "Gazipur", 4 },
				{ "Bhupendra", "Ghaiabad", 3 } };

		int rows = data.length;
		System.out.println(rows);

		int columns = data[0].length;
		System.out.println(columns);

		XSSFCellStyle style1 = workbook.createCellStyle();
		// to set the background color into cell
		style1.setFillForegroundColor(IndexedColors.AQUA.getIndex());
		style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		// to set the border at left side
		style1.setBorderLeft(BorderStyle.THICK);
		style1.setLeftBorderColor(IndexedColors.DARK_RED.getIndex());
		// to set the border at Right side
		style1.setBorderRight(BorderStyle.THICK);
		style1.setRightBorderColor(IndexedColors.DARK_RED.getIndex());
		// to set the border at Top side
		style1.setBorderTop(BorderStyle.THICK);
		style1.setTopBorderColor(IndexedColors.DARK_RED.getIndex());
		// to set the border at Bottom side
		style1.setBorderBottom(BorderStyle.THICK);
		style1.setBottomBorderColor(IndexedColors.DARK_RED.getIndex());

		XSSFCellStyle style2 = workbook.createCellStyle();

		// to set the border at left side
		style2.setBorderLeft(BorderStyle.THICK);
		style2.setLeftBorderColor(IndexedColors.DARK_RED.getIndex());
		// to set the border at Right side
		style2.setBorderRight(BorderStyle.THICK);
		style2.setRightBorderColor(IndexedColors.DARK_RED.getIndex());
		// to set the border at Top side
		style2.setBorderTop(BorderStyle.THICK);
		style2.setTopBorderColor(IndexedColors.DARK_RED.getIndex());
		// to set the border at Bottom side
		style2.setBorderBottom(BorderStyle.THICK);
		style2.setBottomBorderColor(IndexedColors.DARK_RED.getIndex());

		for (int r = 0; r < rows; r++) {
			// creating row
			XSSFRow row = sheet.createRow(r);

			for (int c = 0; c < columns; c++) {
				// creating cell
				XSSFCell cell = row.createCell(c);

				Object cellValue = data[r][c];
				if (cellValue instanceof String) {
					cell.setCellValue((String) cellValue);
					if (r == 0) {
						cell.setCellStyle(style1);
					} else {
						cell.setCellStyle(style2);
					}

				} else if (cellValue instanceof Integer) {
					cell.setCellValue((Integer) cellValue);
					if (r == 0) {
						cell.setCellStyle(style1);
					} else {
						cell.setCellStyle(style2);
					}
				} else if (cellValue instanceof Boolean) {
					cell.setCellValue((Boolean) cellValue);
					if (r == 0) {
						cell.setCellStyle(style1);
					} else {
						cell.setCellStyle(style2);
					}
				}
			}
		}

		File file = new File("C:\\Users\\ashu2\\OneDrive\\Desktop\\dataset\\writeDataColor.xlsx");
		try {
			FileOutputStream fos = new FileOutputStream(file);
			workbook.write(fos);
			workbook.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.println("Task Done");
	}
}

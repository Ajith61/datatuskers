package com.hackathon.api.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.hackathon.api.model.DataTable;

public class ExcelHelper {
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = { "schema", "table_name", "column_names" };
	static String SHEET = "DataTable";

	public static boolean hasExcelFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

	public static List<DataTable> excelToDataTable(InputStream is) {
		long id =0;
		String schemaName="";
		String tableName="";
		try {
			Workbook workbook = new XSSFWorkbook(is);

			Sheet sheet = workbook.getSheet(SHEET);
			Iterator<Row> rows = sheet.iterator();

			List<DataTable> datatables = new ArrayList<DataTable>();

			int rowNumber = 0;
			while (rows.hasNext()) {
				String[] columnNameArray = null;
				Row currentRow = rows.next();

				// skip header
				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}

				Iterator<Cell> cellsInRow = currentRow.iterator();

				//DataTable datatable = new DataTable();

				int cellIdx = 0;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();

					switch (cellIdx) {
					//case 0:
					//	datatable.setId((long) currentCell.getNumericCellValue());
					//	break;

					case 0:
						//datatable.setSchema(currentCell.getStringCellValue());
						schemaName=currentCell.getStringCellValue();
						break;

					case 1:
						//datatable.setTableName(currentCell.getStringCellValue());
						tableName = currentCell.getStringCellValue();
						break;

					case 2:
						// tutorial.setColumnName(currentCell.getStringCellValue());
						String columnNames = currentCell.getStringCellValue();
						if (!columnNames.isEmpty()) {
							String listRemover = columnNames.substring(1, columnNames.length() - 1);
							columnNameArray = listRemover.split("[,]", 0);
						}

						break;

					default:
						break;
					}

					cellIdx++;
				}
				for (String columnName : columnNameArray) {
					DataTable datatable = new DataTable();
					id= id+1;
					datatable.setId(id);
					datatable.setSchema(schemaName);
					datatable.setTableName(tableName);
					datatable.setColumnName(columnName);
					datatables.add(datatable);
				}

			}

			workbook.close();

			return datatables;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}
}

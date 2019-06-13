package com.memfactory.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

/**
 * Excel工具类
 * 
 * @author zhairp createDate: 2018-09-13
 */
public final class ExcelUtil {
	private static Logger log = LoggerFactory.getLogger(ExcelUtil.class);

	private ExcelUtil() {
	};

	/**
	 * 读取Excel表格数据
	 * 
	 * @author zhairp createDate: 2018-09-28
	 * @param classPath Excel文件类路径
	 * @return Excel表格数据
	 */
	public static List<List<String>> readExcelData(String classPath) {
		InputStream is = ExcelUtil.class.getClassLoader().getResourceAsStream(classPath);
		if (is == null) {
			is = Thread.currentThread().getContextClassLoader().getResourceAsStream(classPath);
		}
		return readExcelData(is);
	}

	/**
	 * 读取Excel表格数据
	 * 
	 * @author zhairp createDate: 2018-09-28
	 * @param file 本地文件
	 * @return Excel表格数据
	 */
	public static List<List<String>> readExcelData(File file) {
		try {
			// 本地操作
			InputStream is = new FileInputStream(file);
			return readExcelData(is);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 读取Excel表格数据
	 * 
	 * @author zhairp createDate: 2018-09-28
	 * @param file 上传文件
	 * @return Excel表格数据
	 */
	public static List<List<String>> readExcelData(MultipartFile file) {
		try {
			return readExcelData(file.getInputStream());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 按行存储数据,读取excel表格数据 
	 * 1.通过工作簿工厂来创建工作簿，返回Workbook接口对象-支持2003和2007
	 * 2.在工作簿循环遍历工作表,对工作表做出处理;在工作表循环遍历行，对行做出处理;在行中，循环遍历单元格，获取单元格的值;
	 * 然后将列的结果添加到List数组中;将工作表的结果添加到List数组中;将整个工作簿的结果添加到Map中
	 * 
	 * @author zhairp createDate: 2019-06-04
	 * @param is 输入流
	 * @return 工作簿
	 */
	public static Map<Integer, List<List<String>>> resolveExcel(InputStream is) {
		try {
			Map<Integer, List<List<String>>> result = new HashMap<Integer, List<List<String>>>();
			Workbook workbook = WorkbookFactory.create(is);
			// 获取工作簿的工作表个数
			int sheetNum = workbook.getNumberOfSheets();
			for (int i = 0; i < sheetNum; i++) {
				// 根据索引获取指定工作表
				Sheet sheet = workbook.getSheetAt(i);
				// 获取选中表格的首次行号
				int firstRowNum = sheet.getFirstRowNum();
				// 获取选中表格的最后行号
				int lastRowNum = sheet.getLastRowNum();
				List<List<String>> sheetData = new ArrayList<List<String>>();
				for (int j = firstRowNum; j <= lastRowNum; j++) {
					// 获取指定行号的行
					Row row = sheet.getRow(j);
					// 获取选中表格的首次列号
//					short firstCellNum = row.getFirstCellNum();
					// 获取选中表格的最后列号
					short lastCellNum = row.getLastCellNum();
					List<String> rowData = new ArrayList<String>();
					/*
					 * for (short k = firstCellNum; k < lastCellNum; k++) { Cell cell =
					 * row.getCell(k); if (cell == null) { rowData.add("null"); } else {
					 * rowData.add(getCellVal(cell)); } }
					 */
					for (short k = 0; k < lastCellNum; k++) {
						// 获取指定列号的单元格
						Cell cell = row.getCell(k);
						if (cell == null) {
							rowData.add("null");
						} else {
							rowData.add(getCellVal(cell));
						}
					}
					sheetData.add(rowData);
				}
				result.put(i, sheetData);
			}
			return result;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	/**
	 * 
	 * 
	 * 按行存储数据,读取excel表格数据
	 * 
	 * 从代码不难发现其处理逻辑： 1.先用InputStream获取excel文件的io流
	 * 2.然后穿件一个内存中的excel文件HSSFWorkbook类型对象，这个对象表示了整个excel文件。 3.对这个excel文件的每页做循环处理
	 * 4.对每页中每行做循环处理 5.对每行中的每个单元格做处理，获取这个单元格的值 6.把这行的结果添加到一个List数组中
	 * 7.把每行的结果添加到最后的总结果中 8.解析完返回结果对象
	 * 
	 * @author zhairp createDate: 2018-09-28
	 * @param is 输入流
	 * @return Excel文件数据
	 */
	public static List<List<String>> readExcelData(InputStream is) {
		try {
			// HSSFWorkbook 标识整个excel
			HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
			List<List<String>> result = new ArrayList<List<String>>();
			int size = hssfWorkbook.getNumberOfSheets();
			// 循环每一页，并处理当前循环页
			for (int numSheet = 0; numSheet < size; numSheet++) {
				// HSSFSheet 标识某一页
				HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
				if (hssfSheet == null) {
					continue;
				}
				// 处理当前页，循环读取每一行
				for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
					// HSSFRow表示行
					HSSFRow hssfRow = hssfSheet.getRow(rowNum);
					int minColIx = hssfRow.getFirstCellNum();
					int maxColIx = hssfRow.getLastCellNum();
					List<String> rowList = new ArrayList<String>();
					// 遍历改行，获取处理每个cell元素
					for (int colIx = minColIx; colIx < maxColIx; colIx++) {
						// HSSFCell 表示单元格
						HSSFCell cell = hssfRow.getCell(colIx);
						if (cell == null) {
							continue;
						}
						rowList.add(getStringVal(cell));
					}
					result.add(rowList);
				}
			}
			return result;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	/**
	 * 获取这个单元格的值
	 * 
	 * @author zhairp createDate: 2019-05-31
	 * @param cell
	 * @return
	 */
	private static String getStringVal(HSSFCell cell) {
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_BOOLEAN:
			return cell.getBooleanCellValue() ? "TRUE" : "FALSE";
		case Cell.CELL_TYPE_FORMULA:
			return cell.getCellFormula();
		case Cell.CELL_TYPE_NUMERIC:
			// 区分日期还是数字
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				return DateFormatUtils.format(date, "yyyy-MM-dd");
			} else {
				// 是数字，则修改单元格类型为String，然后返回String，这样就保证数字不被格式化了
				cell.setCellType(Cell.CELL_TYPE_STRING);
				return cell.getStringCellValue();
			}
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();
		default:
			return "";
		}
	}

	/**
	 * 获取单元格的值
	 * 
	 * @author zhairp createDate: 2019-06-04
	 * @param cell
	 * @return
	 */
	private static String getCellVal(Cell cell) {
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_BOOLEAN:
			return cell.getBooleanCellValue() ? "TRUE" : "FALSE";
		case Cell.CELL_TYPE_FORMULA:
			return cell.getCellFormula();
		case Cell.CELL_TYPE_NUMERIC:
			// 区分日期还是数字
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				return DateFormatUtils.format(date, "yyyy-MM-dd");
			} else {
				// 是数字，则修改单元格类型为String，然后返回String，这样就保证数字不被格式化了
				cell.setCellType(Cell.CELL_TYPE_STRING);
				return cell.getStringCellValue();
			}
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();
		default:
			return "";
		}
	}

}

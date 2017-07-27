package com.mlb.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/***
 * 功能： 导出excel
 * 
 * @author zhongweisheng
 */
public class ExcelExportUtil {
	// 标题
	private List<String> titleList = new ArrayList<String>();
	private Map<String, String> titleMap = new HashMap<String, String>();
	// 列数据
	// private List<String> columnList = new ArrayList<String>();
	// 行数据
	private List<List<String>> rowList = new ArrayList<List<String>>();

	// 添加标题数据
	public void addTitle(String... title) {
		for (String arg : title) {
			titleList.add(arg);
		}
	}

	// 添加行数据
	public void addOneRow(String... title) {
		List<String> columnList = new ArrayList<String>();
		for (String arg : title) {
			columnList.add(arg);
		}
		rowList.add(columnList);
	}

	// 添加标题数据
	public void addTitle(List<String> list) {
		for (Object arg : list) {
			titleList.add(arg + "");
		}
	}

	public void setTitleMap(Map map) {
		titleMap = map;
	}

	// 添加行数据
	public void addOneRow(List<Object> list) {
		List<String> columnList = new ArrayList<String>();
		for (Object arg : list) {
			if (arg != null) {
				columnList.add(arg.toString());
			} else {
				columnList.add("");
			}
		}
		rowList.add(columnList);
	}

	// 导出 excel 文件
	public void exportExcel(HttpServletResponse response, String excelFileName, String sheetName) {
		try {
			String filename = java.net.URLEncoder.encode(excelFileName, "UTF-8");
			response.reset();
			response.setContentType("application/octet-stream");
			response.addHeader("Content-disposition", "attachment; filename=" + filename);

			Workbook workBook = new XSSFWorkbook();
			Sheet sheet = workBook.createSheet(sheetName);
			Font font = workBook.createFont();
			font.setFontName("Arial");
			font.setFontHeightInPoints((short) 14);
			font.setItalic(true);
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);

			CellStyle rowStyle = workBook.createCellStyle();
			rowStyle.setAlignment(CellStyle.ALIGN_CENTER);
			rowStyle.setFont(font);

			int i = 0;
			int col = 0;
			Row row = sheet.createRow(i);
			int titleIndex = 0;
			Set<Integer> filterSet = new HashSet<Integer>();
			Map<Integer, String> titleIndexMap = new HashMap<Integer, String>();

			for (String title : titleList) {
				// 加入
				titleIndexMap.put(titleIndex, title);
				// 查询分类不导出
				if ("type".equals(title) || "id".equals(title) || "staffId".equals(title) || "time".equals(title)
						|| "ifClear".equals(title) || "remark".equals(title)) {
					filterSet.add(titleIndex);
					titleIndex++;
					continue;
				}
				titleIndex++;
				String temp = titleMap.get(title);
				String value = title;
				if (temp != null) {
					value = temp;
				} else {

				}
				if ("number".equals(title) || "grainType".equals(title) || "recordNumber".equals(title)
						|| "recordType".equals(title)) {
					// 设置列宽度
					sheet.setColumnWidth(col, 5 * 2 * 256);
				} else if ("timeUnit".equals(title)) {
					// 设置列宽度
					sheet.setColumnWidth(col, 6 * 2 * 256);
				} else {
					// 设置列宽度
					sheet.setColumnWidth(col, value.getBytes().length * 2 * 256);
				}
				row.createCell(col++).setCellValue(value);
			}

			row.setRowStyle(rowStyle);
			// CellStyle cellStyleNumber = workBook.createCellStyle();
			// cellStyleNumber.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));

			for (List<String> columnList : rowList) {
				col = 0;
				titleIndex = 0;
				i++;
				row = sheet.createRow(i);
				for (String title : columnList) {
					if (filterSet.contains(titleIndex)) {
						titleIndex++;
						continue;
					} else {

						String notFormat = titleIndexMap.get(titleIndex);
						boolean notNeedFormat = false;
						// 不需要数字格式化的列
						if ("number".equals(notFormat) || "recordNumber".equals(notFormat)) {
							notNeedFormat = true;
						}
						titleIndex++;
						Cell contentCell = row.createCell(col++);

						if (!notNeedFormat && StringUtils.isNotEmpty(title) && isNumeric(title)) {
							if (isInteger(title)) {
								contentCell.setCellValue(Integer.parseInt(title));
							} else {
								contentCell.setCellValue(Double.parseDouble(title));
								CellStyle cellStyle = workBook.createCellStyle();
								DataFormat df = workBook.createDataFormat(); // 此处设置数据格式
								cellStyle.setDataFormat(df.getFormat("###,###,###,##0.00#")); // 小数点后保留两位，可以写
								contentCell.setCellStyle(cellStyle);
							}
							sheet.setColumnWidth(col - 1, 8 * 2 * 256);
						} else {
							contentCell.setCellValue(title);
						}
					}
				}
			}
			// 自适应列宽
			// sheet.autoSizeColumn(1, true);
			workBook.write(response.getOutputStream());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}
	}

	public static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^\\d$");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("^[-|+]?\\d*([.]\\d{0,3})?$");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// double f = 12.200;
		// BigDecimal b = new BigDecimal(f);
		// double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		// System.out.println(f1);
		//
		// DecimalFormat df = new DecimalFormat("0.00");
		// double d = 123.9078d;
		// String db = df.format(d);
		String mm = "2,400.00";
		System.out.println(isInteger(mm) + "");
		String date = "2015-01-02";
		date = date.replaceAll("-", "/");
		System.out.println(date);

	}
}

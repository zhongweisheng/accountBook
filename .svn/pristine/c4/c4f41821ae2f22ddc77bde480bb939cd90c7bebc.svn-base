package fc.wpf.rest.utils;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class ExcelRevenueReportView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> paramMap,
			HSSFWorkbook paramHSSFWorkbook,
			HttpServletRequest paramHttpServletRequest,
			HttpServletResponse paramHttpServletResponse) throws Exception {
		// TODO Auto-generated method stub

		//设置response方式,使执行此controller时候自动出现下载页面,而非直接使用excel打开
		//paramHttpServletResponse.setContentType("APPLICATION/OCTET-STREAM");
		//paramHttpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"" + "excel.xls" + "\"");
		ArrayList logList = (ArrayList) paramMap.get("logList");//从控制器Controller中返回的业务数据

		HSSFSheet sheet = paramHSSFWorkbook.createSheet("tableTitle"); //创建表格

		HSSFRow header = sheet.createRow(0);//定义表格的表头

		header.createCell(0).setCellValue("test");//创建表头列

		HSSFRow row = sheet.createRow(1);  //创建表格行

		row.createCell(0).setCellValue("first"); //创建单元格并且给其赋值

	}

}

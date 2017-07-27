package fc.wpf.rest.utils.excel;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * ExcelUtil
 * 
 * @author RYO
 * @since 2015-02-13
 * @version 1.0
 * @version 2.0 2015-03-22 修改参数传递方式
 * @version 2.1 2015-03-30 1.增加setCellValue的参数纇, 2.整理程式
 * @version 2.2 2015-06-23 增加枚举类调用
 * @version 2.2 2015-06-26 枚举类调用方式有两种
 * @version 2.3 2015-07-10 解决：The maximum number of cell styles was exceeded. You can define up to 4000 styles in a .xls workbook
 * @version 2.4 2015-08-11 HSSFCellStyle 与 HSSFSheet 独立写 (可自定义)
 */
@Slf4j
public class ExcelUtil {
    
    private static HSSFFont defaultFont; // defaultFont
    private static HSSFCellStyle defaultStyle; // defaultStyle
    private static HSSFFontFunc fontFunc;

    /**
     * 透过dto的注释 ,生成excel表 (一次处理一个sheet)
     *  1. 若相同dto使用不同sheetName, dto 需加入private String sheetName (List第一笔自行变更值)
     *  
     * @param dataListArray 
     *          <dto> ex:fc.wpf.rest.report.domain.FCWithdrawActTimeDto
     * @return HSSFWorkbook
     */
    public static HSSFWorkbook creatExcelDataFromDto(List<?>... dataListArray) {

        HSSFWorkbook workbook = new HSSFWorkbook();
        
        fontFunc = new HSSFFontFunc();
        
        defaultFont = workbook.createFont();
        
        defaultStyle = workbook.createCellStyle();

        // begin
        for (List<?> dataList : dataListArray) {

            if (dataList == null || dataList.size() == 0) {
                log.warn("dataListArray : no data!!");
                continue;
            }

            // creat sheet
            Object titleDto = dataList.get(0);
            HSSFSheet sheet = ExcelUtil.getHSSFSheet(workbook, titleDto);
            
            Map<String, CellInfo> tmpMap = new HashMap<String, CellInfo>();

            // title
            ExcelUtil.setTitleRow(workbook, sheet, titleDto, tmpMap);
            
            // detail
            ExcelUtil.setDetailRow(workbook, sheet, dataList, tmpMap);
        }

        return workbook;
    }
    
    /**
     * getHSSFSheet
     * 
     * @param wb
     *            HSSFWorkbook
     * @param titleDto
     *            Object
     * @return HSSFSheet
     */
    private static HSSFSheet getHSSFSheet(HSSFWorkbook wb, Object titleDto) {

        SheetInfo sheetInfo = titleDto.getClass().getAnnotation(SheetInfo.class);

        // creat
        String sheetName = "";

        if (sheetInfo == null || sheetInfo.isUseDtoSheetNme()) {
            try {
                sheetName = (String) PropertyUtils.getProperty(titleDto, "sheetName");
            } catch (Exception e) {
                log.warn("get sheetName err : " + e.getMessage());
            }
        } else {
            sheetName = sheetInfo.name();
        }
        
        HSSFSheet sheet = wb.createSheet(sheetName);
        
        // 冻结表头
        sheet.createFreezePane(0, 1);

        return sheet;
    }
    
    /**
     * setTitleRow
     * 
     * @param workbook
     * @param sheet
     * @param titleDto
     * @param tmpMap
     */
    private static void setTitleRow(HSSFWorkbook workbook, HSSFSheet sheet, Object titleDto, Map<String, CellInfo> tmpMap) {
        HSSFRow titleRow = sheet.createRow(0);
        Field[] titleFields = titleDto.getClass().getDeclaredFields();
        
        // fontStyle
        HSSFFontDto fontDto = new HSSFFontDto(defaultFont);
        fontDto.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//加粗
        
        // curStyle
        HSSFCellStyleDto curStyleDto = new HSSFCellStyleDto(defaultStyle);
        
        HSSFCellStyle curStyle = fontFunc.getCellStyle(workbook, curStyleDto, fontDto);
        
        for (Field field : titleFields) {
            CellInfo info = (CellInfo) field.getAnnotation(CellInfo.class);

            if (info != null) {

                HSSFCell cell = titleRow.createCell(info.index());

                // Width
                sheet.setColumnWidth(info.index(), info.width() * 256);
                // column
                cell.setCellValue(info.columnName());
                // Style
                cell.setCellStyle(curStyle);
                // tmp
                tmpMap.put("get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1), info);
            }
        }
    }
    
    /**
     * setDetailRow
     * 
     * @param workbook
     * @param sheet
     * @param curStyle
     * @param dataList
     * @param tmpMap
     */
    private static void setDetailRow(HSSFWorkbook workbook, HSSFSheet sheet, List<?> dataList,
        Map<String, CellInfo> tmpMap) {
        int index = 1;

        for (Object dto : dataList) {

            HSSFRow row = sheet.createRow((short) index++);

            Method[] methods = dto.getClass().getDeclaredMethods();

            for (Method method : methods) {

                CellInfo info = tmpMap.get(method.getName()); // Getter, Setter

                if (info != null) { // Getter
                    HSSFCell cell = row.createCell(info.index());
                    ExcelUtil.setCellValue(info, cell, dto, method);
                    
                    // fontStyle
                    HSSFFontDto fontDto = new HSSFFontDto(defaultFont);
                    ExcelUtil.setFontStyle(info, fontDto, dto, method);
                    
                    // curStyle
                    HSSFCellStyleDto curStyleDto = new HSSFCellStyleDto(defaultStyle);
                    ExcelUtil.setCellStyle(info, curStyleDto);
                    HSSFCellStyle curStyle = fontFunc.getCellStyle(workbook, curStyleDto, fontDto);
                    cell.setCellStyle(curStyle);
                }
            }
        }
    }
    
    /**
     * setCellValue
     * 
     * @param info
     *            CellInfo
     * @param cell
     *            HSSFCell
     * @param dto
     *            Object
     * @param method
     *            Method
     */
    private static void setCellValue(CellInfo info, HSSFCell cell, Object dto, Method method) {
        try {

            Object obj = method.invoke(dto);

            if (obj instanceof String) {
                String val = obj.toString();

                // isMask
                if (info.isMask()) {
                    if (val.length() > 4) {
                        val = val.substring(0, val.length() - 4).replaceAll("[\\w]", "*")
                                + val.substring(val.length() - 4);
                    }
                }

                cell.setCellValue(val);

            } else if (obj instanceof Integer || obj instanceof Long || obj instanceof BigDecimal) {
                
                // 2015-06-23
                if (CellInfo.class.equals(info.formatEnums())) {
                    cell.setCellValue(Double.parseDouble(String.valueOf((BigDecimal) obj)));
                } else {
                    Method enumMethod;
                    
                    // 2015-06-26 取得方式有两种
                    try {
                        enumMethod = info.formatEnums().getMethod("getNameByCode", new Class[] {Integer.class});
                    } catch (Exception e) {
                        enumMethod = info.formatEnums().getMethod("getNameByValue", new Class[] {int.class});
                    }
                    
                    cell.setCellValue((String) enumMethod.invoke(info.formatEnums(), obj));
                }
                
            } else if (obj instanceof Date) {
                Date date = (Date) obj;
                SimpleDateFormat sdf = new SimpleDateFormat(info.dateStyle().getValue());
                cell.setCellValue(sdf.format(date));

            }  else if (obj instanceof Boolean) {
                cell.setCellValue(Boolean.parseBoolean(obj.toString()));
            } 

        } catch (Exception e) {
            cell.setCellValue("");
        }
    }

    /**
     * @param info
     * @param styleDto
     * @param tmpDto
     * @param method
     */
    private static void setFontStyle(CellInfo info, HSSFFontDto styleDto, Object tmpDto, Method tmpMethod) {

        // 自定义style
        if (!CellInfo.class.equals(info.formatFontStyle())) {
            Method method;
            try {
                method =
                    info.formatFontStyle().getMethod("formatFontStyle",
                        new Class[] {HSSFFontDto.class, Object.class, Method.class});

                method.invoke(info.formatFontStyle(), new Object[] {styleDto, tmpDto, tmpMethod});
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * setCellStyle
     * 
     * @param info
     *            CellInfo
     * @param curStyle
     *            HSSFCellStyle
     */
    private static void setCellStyle(CellInfo info, HSSFCellStyleDto styleDto) {

        if (-1 != info.alignment()) {
            styleDto.setAlignment(info.alignment());
        }

        styleDto.setWrapText(true);
    }
}

package fc.wpf.rest.utils.excel;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * HSSF 自定义方法
 * 
 * @author RYO
 * @since 2015-08-11
 * 
 * @version 1.0 解决：The maximum number of cell styles was exceeded. You can define up to 4000 styles in a .xls workbook
 */
public class HSSFFontFunc {
    
    private List<HSSFFontFunc.dto> tmpList = new ArrayList<HSSFFontFunc.dto>(); // 纪录使用过得style
    
    /**
     * 
     * @param workbook
     * @param styleDto
     * @param fontDto
     * @return
     */
    public HSSFCellStyle getCellStyle(HSSFWorkbook workbook, HSSFCellStyleDto styleDto, HSSFFontDto fontDto) {

        if (!tmpList.isEmpty()) {
            for (HSSFFontFunc.dto dto : tmpList) {
                if (this.equals(dto.getStyle(), styleDto) && this.equals(dto.getFont(), fontDto)) {
                    return dto.getStyle();
                }
            }
        }
        
        HSSFFont font = workbook.createFont();
        fontDto.editHSSFFont(font);
        
        HSSFCellStyle style = workbook.createCellStyle();
        styleDto.editHSSFCellStyle(style, font);
        
        HSSFFontFunc.dto dto = new HSSFFontFunc.dto();
        dto.setFont(font);
        dto.setStyle(style);
        tmpList.add(dto);
        
        return style;
    }
    
    private boolean equals(Object hssf, Object dto) {

        Field[] Fields = dto.getClass().getDeclaredFields();

        for (Field Field : Fields) {
            try {
                if ("font".equals(Field.getName())) {
                    continue;
                }
                
                Object val1 = BeanUtils.getProperty(dto, Field.getName());
                Object val2 = BeanUtils.getProperty(hssf, Field.getName());

                if (val1 instanceof Short) {
                    short a = (short) val1;
                    short b = (short) val2;

                    if (a != b) {
                        return false;
                    }
                } else if (val1 instanceof String) {
                    String a = (String) val1;
                    String b = (String) val2;

                    if (!a.equals(b)) {
                        return false;
                    }
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return true;
    }
    
    @Data
    private class dto {
        private HSSFFont font;

        private HSSFCellStyle style;
    }
}

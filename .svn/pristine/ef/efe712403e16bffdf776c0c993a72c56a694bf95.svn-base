package fc.wpf.rest.utils.excel;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;

import lombok.Data;

/**
 * HSSFCellStyle 对应项目 (视需求, 可再增加)
 * 
 * @author RYO
 * @since 2015-08-11
 * @version 1.0
 */
@Data
public class HSSFCellStyleDto {

    /** 左右位置 */
    private short alignment;

    /** 上下位置 */
    private short verticalAlignment;

    /** 自动换行 */
    private boolean wrapText;

    public HSSFCellStyleDto(HSSFCellStyle style) {
        this.alignment = style.getAlignment();
        this.verticalAlignment = style.getVerticalAlignment();
        this.wrapText = style.getWrapText();
    }

    public void editHSSFCellStyle(HSSFCellStyle style, HSSFFont font) {
        style.setAlignment(this.alignment);
        style.setVerticalAlignment(this.verticalAlignment);
        style.setWrapText(this.wrapText);
        style.setFont(font);
    }
}

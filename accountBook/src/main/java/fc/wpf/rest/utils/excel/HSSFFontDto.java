package fc.wpf.rest.utils.excel;

import org.apache.poi.hssf.usermodel.HSSFFont;

import lombok.Data;

/**
 * HSSFFont 对应项目 (视需求, 可再增加)
 * 
 * @author RYO
 * @since 2015-08-11
 * @version 1.0
 */
@Data
public class HSSFFontDto {

    /** 字体 */
    private String fontName;

    /** 字体大小 */
    private short fontHeightInPoints;

    /** 字体粗细 */
    private short boldweight;

    /** 字体颜色 */
    private short color;

    public HSSFFontDto(HSSFFont font) {
        this.fontName = font.getFontName();
        this.fontHeightInPoints = font.getFontHeightInPoints();
        this.boldweight = font.getBoldweight();
        this.color = font.getColor();
    }
    
    public void editHSSFFont(HSSFFont font) {
        font.setFontName(this.fontName);
        font.setFontHeightInPoints(this.fontHeightInPoints);
        font.setBoldweight(this.boldweight);
        font.setColor(this.color);
    }
}

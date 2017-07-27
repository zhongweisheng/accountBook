package fc.wpf.rest.utils.excel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Excel Sheet 资讯注释
 * 
 * @author RYO
 * @since 2015-03-22
 * 
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SheetInfo {
    
    /** Sheet Name */
    String name();
    
    /** 是否使用dto自定义SheetNme */
    boolean isUseDtoSheetNme()  default false;;
}

package fc.wpf.rest.utils.excel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import fc.wpf.rest.utils.DateStyle;

/**
 * Excel Cell 资讯注释
 * 
 * @author RYO
 * @since 2015-02-13
 * 
 * @version 1.0
 * @version 1.1 2015-06-23 增加枚举类调用
 * @version 1.2 2015-08-10 增加自定义[字形]效果
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface CellInfo {

    /** 列位子 */
    int index();

    /** 第一列名称 */
    String columnName();

    /** 栏宽 */
    int width() default 20;

    /** 是否隐藏只留後四码 (只支援String型态) */
    boolean isMask() default false;

    /** 位置(左,中,右) */
    short alignment() default -1;

    /** format格式 */
    DateStyle dateStyle() default DateStyle.YYYY_MM_DD_HH_MM_SS;
    
    /** 用格式化中文的枚举类 class */
    Class<?> formatEnums() default CellInfo.class;
    
    /** 自定义[字形]效果 class */
    Class<?> formatFontStyle() default CellInfo.class;
}

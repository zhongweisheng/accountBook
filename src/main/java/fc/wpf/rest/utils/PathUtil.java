package fc.wpf.rest.utils;

import java.io.File;

/**
 * PathUtil
 * 
 * @author RYO
 * @since 2015-04-29
 * @version 1.0
 * @version 1.1 RYO 2015-05-04
 */
public class PathUtil {

    private static final String WARNING = "warning";

    /** 音档目录 */
    public static final String soundRootPath = FConfig.getSoundRootPath().trim();

    /**
     * getWarningSoundsPath
     * 
     * @param fileName
     *            档案名称
     * @return path 路径
     */
    public static String getWarningSoundsPath(String fileName) {
        String path =
            new StringBuilder(soundRootPath).append(WARNING).append(File.separator).append(fileName).toString();
        return path;
    }
}

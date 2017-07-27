package fc.wpf.rest.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FConfig {

    private static String CONFIG_PROPERTIES = "config.properties";
    private static Properties properties = null;
    static {

        try {
            if ( properties == null ) {
                log.info( "=============开始加载" + CONFIG_PROPERTIES + "===========" );
                properties = new Properties();
                InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream( CONFIG_PROPERTIES );
                properties.load( is );
                log.info( "=============加载完成" + CONFIG_PROPERTIES + "===========" );
            }
        } catch ( FileNotFoundException e ) {
            e.printStackTrace();
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

    public static void main( String[] args ) {
        System.out.println( 1 );
    }

    public static String getImageRootPath() {
        return properties.getProperty( "imageRootPath" );
    }

    public static String getProceSubmitter() {
        return properties.getProperty( "proceSubmitter" );
    }

    public static String getBmSyskey() {
        return properties.getProperty( "bm_syskey" );
    }

    public static String getHcSyskey() {
        return properties.getProperty( "hc_syskey" );
    }

    public static String getXcSyskey() {
        return properties.getProperty( "xc_syskey" );
    }

    public static String getNcSyskey() {
        return properties.getProperty( "nc_syskey" );
    }

    public static String getProValue( String proName ) {
        return properties.getProperty( proName );
    }

    public static String getErrorSaveFileName() {
        return properties.getProperty( "errorSaveFileName" ).trim();
    }

    public static String getloadCheckProcessName() {
        return properties.getProperty( "loadCheckProcessName" ).trim();
    }

    public static String getSysKey() {
        return properties.getProperty( "sysKey" ).trim();
    }

    public static String getNonCusErrorFlag() {
        return properties.getProperty( "nonCusErrorFlag" ).trim();
    }

    public static String getRiskProcessName() {
        return properties.getProperty( "riskProcessName" ).trim();
    }

    public static String getFinanceProcessName() {
        return properties.getProperty( "financeProcessName" ).trim();
    }

    public static String getExcelRootPath() {
        return properties.getProperty( "excelRootPath" );
    }
    
    public static String getSoundRootPath() {
        return properties.getProperty( "soundRootPath" );
    }

    public static String getRiskAutoTaskTime() {
        return properties.getProperty( "riskAutoTaskTime" );
    }

    public static String getShiftAutoTaskTime() {
        return properties.getProperty( "shiftAutoTaskTime" );
    }

}

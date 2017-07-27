package fc.wpf.rest.utils;

import java.util.HashSet;
import java.util.Set;

public class TradeNoGenerator {

    public synchronized String generate( String cmdType ) {
        return new StringBuffer( 32 ).append( "FC" ).append( format( cmdType ) )
                .append( DateUtil.formatCurrentTime( DateStyle.YYYYMMDDHHMMSSSSS_EN ) ).append( format( getCount() ) ).toString();
    }

    /**
     * 单例对象的获取函数
     * 
     * 
     * @return GUIDHexGenerator
     */
    public static TradeNoGenerator instance() {
        if ( instance == null ) {
            synchronized ( TradeNoGenerator.class ) {
                if ( instance == null ) {
                    instance = new TradeNoGenerator();
                }
            }
        }
        return instance;
    }

    public static String nextID( String cmdType ) {
        return instance().generate( cmdType );
    }

    private static volatile TradeNoGenerator instance;

    private static String format( String str ) {
        StringBuffer buf = new StringBuffer( "0000" );
        buf.replace( 4 - str.length(), 4, str );
        return buf.toString();
    }

    private static short counter = (short) 0;

    protected short getCount() {
        counter++;
        if ( counter < 0 ) {
            counter = 0;
        }
        return counter;
    }

    protected String format( short shortval ) {
        String formatted = Integer.toHexString( shortval );
        StringBuffer buf = new StringBuffer( "0000" );
        buf.replace( 4 - formatted.length(), 4, formatted );
        return buf.toString();
    }

    public static void main( String[] args ) {
        Set<String> set = new HashSet<String>();
        for ( int i = 0; i < 4000000; i++ )
            set.add( TradeNoGenerator.nextID( "9" ) );

        System.out.println( set.size() );
    }
}

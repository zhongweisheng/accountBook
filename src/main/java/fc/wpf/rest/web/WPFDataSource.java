package fc.wpf.rest.web;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class WPFDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        // TODO Auto-generated method stub
        return DbContextHolder.getDbType();
    }

}
